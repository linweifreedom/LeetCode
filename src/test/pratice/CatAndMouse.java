package test.pratice;

public class CatAndMouse {
	public static void main(String[] args) {
		//int[][] ops = {{2,3},{3,4},{0,4},{0,1},{1,2}};
		int[][] ops = {{6},{4},{9},{5},{1,5},{3,4,6},{0,5,10},{8,9,10},{7},{2,7},{6,7}};
		System.out.println(catMouseGame(ops));
	}
	public static int catMouseGame(int[][] graph) {
        int m = graph.length;
        //dp[x][y][z] -> x is cat's node, y is mouse's node, z=0 is mouse's turn, z=1 is cat's turn
        int[][][] dp = new int[m][m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        //if mouse is in 0, mouse win
        for (int i = 0; i < m; i++) {
            dp[i][0][0] = 1;
            dp[i][0][1] = 1;
        }
        //if cat is in same node with mouse which is not 0, cat win
        for (int i = 1; i < m; i++) {
            dp[i][i][0] = 2;
            dp[i][i][1] = 2;
        }
        
        return dfs(graph,dp, 2, 1, 0);
        
    }
    
    public static int dfs(int[][] graph, int[][][] dp, int x, int y, int z) {
        if (dp[x][y][z] != -1)
            return dp[x][y][z];
        // if current turn is mouse
    	int tmpRes;
        if (z == 0) {
        	tmpRes = 2;
            int[] mouseNext = graph[y];
            for (int i : mouseNext) {
            	if (i == 0) {
            		dp[x][y][z] = 1;
            		return 1;
            	}
            	if (i == x)
            		continue;
            	int res;
            	if (dp[x][i][1] == -1)
            		res = dfs(graph, dp, x, i, 1);
            	else
            		res = dp[x][i][1];
                 if (res == 1) {
                	 dp[x][y][z] = 1;
                	 return 1;
                 } else if (res == 0)
                	 tmpRes = 0;
                	 
            }
            
        } else {
        	tmpRes = 1;
            //if current turn is cat
            int[] catNext = graph[x];
            for (int i : catNext) {
            	if (i == 0)
            		continue;
                if (i == y) {
                	dp[x][y][z] = 2;
                	return 2;
                }
                int res;
                if (dp[i][y][0] == -1)
                	res = dfs(graph, dp, i, y, 0);
                else
                	res = dp[i][y][0];
                if (res == 2) {
                	dp[x][y][z] = 2;
                	return 2;
                } else if (res == 0)
                	tmpRes = 0;
                
            }
        }
        dp[x][y][z] = tmpRes;
        return tmpRes;
    }
}
