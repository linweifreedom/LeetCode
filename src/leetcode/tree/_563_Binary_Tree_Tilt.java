package leetcode.tree;

import test.structure.TreeNode;

public class _563_Binary_Tree_Tilt {
	int tilt = 0;
    public int findTilt(TreeNode root) {
        findTiltForNode(root);
        return tilt;
    }
    
    public int findTiltForNode(TreeNode node) {
        if (node == null)
            return 0;
        int left = findTiltForNode(node.left);
        int right = findTiltForNode(node.right);
        tilt  += Math.abs(left - right);
        return left + right + node.val;
    }
}
