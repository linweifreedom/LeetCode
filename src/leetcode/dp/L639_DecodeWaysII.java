package leetcode.dp;

/*A message containing letters from A-Z is being encoded to numbers using the following mapping way:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
Also, since the answer may be very large, you should return the output mod 10^9 + 7.*/
public class L639_DecodeWaysII {
	public int numDecodings(String s) {
		if (s == null) return 0;
		int mod = 1000000007;
		int n = s.length();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) =='*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);
			char c2 = s.charAt(i - 1);
			if (c == '*') {
				dp[i + 1] = 9 * dp[i] % mod;
				if (c2 == '1') {
					dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % mod;
				} else if (c2 == '2')
					dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % mod;
				else if (c2 == '*')
					dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % mod;
			} else {
				dp[i + 1] = c == '0' ? 0 : dp[i];
				if (c2 == '1')
					dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
				else if (c2 == '2' && c <= '6')
					dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
				else if (c2 == '*') {
					if (c <= '6') 
						dp[i + 1] = (dp[i + 1] + 2 * dp[i - 1]) % mod;
					else
						dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
				}
			}
		}
		return (int)dp[n];
	}
}
