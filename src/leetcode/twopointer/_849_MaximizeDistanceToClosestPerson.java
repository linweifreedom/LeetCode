package leetcode.twopointer;

public class _849_MaximizeDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
        int longestZero = 0;
        int n = seats.length;
        int ans = 0;
        int left = 0; int right = n - 1;
        while (left < n && seats[left] == 0)
            left++;
        while (right >= 0 && seats[right] == 0)
            right--;
        longestZero = Math.max(left, n - 1 - right); 
        ans = longestZero;
        
        
        int l = left;
        while (l < right) {
            while (l < right && seats[l] == 1)
                l++;
            int r = l + 1;
            while (r < right && seats[r] == 0)
                r++;
            
            longestZero = Math.max(longestZero, r - l);
            l = r;
            
        }
        ans = Math.max(ans, (longestZero + 1) / 2);
        return ans ;
        
    }
}
