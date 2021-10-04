package leetcode.dfs;

/*There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
*/
public class _460_TheMaze {
	int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze == null || maze.length == 0 || maze[0].length == 0)
			return false;
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		for (int[] dir : dirs) {
			if (dfs(maze, start, destination, dir, visited))
				return true;
		}
		return false;
	}
	
	private boolean dfs(int[][] maze, int[] start, int[] destination, int[] dir, boolean[][] visited) {
		int m = maze.length;
		int n = maze[0].length;
		int row = start[0];
		int col = start[1];
		if (row == destination[0] && col == destination[1])
			return true;
		while (row + dir[0] >= 0 && row + dir[0] < m && col + dir[1] >= 0 && col + dir[1] < n && maze[row + dir[0]][col + dir[1]] == 0) {
			row += dir[0];
			col += dir[1];
		}
		if (visited[row][col])
			return false;
		visited[row][col] = true;
		for (int[] nextDir: dirs) {
			if (dfs(maze, start, destination, nextDir, visited))
				return true;
		}
		return false;
	}
}
