package fb;

import java.util.Arrays;

/*There¡¯s a circular train track with a circumference of CC metres. Positions along the track are measured in metres, clockwise from its topmost point. For example, the topmost point is position 00, 11 metre clockwise along the track is position 11, and 11 metre counterclockwise along the track is position C-1.
A train with negligible length runs clockwise along this track at a speed of 11 metre per second, starting from position 00. After CC seconds go by, the train will have driven around the entire track and returned to position 00, at which point it will continue going around again, with this process repeated indefinitely.
There are NN tunnels covering sections of the track, the iith of which begins at position A_i  and ends at position B_i(and therefore has a length of B_i - A_i  metres). No tunnel covers or touches position 00 (including at its endpoints), and no two tunnels intersect or touch one another (including at their endpoints). For example, if there's a tunnel spanning the interval of positions [1, 4][1,4], there cannot be another tunnel spanning intervals [2, 3][2,3] nor [4, 5][4,5].
The train¡¯s tunnel time is the total number of seconds it has spent going through tunnels so far. Determine the total number of seconds which will go by before the train¡¯s tunnel time becomes KK.
*/
public class TunnelTime {
	public long getSecondsElapsed(long C, int N, long[] A, long[] B, long K) {
	    // Write your code here
	    Tunnel[] tunnels = new Tunnel[N];
	    long total = 0l;
	    for (int i = 0; i < N; i++){
	      tunnels[i] = new Tunnel(A[i], B[i], B[i] - A[i]);
	      total += B[i] - A[i];
	    } 
	    Arrays.sort(tunnels, (o1, o2) -> o1.start.compareTo(o2.start));
	    long result = 0l;
	    result += (K / total) * C;
	    long rest = K % total;
	    long cur = 0l;
	    int i = 0;
	    while (rest > 0l) {
	      // goto next tunnel
	      result += tunnels[i].start - cur;
	      if (rest <= tunnels[i].length) {
	        result += rest;
	        break;
	      } else {
	        result += tunnels[i].length;
	        cur = tunnels[i].end;
	        rest -= tunnels[i].length;
	        i++;
	      }
	    }
	    return result;
	  }

	class Tunnel {
		Long start;
		Long end;
		Long length;

		public Tunnel(long s, long e, long l) {
			start = s;
			end = e;
			length = l;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
