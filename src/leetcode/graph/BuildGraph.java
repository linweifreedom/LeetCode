package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * B -- C
 * E -- B
 * A -- B
 * B -- D
 * PRINT OUT  D-C-B--E A 
 * @author Joyce
 *
 */
public class BuildGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildGraph g = new BuildGraph();
		//String[][] input = {{"B", "C"}, {"E", "B"}, {"A", "B"}, {"B","D"}};
		String[][] input = {{"B", "C"}, {"E", "B"}, {"A", "B"}, {"B","D"}, {"F", "E"}};
		g.buildGraph(input);

	}

	public List<String> buildGraph(String[][] input) {
		Map<String, Node> map = new HashMap<>();
		Set<String> topSet = new HashSet<>();
		for (String[] pair : input) {
			map.put(pair[0], new Node(pair[0]));
			map.put(pair[1], new Node(pair[1]));
			topSet.add(pair[0]);
		}
		for (String[] pair : input) {
			if (topSet.contains(pair[1]))
				topSet.remove(pair[1]);
			map.get(pair[0]).children.add(map.get(pair[1]));
		}
		Stack<Node> stack = new Stack<>();
		for (String key : topSet)
			stack.push(map.get(key));
		List<String> result = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		while (!stack.isEmpty()) {
			Node top = stack.peek();
			if (!visited.contains(top.val)) {
				visited.add(top.val);
				if (top.children.isEmpty()) {
					result.add(top.val);
					stack.pop();
				} else {
					for (Node node : top.children) {
						if (!visited.contains(node.val))
							stack.push(node);
					}
				}
			} else {
				result.add(top.val);
				stack.pop();
			}
		}
		System.out.println(result.toString());
		return result;
		
	}
	
	void buildGraph(Map<String, Node> map, String[][] input) {
		Map<String , Node> tmpMap = new HashMap<>();
		
		for (String[] pair : input) {
			Node parent = tmpMap.get(pair[0]);
			parent.children.add(tmpMap.get(pair[1]));
			
			
		}
	}
	
	class Node {
		String val;
		List<Node> children;
		public Node(String val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}
}
