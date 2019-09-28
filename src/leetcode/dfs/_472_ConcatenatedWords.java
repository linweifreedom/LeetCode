package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _472_ConcatenatedWords {
	int min_length = Integer.MAX_VALUE;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
            min_length = Math.min(min_length, word.length());
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() == min_length)
                continue;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length() - min_length; i++) {
                sb.append(word.charAt(i));
                if (i < min_length - 1) continue;
                if (set.contains(sb.toString()) && existWord(word.substring(i + 1), set)) {
                    ans.add(word);
                    break;
                }
                    
            }
        }
        return ans;
        
    }
    
    public boolean existWord(String word, Set<String> set) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (set.contains(word.substring(0, i + 1))) {
                if (i == word.length() - 1)
                    return true;
                else if (existWord(word.substring(i + 1), set))
                    return true;
            }
            
        }
        return false;
    }
}
