package leetcode.tree;

import test.structure.TreeNode;

//Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
public class _426_ConvertBinaryTreeToSortedDoublyLinkedList {
	TreeNode head = null; TreeNode pre = null;
	public TreeNode convertTreeToList(TreeNode root) {
		if (root == null) return null;
		inorder(root);
		pre.right = head;
		head.left = pre;
		return head;
	}
	
	public void inorder(TreeNode node) {
		if (node == null) return;
		inorder(node.left);
		if (head == null) {
			head = node;
			pre = node;
		} else {
			pre.right = node;
			node.left = pre;
			pre = node;
		}
		
		inorder(node.right);
		
	}
	
	public static void main(String[] args) {
		int[] input= {4,2,5,1,3};
		TreeNode root = TreeNode.buildBSTTreeFromArray(input);
		_426_ConvertBinaryTreeToSortedDoublyLinkedList entiry = new _426_ConvertBinaryTreeToSortedDoublyLinkedList();
		System.out.println(entiry.convertTreeToList(root));
	}
}
