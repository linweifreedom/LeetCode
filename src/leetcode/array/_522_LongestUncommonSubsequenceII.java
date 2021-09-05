package leetcode.array;

import java.util.Arrays;

public class _522_LongestUncommonSubsequenceII {
  public int findLUSlength(String[] strs) {
    Arrays.sort(strs, (str1, str2) -> str1.length() - str2.length());
    for (int i = strs.length - 1; i >= 0; i--) {
        String s = strs[i];
        boolean isUS = true;
        //check s is any strs subsequence
        for (int j = i + 1; j < strs.length; j++) {
            if (isSubSequence(strs[j], s)) {
                isUS = false;
                break;
            }
        }
        //for index small than i, only check if the str has same length
        for (int j = i - 1; j >= 0; j--) {
            if (strs[j].length() < s.length())
                break;
            else {
                if (strs[j].equals(s)) {
                    isUS = false;
                    break;
                }
            }
        }
        if (isUS)
            return s.length();
    }
    return -1;
    
}

public boolean isSubSequence(String str1, String str2) {
    int i = 0, j = 0;
    while (i < str1.length() && j < str2.length()) {
        if (str1.charAt(i) == str2.charAt(j)) {
            j++;
        }
        i++;
    }
    return j == str2.length();
}
}
