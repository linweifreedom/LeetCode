package fb;

import java.util.Arrays;

public class Cafeteria {
	public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
		// Write your code here
		// Left part
		Arrays.sort(S);
	    long count = 0L;
	    long left = S[0] - 1;
	    
	    if (left > 0)
	      count += left/(K + 1);
	    long right = N - S[M - 1]; 
	    if (right > 0)
	      count += right/(K + 1);
	    if (S.length > 1) {
	      for (int i = 0; i <= S.length-2; i++ ) {
	        long diff = S[i + 1] - S[i]  - 1l;
	        if (diff > 0)
	          count += (diff - K)/(K + 1l);
	      }
	    }
	    
	    return count;
	}
	
	public static void main(String[] args) {
		long[] S = {11l, 6l, 14l};
		System.out.println(getMaxAdditionalDinersCount(15l, 2l, 3, S));
	}
}
