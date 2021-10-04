package test.structure;

import java.util.Arrays;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public static TreeNode buildBSTTreeFromArray(int[] array) {
		if (array.length == 0) return null;
		Arrays.sort(array);
		return buildSubTree(array, 0, array.length - 1);
		
		
	}
	
	private static TreeNode buildSubTree(int[] array, int left, int right) {
		if (left > right) return null;
		if (left == right)
			return new TreeNode(array[left]);
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = buildSubTree(array, left, mid - 1);
		root.right = buildSubTree(array, mid + 1, right);
		return root;
	}
}
