package leetcode.tree;

import test.structure.TreeNode;

public class _538_ConvertBSTToGreaterTree {
	int currentSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            currentSum += root.val;
            root.val = currentSum;
            convertBST(root.left);
        }
        return root;
        
    }
}
