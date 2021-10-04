package fb;

import java.util.ArrayList;
import java.util.List;

import test.structure.TreeNode;

//给一个binary search tree, 给range[x,y], 返回所有tree中在range范围内的node的val
public class FindNodeInRangeFromTree {
	public static List<Integer> findNodeInRangeFromTree(TreeNode root, int[] range) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return null;
		findNode(root, range, list);
		return list;
	}
	
	private static void findNode(TreeNode root, int[] range, List<Integer> list) {
		if (root == null) return;
		if (root.val <= range[1] && root.val >= range[0])
			list.add(root.val);
		if (root.val <= range[1])
			findNode(root.right, range, list);
		if (root.val >= range[0])
			findNode(root.left, range, list);
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = TreeNode.buildBSTTreeFromArray(input);
		int[] range = {5, 5};
		System.out.println(findNodeInRangeFromTree(root, range));
	}
}
