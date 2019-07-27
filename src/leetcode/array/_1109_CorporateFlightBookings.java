package leetcode.array;

import java.util.Arrays;

/*There are n flights, and they are labeled from 1 to n.
We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
Return an array answer of length n, representing the number of seats booked on each flight in order of their label.*/
public class _1109_CorporateFlightBookings {
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n + 2];
        for (int[] booking : bookings) {
            res[booking[0]] += booking[2];
            res[booking[1] + 1] -= booking[2];
        }
        for (int i = 1; i < n + 2; i++) {
            res[i] += res[i - 1];
            
        }
        return Arrays.copyOfRange(res, 1, n + 1);
    }
}
