package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L140_Wordbreak2 {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		Map<String, List<String>> memo = new HashMap<>();
		return wordBreak(s, dict, memo);
	}
	
	public static List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> memo) {
		if (memo.containsKey(s)) return memo.get(s);
		List<String> res = new ArrayList<>();
		if (dict.contains(s)) res.add(s);
		for (int i = 1; i < s.length(); i++) {
			String word = s.substring(0, i);
			if (dict.contains(word)) {
				List<String> childrenList = wordBreak(s.substring(i), dict, memo);
				for (String child : childrenList)
					res.add(word+" "+child);
			}
		}
		memo.put(s, res);
		return res;
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
		List<String> res = wordBreak(s, Arrays.asList(wordDict));
		System.out.println(res);
	}
}
