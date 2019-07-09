package leetcode.bitwise;

/*Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
The returned string must have no leading zeroes, unless the string is "0".*/
public class L1017_ConvertToBase_2 {
	public static void main(String[] args) {
		int N = 2;
        StringBuilder sb = new StringBuilder();
        for (;N!=0;N=-(N>>1)) {
        	System.out.println("N = " + N);
        	sb.append((N&1) == 0 ? '0' : '1');
        }
        System.out.println(sb.reverse().toString());
	}
}
