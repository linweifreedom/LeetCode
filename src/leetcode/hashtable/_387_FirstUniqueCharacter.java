package leetcode.hashtable;

import java.util.HashMap;

//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class _387_FirstUniqueCharacter {
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	countMap.put(c, countMap.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < n; i++) {
        	if (countMap.get(s.charAt(i)) == 1)
        		return i;
        }
        return -1;
    }
}
