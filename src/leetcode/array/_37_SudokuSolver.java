package leetcode.array;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the digits 1-9 must occur
 * exactly once in each column. Each of the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid. The '.' character indicates empty cells.
 */
public class _37_SudokuSolver {
  public void solveSudoku(char[][] board) {
    byte[][] rowSet = new byte[9][9], colSet = new byte[9][9], boxSet = new byte[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (ch != '.') {
          int digit = ch - '1';
          int boxId = (i / 3) * 3 + j / 3;
          rowSet[i][digit] = colSet[j][digit] = boxSet[boxId][digit] = 1;
        }
      }
    }
    dfs(board, rowSet, colSet, boxSet, 0, 0);
  }

  public boolean dfs(char[][] board, byte[][] rowSet, byte[][] colSet, byte[][] boxSet, int i,
      int j) {
    if (j == 9)
      return true;
    if (board[i][j] == '.') {
      for (char ch = '1'; ch <= '9'; ch++) {
        int digit = ch - '1';
        int boxId = (i / 3) * 3 + j / 3;
        if (rowSet[i][digit] == 0 && colSet[j][digit] == 0 && boxSet[boxId][digit] == 0) {
          rowSet[i][digit] = colSet[j][digit] = boxSet[boxId][digit] = 1;
          if (dfs(board, rowSet, colSet, boxSet, (i + 1) % 9, j + (i + 1) / 9)) {
            board[i][j] = ch;
            return true;
          }
          rowSet[i][digit] = colSet[j][digit] = boxSet[boxId][digit] = 0;
        }

      }
      return false;
    }
    return dfs(board, rowSet, colSet, boxSet, (i + 1) % 9, j + (i + 1) / 9);

  }
}
