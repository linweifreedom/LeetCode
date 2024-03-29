package leetcode.dp;

/*You are given K eggs, and you have access to a building with N floors from 1 to N. 
Each egg is identical in function, and if an egg breaks, you cannot drop it again.
You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 
Your goal is to know with certainty what the value of F is.
What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
*/public class _887_SupperEggDrop {
	public int superEggDrop(int K, int N) {
		int dp[] = new int[K + 1];
		int m = 0;
		for (m = 0; dp[K] < N; m++) {
			for (int k = K; k > 0; k--)
				dp[k] += dp[k - 1] + 1;
		}
		return m;
	}
}
