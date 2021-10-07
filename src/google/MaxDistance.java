package google;

import java.util.Arrays;

//Given a distance list(kilos), kilos= [1,1,10,30,20,40], and starting capacity k=1, you want to get the maximum distance following this rule: if you don't work on day i (you rest), you will gain 1 more capacity, otherwise, you will consume 1 capacity and gain the distance. If you have 0 capacity at the end of one day, you can not move, which means you have to rest to gain capacity.
//In the above example, you will rest the first 3 days, and get k=4 capacity, and then you choose 20,30,40 to work on and get 90 distances. or you can get 2 day rest and still get k=3, but the final res is still 90.
public class MaxDistance {
	public int maxDistance(int[] kilometers) {
		int n = kilometers.length;
		//dp[i][j] means in day i has capacity j , the max distance can go
		int[][] dp = new int[n][n + 1];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		dp[0][2] = 0;
		dp[0][0] = kilometers[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				int rest = j == 0? Integer.MIN_VALUE : dp[i - 1][j - 1];
				int go = j == n ? Integer.MIN_VALUE : dp[i - 1][j + 1] + kilometers[i];
				dp[i][j] = Math.max(rest, go);
			}
		}
		int ans = 0;
		for (int i = 0; i < n + 1; i++) {
			ans = Math.max(ans, dp[n - 1][i]);
		}
		return ans;
		
	}
	
	
	public int maxDistance(int[] kilometers, int k) {
		int n = kilometers.length;
		if (k >= n) {
			// can take all
			int sum = 0;
			for (int kilo : kilometers)
				sum += kilo;
			return sum;
		}
		//dp[i][j] means in day i has capacity j , the max distance can go
		int[][] dp = new int[n][n + 1];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		dp[0][k + 1] = 0;
		if (k > 0)
			dp[0][k - 1] = kilometers[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				int rest = j == 0? Integer.MIN_VALUE : dp[i - 1][j - 1];
				int go = j == n ? Integer.MIN_VALUE : dp[i - 1][j + 1] + kilometers[i];
				dp[i][j] = Math.max(rest, go);
			}
		}
		int ans = 0;
		for (int i = 0; i < n + 1; i++) {
			ans = Math.max(ans, dp[n - 1][i]);
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kilos = {50, 1, 10, 30, 20, 40};
		MaxDistance instance = new MaxDistance();
		System.out.println(instance.maxDistance(kilos));
		System.out.println(instance.maxDistance(kilos, 0));
	}

}
