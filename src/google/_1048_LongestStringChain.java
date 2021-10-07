package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1048_LongestStringChain {
	public int longestStrChain(String[] words) {
        if (words.length <= 1) return words.length;
        int ans = 1;
        Map<Integer, List<String>> map = new HashMap<>();
        Map<String, Integer> lengthMap = new HashMap<>();
        for (String word: words) {
            List<String> list = map.getOrDefault(word.length(), new ArrayList<>());
            list.add(word);
            map.put(word.length(), list);
        }
        for (String word : words) {
            ans = Math.max(ans, findLongest(word, map, lengthMap));
        }
        return ans;
        
    }
    
    private int findLongest(String word, Map<Integer, List<String>> map, Map<String, Integer> lengthMap) {
        if (!lengthMap.containsKey(word)) {
            List<String> nextList = map.get(word.length() + 1);
            if (nextList == null)
                return 1;
            int longest = 0;
            for (String next: nextList) {
                if (isPredecessor(word, next)) {
                    longest = Math.max(longest, findLongest(next, map, lengthMap));
                }
            }
            lengthMap.put(word, 1 + longest);
        }
        return lengthMap.get(word);
        
    }
    
    private boolean isPredecessor(String word1, String word2) {
        int i = 0; int j = 0;
        boolean findDifference = false;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                if (findDifference) return false;
                findDifference = true;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
