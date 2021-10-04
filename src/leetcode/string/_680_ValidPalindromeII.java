package leetcode.string;

public class _680_ValidPalindromeII {
	public boolean validPalindrome(String s) {
		if ( s == null || s.length() <= 1) return true;
		int l = 0, r = s.length() - 1;
		char[] arr = s.toCharArray();
		while (l <= r) {
			if (arr[l] == arr[r]) {
				l++;r--;
			} else {
				if (!isPalindrome(arr, l + 1, r) && !isPalindrome(arr, l, r - 1))
					return false;
				else
					return true;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(char[] arr, int left, int right) {
		int l = left, r = right;
		while (l <= r) {
			if (arr[l] != arr[r])
				return false;
			l++;
			r--;
		}
		return true;
	}
}
