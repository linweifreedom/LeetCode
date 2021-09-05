package leetcode.array;

import java.util.HashSet;

public class _36_ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    HashSet<Character>[] rowSets = new HashSet[9];
    HashSet<Character>[] columnSets = new HashSet[9];
    HashSet<Character>[] boxSets = new HashSet[9];
    //initial
    for (int i = 0; i < 9; i++) {
        rowSets[i] = new HashSet<>();
        columnSets[i] = new HashSet<>();
        boxSets[i] = new HashSet<>();
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (c == '.') continue;
            if (rowSets[i].contains(c) || columnSets[j].contains(c))
                return false;
            rowSets[i].add(c);
            columnSets[j].add(c);
            int boxIndex = (i / 3) * 3 + (j / 3);
            if (boxSets[boxIndex].contains(c)) return false;
            boxSets[boxIndex].add(c);
        }
    }
    return true;
}
}
