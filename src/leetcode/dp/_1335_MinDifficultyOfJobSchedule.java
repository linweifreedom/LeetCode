package leetcode.dp;

public class _1335_MinDifficultyOfJobSchedule {
  public static int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d)
      return -1;
    int[][][] dp = new int[n][n][d + 1];
    for (int i = 0; i < n; i++) {
      dp[i][i][1] = jobDifficulty[i];
    }
    return minDifficulty(dp, jobDifficulty, 0, n - 1, d);
  }

  public static int minDifficulty(int[][][] dp, int[] jobDifficulty, int left, int right, int d) {
    
    if (right - left + 1 < d || left > right || d == 0)
      return -1;
    if (left == right)
      return jobDifficulty[left];
    if (dp[left][right][d] != 0)
      return dp[left][right][d];
    int minDiff = Integer.MAX_VALUE;
    int leftMax = Integer.MIN_VALUE;
    for (int i = left; i <= right; i++) {
      leftMax = Math.max(leftMax, jobDifficulty[i]);
      if (d > 1) {
        int rightSum = minDifficulty(dp, jobDifficulty, i + 1, right, d - 1);
        if (rightSum != -1) {
          minDiff = Math.min(minDiff, leftMax + rightSum);
        }
      } else
        minDiff = leftMax;
      
      
    }
    dp[left][right][d] = minDiff;
    return minDiff;
  }
  
  public static void main(String[] args) {
    int[] difficulty = {1,1,1};
    System.out.println(minDifficulty(difficulty, 3));
  }
  
  public int minDifficulty2(int[] jobs, int days) {
    int n = jobs.length;
    if(n<days) return -1;
    int[][] dp = new int[n+1][days+1];
    //base
    for(int j=0;j<n+1;j++)     
        for(int d=0;d<days+1;d++) 
            dp[j][d] = Integer.MAX_VALUE;
    dp[0][0] = 0;
    
    
    for(int j=1;j<n+1;j++) {
        for(int d=1;d<days+1;d++) {
            int maxDifficulty = 0;
            for(int k=j-1;k>=d-1;k--) {
                maxDifficulty = Math.max(maxDifficulty,jobs[k]);
                if (dp[k][d-1]!= Integer.MAX_VALUE)
                    dp[j][d] = Math.min(dp[j][d],dp[k][d-1]+maxDifficulty);
            }
        }
    }
        
        
        
    return dp[n][days];
}
}
