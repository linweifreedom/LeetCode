package leetCode642.search.autocomplete.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
	class TrieNode {
        Map<Character, TrieNode> trieMap;
        Map<String, Integer> frequencyMap;  
        public TrieNode(){
            trieMap = new HashMap<>();
            frequencyMap = new HashMap<>();  
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
    
    TrieNode root, cur;
    String prefix;
    boolean noResult = false;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            addTrieNode(sentences[i], times[i]);
        }
        cur = root;
    }
    
    public void addTrieNode(String s, int times) {
        cur = root;
        for (char c : s.toCharArray()) {
            TrieNode nextNode = cur.trieMap.get(c);
            if (nextNode == null) {
                nextNode = new TrieNode();
                cur.trieMap.put(c, nextNode);
            }
            cur = nextNode;
            if (cur.frequencyMap.containsKey(s))
                cur.frequencyMap.put(s, cur.frequencyMap.get(s) + times);
            else
                cur.frequencyMap.put(s, times);
            
        }
    }
    
    
    public List<String> input(char c) {
        //finish input, return new ArrayList, add user input's prefix to map
        List<String> result = new ArrayList<>();
        if (c == '#') {
            addTrieNode(prefix, 1);
            cur = root;
            prefix = "";
            noResult = false;
            return result;
        } 
        if (noResult)
        	return result;
        prefix += c;
        if (cur.trieMap.get(c) == null) {
        	noResult = true;
        	return result;
        }
            
        cur = cur.trieMap.get(c);
        // Use Priority Queue to store search result and sort
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.c == b.c ? a.s.compareTo(b.s): b.c - a.c);
        for (String s : cur.frequencyMap.keySet()) {
            pq.add(new Pair(s, cur.frequencyMap.get(s)));
        }
        for(int i = 1; i <= 3 && !pq.isEmpty(); i++)
            result.add(pq.poll().s);
        return result;
        
    }
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s = {"i love you","island","iroman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem autosystem = new AutocompleteSystem(s, times);
		System.out.println(autosystem.input('i'));
		System.out.println(autosystem.input(' '));
		System.out.println(autosystem.input('a'));
		System.out.println(autosystem.input('#'));
	}
}
