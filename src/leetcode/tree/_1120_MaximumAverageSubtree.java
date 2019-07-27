package leetcode.tree;

import test.structure.TreeNode;

public class _1120_MaximumAverageSubtree {
	double maximumAverage = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return maximumAverage;
    }
    //[0] store the count of nodes, [1] store the total sum of nodes
    public int[] helper(TreeNode node) {
        if (node == null) return new int[] {0,0};
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] root = new int[]{left[0] + right[0] + 1, left[1] + right[1] + node.val};
        if (root[0] != 0) 
            maximumAverage = Math.max(maximumAverage, (double)root[1] / root[0]);
        return root;
        
    }
}
