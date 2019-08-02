package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _957_PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0)
            return cells;
        int n = cells.length;
        char[] current = new char[n];
        char[] next = new char[n];
        next[0] = next[n - 1] = '0';
        for (int i = 0; i < n; i++)
            current[i] = (char)(cells[i] + '0');
        List<String> list = new ArrayList<>();
        int loopStartIndex = -1;
        while (N > 0) {
            for (int i = 1; i < current.length - 1; i++) {
                if (current[i - 1] == current[i + 1])
                    next[i] = '1';
                else
                    next[i] = '0';
            }
            String nextStr = String.valueOf(next);
            if (list.contains(nextStr)) {
                loopStartIndex = list.indexOf(nextStr);
                //from loopStartIndex to end, is a loop
                current = Arrays.copyOf(next, n);
                N--;
                break;
            }
            else {
                list.add(nextStr);
                current = Arrays.copyOf(next, n);
                N--;
            }
            
        }
        if (N > 0) {
            int loopLength = list.size() - loopStartIndex;
            String finalStr = list.get(loopStartIndex + N%loopLength);
            current = finalStr.toCharArray();
            
        }
        for (int i = 0; i < n; i++) {
            cells[i] = current[i] - '0';
        }
        return cells;
    }
}
