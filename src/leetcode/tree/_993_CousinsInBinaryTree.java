package leetcode.tree;

import test.structure.TreeNode;

public class _993_CousinsInBinaryTree {
	int xdepth = -1;
    int ydepth = -1;
    int xparent = -1;
    int yparent = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0);
        if (xparent != yparent && xdepth == ydepth)
            return true;
        else
            return false;
    }
    
    void helper(TreeNode root, int x, int y, int depth){
        if (root == null)
            return;
        if ((root.left != null && root.left.val == x) || (root.right != null&& root.right.val == x)) {
            xdepth = depth;
            xparent = root.val;
        }
        if ((root.left != null && root.left.val == y) || (root.right != null&& root.right.val == y)) {
            ydepth = depth;
            yparent = root.val;
        }
        helper(root.left, x, y, depth + 1);
        helper(root.right, x, y, depth + 1);
    }
}
