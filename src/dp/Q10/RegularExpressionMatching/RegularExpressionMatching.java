package dp.Q10.RegularExpressionMatching;

/*Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).*/
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[m][n] =  true;
		for (int i = m; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
				if (j + 1 < n && p.charAt(j + 1) == '*')
					dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
				else
					dp[i][j] = firstMatch && dp[i + 1][j + 1];
			}
		return dp[0][0];
	}
}
