package amazon;

import java.util.LinkedList;
import java.util.Queue;

/*Demolition Robot
Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
The demolition robot cannot enter 0 trenches and cannot leave the matrix.
Sample Input :
[1, 0, 0],
[1, 0, 0],
[1, 9, 1]]
Sample Output :
3
This question can be solved by using BFS or DFS.*/
public class DemolitionRobot {

	static int[][] adj = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
			};
	int sol(int[][] maze) {
		int mx = maze.length;
		int my = maze[0].length;
		Queue<Pos> q = new LinkedList();
		maze[0][0] = 1;
		q.add(new Pos(0, 0, 0));

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			if (maze[pos.x][pos.y] == 9) {
				System.out.println("found");
				return pos.steps;
			}
			maze[pos.x][pos.y] = 1;
			for (int[] arr : adj) {
				if (addIt(maze, pos.x + arr[0], pos.y + arr[1], mx, my)) {
					q.add(new Pos(pos.x + arr[0], pos.y + arr[1], pos.steps + 1));
				}
			}
		}
		return -1;
	}

	private boolean addIt(int[][] maze, int x, int y, int mx, int my) {
		if (x >= 0 && y >= 0 && x < mx && y < my && maze[x][y] != 1)
			return true;
		return false;
	}

	static class Pos {
		int x;
		int y;
		int steps;

		public Pos(int x, int y, int steps) {
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
