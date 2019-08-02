package leetcode.array;

public class _1138_AlphabetBoardPath {
	public String alphabetBoardPath(String target) {
        if (target == null) return "";
        char[] chs = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        int curx = 0, cury = 0;
        for (int i = 0; i < chs.length; i++) {
            int nextx = (chs[i] - 'a') / 5;
            int nexty = (chs[i] - 'a') % 5;
            while (curx > nextx) {
                sb.append("U");
                curx--;
            }
            while (cury < nexty) {
                sb.append("R");
                cury++;
            }
            while (cury > nexty) {
                sb.append("L");
                cury--;
            }
            while (curx < nextx) {
                sb.append("D");
                curx++;
            }
            sb.append("!");
            
        }
        return sb.toString();
    }
}
