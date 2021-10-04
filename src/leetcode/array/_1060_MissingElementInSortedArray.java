package leetcode.array;

/*Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.



Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.*/
public class _1060_MissingElementInSortedArray {

	public int missingElement(int[] nums, int k) {
		int n = nums.length;
		int l = 0, r = n - 1;
		int missingNum = nums[n - 1] - nums[0] + 1 - n;
		if (missingNum < k)
			return nums[n - 1] + k - missingNum;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			int missing = nums[m] - nums[l] - (m - l);
			if (missing >= k)
				r = m;
			else {
				k -= missing;
				l = m;
			}
		}
		return nums[l] + k;
	}
}
