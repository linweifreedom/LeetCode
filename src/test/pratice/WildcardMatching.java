package test.pratice;

public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
        char[] sarray = s.toCharArray(); char[] parray = p.toCharArray();
        int m = s.length(), n = p.length(), star = -1, indexS = 0, indexP = 0, indexStar = 0;
        while (indexS < m) {
            if (indexP < n && (sarray[indexS] == parray[indexP] || parray[indexP] == '?')) {
                indexS++;
                indexP++;
                System.out.println("indexS = " + indexS + " indexP=" + indexP+ " indexStar =" + indexStar + " Star=" + star);
                continue;
            }
            if (indexP < n && parray[indexP] == '*') {
                star = indexP++; indexStar = indexS; 
                System.out.println("indexS = " + indexS + " indexP=" + indexP+ " indexStar =" + indexStar + " Star=" + star);
continue;
            }
            if (star != -1) {
                indexP = star + 1; indexS = ++indexStar;
                System.out.println("indexS = " + indexS + " indexP=" + indexP+ " indexStar =" + indexStar + " Star=" + star);
continue;
            }
            return false;
        }
        while (indexP < n && parray[indexP] == '*') indexP++;
        return indexP == n;
    }
	
	public static void main(String[] arg) {
		String s = "acdcb";
		String p = "*a*b";
		isMatch(s, p); 
	}
}
