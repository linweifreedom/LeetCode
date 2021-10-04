package google;

import java.util.HashSet;
import java.util.Set;

/**
 * 给一个很长的text， 要求返回所有的substring
 * 比如text='thisisstevenjobs'
 * input = ['steve', 'student','job']
 * 返回['steve','job']
 * 
 * @author 11032026
 *
 */
public class CompareSubstring {
    Trie dict;
    StringBuilder sb;
    Set<String> outputSet;
    public CompareSubstring(String[] inputs) {
      this.dict = buildTrieDict(inputs);
      sb = new StringBuilder();
      outputSet = new HashSet<>();
    }
    
    public void findSubstring(Character c) {
      Trie cur = dict;
      sb.append(c);
      for (int i = sb.length() - 1; i >= 0; i--) {
          if (cur.children[sb.charAt(i) - 'a'] == null) {
            return;
          } else {
              cur = cur.children[sb.charAt(i) - 'a'];
              if (cur.word != null)
                  this.outputSet.add(cur.word);
          }
      }
    }
    
    public Set<String> findSubstring(String s) {
      for (int i = 0; i < s.length(); i++)
        findSubstring(s.charAt(i));
      return outputSet;
    }
    
    //This is from left to right
    /*public Set<String> findSubstring(String s) {
      Trie cur = dict;
      int left = 0, right = 0;
      Set<String> result = new HashSet<>();
      while (left < s.length()) {
        while (dict.children[s.charAt(left) - 'a'] == null && left < s.length())
          left++;
        if (left == s.length())
          return result;
        if (right < left)
          right = left;
        // find all substring between left to right
        cur = dict;
        int tmp = left;
        while (right < s.length() && cur.children[s.charAt(right) - 'a'] != null
            && cur.children[s.charAt(tmp) - 'a'] != null) {
          cur = cur.children[s.charAt(tmp) - 'a'];
          if (cur.hasWord)
            result.add(cur.word);
          if (tmp == right) {
            right++;
          }
          tmp++;
        }
        left++;


      }
      return result;
    }*/
	
    private Trie buildTrieDict(String[] inputs) {
      Trie root = new Trie();
      Trie cur = root;
      for (String input : inputs) {
        cur = root;
        for (int i = input.length() - 1; i >= 0; i--) {
          if (cur.children[input.charAt(i) - 'a'] == null)
            cur.children[input.charAt(i) - 'a'] = new Trie();
          cur = cur.children[input.charAt(i) - 'a'];
        }
        cur.word = input;
      }
      return root;
    }
	
    class Trie {
      Trie[] children;
      String word;

      public Trie() {
        children = new Trie[26];
        word = null;
      }
    }
	
	public static void main(String[] args) {
	  String text="thisisstevenjobs";
      String[] inputs = {"steve", "student","job", "is", "siss", "t", "th"};
	  CompareSubstring instance = new CompareSubstring(inputs);
	  
	  System.out.println(String.valueOf(instance.findSubstring(text)));
	}
}
