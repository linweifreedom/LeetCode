package leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104*/
public class _1235_MaximumProfitInJobScheduling {
  public int jobSchedulingWithDP(int[] startTime, int[] endTime, int[] profit) {
    List<Job> jobs = new ArrayList<>();
    int n = startTime.length;
    for (int i = 0; i < n; i++) {
        Job job = new Job(startTime[i], endTime[i], profit[i]);
        jobs.add(job);
    }
    jobs.sort((j1, j2) -> j1.endTime - j2.endTime);
    int[] dp = new int[n];
    dp[0] = jobs.get(0).profit;
    for (int i = 1; i < n; i++) {
      Job currentJob = jobs.get(i);
      dp[i] = currentJob.profit;
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (currentJob.startTime >= jobs.get(j).endTime) {
          break;
        }
      }
      if (j >= 0) {
        dp[i] += dp[j];
      }
      dp[i] = Math.max(dp[i], dp[i - 1]);
    }
    return dp[n - 1];
    
  }

  class Job {
      int startTime;
      int endTime;
      int profit;
      
      public Job(int startTime, int endTime, int profit) {
          this.startTime = startTime;
          this.endTime = endTime;
          this.profit = profit;
      }
  }
  
  public int jobSchedulingWithTreeMap(int[] startTime, int[] endTime, int[] profit) {
    
    List<Job> jobs = new ArrayList<>();
    
    for(int i=0; i<startTime.length; i++){
        jobs.add(new Job(startTime[i], endTime[i], profit[i]));
    }
    
    Collections.sort(jobs, (a,b) -> (a.endTime - b.endTime));
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int ans = 0;
    
    for(Job currJob : jobs){
        Integer entryTillStartTime = map.floorKey(currJob.startTime);
        int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
        ans = Math.max(ans, maxProfitTillStartTime + currJob.profit);
        map.put(currJob.endTime, ans);
    }
    return ans;
}
}
