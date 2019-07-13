package leetcode.dp;

/*There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty*/
public class _4_MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if (m > n) return findMedianSortedArrays(nums2, nums1);
		int l = 0, r = m, halfLen = (m + n + 1) / 2;
		int i, j, maxLeft, maxRight;
		while (l <= r) {
			i = (l + r) / 2;
			j = halfLen - i;
			if (j > 0 && i < m && nums2[j - 1] > nums1[i])
				l = i + 1;
			else if (i > 0 && j < n && nums1[i - 1] > nums2[j])
				r = i - 1;
			else {
				if (i == 0) maxLeft = nums2[j - 1];
				else if (j == 0) maxLeft = nums1[i - 1];
				else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				if ((m + n ) % 2 == 1) return maxLeft;
				if (i == m) maxRight = nums2[j];
				else if (j == n) maxRight = nums1[i];
				else maxRight = Math.min(nums1[i], nums2[j]);
				return (maxLeft + maxRight) / 2.0;
			}
		}
		return -1;
	}
}
