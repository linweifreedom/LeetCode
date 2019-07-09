package leetcode.dfs;

/*Given a 2d grid map of '1's (land) and '0's (water), 
count the number of islands. An island is surrounded by water 
and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.*/
public class L200_NubmerOfIslands {
	int count = 0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
        	return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] checked = new boolean[m][n];
        for (int i = 0; i < m; i++)
        	for (int j = 0; j < n; j++)
        		searchIsland(grid, checked, i, j, true);
    	return count;
    }
    
    public void searchIsland(char[][] grid, boolean[][] checked, int x, int y, boolean countIsland) {
    	if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || checked[x][y])
    		return;
    	else {
    		checked[x][y] = true;
    		if (grid[x][y] == '0')
    			return;
    		else {
    			if (countIsland)
    				count++;
    			else {
    				grid[x][y] = '0';
    			}
    			searchIsland(grid, checked, x + 1, y, false);
    			searchIsland(grid, checked, x - 1, y, false);
    			searchIsland(grid, checked, x, y + 1, false);
    			searchIsland(grid, checked, x, y - 1, false);
    			
    		}
    	}
    }
}
