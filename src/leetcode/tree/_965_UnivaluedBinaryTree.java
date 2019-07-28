package leetcode.tree;

import test.structure.TreeNode;

/*A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.*/
public class _965_UnivaluedBinaryTree {
	int rootVal;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        rootVal = root.val;
        return dfs(root);
    }
    
    public boolean dfs(TreeNode node) {
        if (node.val != rootVal)
            return false;
        boolean left = true;
        boolean right = true;
        if (node.left != null)
            left = dfs(node.left);
        if (node.right != null)
            right = dfs(node.right);
        if (!left || !right)
            return false;
        return true;
    }
}
