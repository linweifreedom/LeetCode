package leetcode.greedy;

public class _984_StringWithoutAAAorBBB {
	public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            //when there are already 2 b, then write A. else if A is more than B, write A
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == sb.charAt(n - 2)) {
                if (sb.charAt(n - 1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }
            if (writeA) {
                A--;
                sb.append('a');
            } else {
                B--;
                sb.append('b');
            }
        }
        return sb.toString();
        
    }
}
