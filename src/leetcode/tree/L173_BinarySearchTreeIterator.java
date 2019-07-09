package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import test.structure.TreeNode;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.*/
public class L173_BinarySearchTreeIterator {
	Queue<TreeNode> queue = new LinkedList<>();
	public void BSTIterator(TreeNode root) {
		fillingQueue(root);
	}
	
	public void fillingQueue(TreeNode root) {
		if (root == null)
			return;
		fillingQueue(root.left);
		queue.offer(root);
		fillingQueue(root.right);
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public int next(){
		return queue.poll().val;
	}
}
