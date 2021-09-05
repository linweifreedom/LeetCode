package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1293_ShortestPathInGridWithObstaclesElimination {

  public int shortestPath(int[][] grid, int k) {
    int m, n;
    m = grid.length;
    n = grid[0].length;
    int step = 0;
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // visited is used to store the count of obstacles
    int[][] visited = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(visited[i], Integer.MAX_VALUE);
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0, 0));
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int t = 0; t < size; t++) {
        Node node = queue.poll();
        if (node.row == m - 1 && node.col == n - 1)
          return step;
        for (int i = 0; i < 4; i++) {
          int nextRow = node.row + directions[i][0];
          int nextCol = node.col + directions[i][1];
          if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n
              && visited[nextRow][nextCol] > node.count) {
            if (grid[nextRow][nextCol] == 0) {
              queue.add(new Node(nextRow, nextCol, node.count));
              visited[nextRow][nextCol] = node.count;
            } else {
              if (node.count + 1 <= k) {
                queue.add(new Node(nextRow, nextCol, node.count + 1));
                visited[nextRow][nextCol] = node.count + 1;
              }
            }
          }
        }
      }
      step++;
    }
    return -1;
  }

  class Node {
    int row;
    int col;
    int count;

    public Node(int row, int col, int count) {
      this.row = row;
      this.col = col;
      this.count = count;
    }
  }
}
