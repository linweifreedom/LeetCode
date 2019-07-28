package leetcode.tree;

import test.structure.TreeNode;

public class _814_BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    
    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;
        return node.val == 1 || left || right;
    }
}

/*
 * Time Complexity: O(N), where N is the number of nodes in the tree. We
 * process each node once.
 * 
 * Space Complexity: O(H), where H is the height of the tree. This
 * represents the size of the implicit call stack in our recursion.
 */