package leetcode.array;

/*Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.*/
public class _978_LongestTurbulentSubarray {

	public static int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
        int ans = 1;
        int anchor = 0;
        for (int i = 1; i < n; i++) {
            int diff = Integer.compare(arr[i - 1], arr[i]);
            if (diff == 0) {
                anchor = i;
                
            } else if (i == n - 1 || diff * Integer.compare(arr[i], arr[i + 1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {9,4,2,10,7,8,8,1,9};
		System.out.println(maxTurbulenceSize(input));

	}

}
