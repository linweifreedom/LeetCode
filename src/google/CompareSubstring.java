package google;

import java.util.HashSet;
import java.util.Set;

/*��һ���ܳ���text �������Ǽ���million��ô��������lowercase����Ȼ����ܶ�input strings��Ҫ�󷵻����е�substring

����text = 'thisisstevenjobs'
input = ['steve', 'student', 'job']
���� ['steve', 'job']*/
public class CompareSubstring {
	public Set<String> findSubstring(String s, String[] inputs){
		Trie dict = buildTrieDict(inputs);
		Trie cur = dict;
		int left = 0, right = 1;
		Set<String> result = new HashSet<>();
		while (right <= s.length()) {
			while (dict.children[s.charAt(left) - 'a'] == null && left < s.length())
				left++;
			if (left == s.length()) 
				return result;
			if (right <= left)
				right = left + 1;
			//find all substring between left to right
			
			
		}
		return result;
	}
	
	private Trie buildTrieDict(String[] inputs) {
		Trie root = new Trie();
		Trie cur = root;
		for (String input : inputs) {
			cur = root;
			for (char c : input.toCharArray()) {
				if (cur.children[c - 'a'] == null)
					cur.children[c - 'a'] = new Trie();
				cur = cur.children[c - 'a'];
			}
			cur.hasWord = true;
		}
		return root;
	}
	
	class Trie {
		Trie[] children;
		boolean hasWord;
		public Trie() {
			children = new Trie[26];
			hasWord = false;
		}
	}
}
