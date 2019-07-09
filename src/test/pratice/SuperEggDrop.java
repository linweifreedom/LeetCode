package test.pratice;

public class SuperEggDrop {
	public int superEggDrop(int K, int N) {
		int[][] dp = new int[K + 1][N + 1];
		return helper(K,N,dp);
	}
	public int helper(int K, int N, int[][] dp) {
		if (N <= 1) return N;
		if (K == 1) return N;
		if (dp[K][N] > 0) return dp[K][N];
		int low = 0; int high = N; int result = N;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int left = helper(K - 1, mid - 1, dp);
			int right = helper(K, N - mid, dp);
			result = Math.min(result, Math.max(left, right) + 1);
			if (left == right)
				break;
			else if (left < right)
				low = mid + 1;
			else
				high = mid;
			
		}
		dp[K][N] = result;
		return result;
	}
}
