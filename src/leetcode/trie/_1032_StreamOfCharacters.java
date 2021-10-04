package leetcode.trie;


/*
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these
 * characters is a string of a given array of strings words.
 * 
 * For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a',
 * 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz"
 * matches "xyz" from words.
 * 
 * Implement the StreamChecker class:
 * 
 * StreamChecker(String[] words) Initializes the object with the strings array words. boolean
 * query(char letter) Accepts a new character from the stream and returns true if any non-empty
 * suffix from the stream forms a word that is in words.
 */
public class _1032_StreamOfCharacters {
  class StreamChecker {
    Trie dict;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        this.dict = buildTrieDict(words);
        sb = new StringBuilder();
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Trie cur = dict;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (cur.children[sb.charAt(i) - 'a'] == null)
                return false;
            else {
                cur = cur.children[sb.charAt(i) - 'a'];
                if (cur.hasWord)
                    return true;
            }
        }
        return false;
    }
    
    private Trie buildTrieDict(String[] inputs) {
        Trie root = new Trie();
        Trie cur = root;
        for (String input : inputs) {
            cur = root;
            for (int i = input.length() - 1; i>= 0; i--) {
                if (cur.children[input.charAt(i) - 'a'] == null)
                    cur.children[input.charAt(i) - 'a'] = new Trie();
                cur = cur.children[input.charAt(i) - 'a'];
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
}
