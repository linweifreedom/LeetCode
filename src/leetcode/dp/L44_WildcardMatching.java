package leetcode.dp;

//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
public class L44_WildcardMatching {
	public boolean isMatch(String s, String p) {
		char[] sarray = s.toCharArray();
		char[] parray = p.toCharArray();
		int m = sarray.length, n = parray.length, sindex = 0, pindex = 0, starIndex = 0, star = -1;
		while (sindex < m) {
			if (pindex < n && (sarray[sindex] == parray[pindex] || parray[pindex] == '?')) {
				sindex++;
				pindex++;
				continue;
			}
			if (pindex < n && parray[pindex] == '*') {
				star = pindex;
				pindex++;
				starIndex = sindex;
				continue;
			}
			if (star != -1) {
				pindex = star + 1; sindex = ++ starIndex; 
				continue;
			}
			return false;
		}
		while (pindex < n && parray[pindex] == '*') pindex++;
		return pindex == n;
	}
}
