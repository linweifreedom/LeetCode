package leetcode.twopointer;

import java.util.Arrays;

/*Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

		 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.*/
public class _435_NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0] == 0 ? i1[1] - i2[1] : i1[0] - i2[0]);
        int left = 0; int right = 1;
        int ans = 0;
        while (right <= intervals.length - 1) {
           if (intervals[left][1] > intervals[right][0]) {
               ans++;
               if (intervals[left][1] > intervals[right][1]) {
                   left = right;
                   right++;
               } else {
                   right++;
               }
                   
           } else {
               left = right;
               right++;
           }
        }
        return ans;
    }
}
