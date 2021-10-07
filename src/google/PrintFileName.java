package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintFileName {
	public  void printFile(String[] inputs) {
		TrieNode root = buildTrie(inputs);
		print(root, 0);
		
	}
	private void print(TrieNode root, int level) {
		StringBuilder space = new StringBuilder();
		for (int i = 0; i < level; i++)
			space.append("  ");
		if (!root.folders.isEmpty()) {
			for (String folderName : root.folders.keySet()) {
				StringBuilder sb = new StringBuilder();
				sb.append(space);
				sb.append(folderName);
				System.out.println(sb.toString());
				print(root.folders.get(folderName), level + 1);
			}
		}
		if (!root.files.isEmpty()) {
			for (String file : root.files) {
				StringBuilder sb = new StringBuilder();
				sb.append(space);
				sb.append(file);
				System.out.println(sb.toString());
			}
		}
	}
	
	private TrieNode buildTrie(String[] inputs) {
		TrieNode root = new TrieNode();
		TrieNode cur = root;
		for (String input : inputs) {
			cur = root;
			String[] arr = input.split("/");
			for (int i = 0; i < arr.length - 1; i++) {
				if (!cur.folders.containsKey(arr[i]))
					cur.folders.put(arr[i], new TrieNode());
				cur = cur.folders.get(arr[i]);
			}
			if (arr[arr.length - 1].contains("."))
				cur.files.add(arr[arr.length - 1]);
			else if (!cur.folders.containsKey(arr[arr.length - 1]))
				cur.folders.put(arr[arr.length - 1], new TrieNode());
				
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"users/components/header","users/services","users/tests/components/header","pictures/picture.png","config.json","index.html"};
		PrintFileName instance = new PrintFileName();
		instance.printFile(input);
	}

}

class TrieNode{
	Map<String, TrieNode> folders;
	Set<String> files;
	public TrieNode() {
		folders = new HashMap<>();
		files = new HashSet<>();
	}
}
