package leetcode.array;

public class _985_SumOfEvenNumbersAfterQueries {
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        //Firstly, calculate initial sum
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) sum += A[i];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            // if new A[x]  is odd, then we need remove old A[x] from sum.
            int old = A[queries[i][1]];
            if (old % 2 == 0)
                sum -= old;
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0)
                sum += A[queries[i][1]];
            res[i] = sum;
        } 
        return res; 
    }
}
