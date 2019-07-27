package leetcode.tree;

import test.structure.TreeNode;

public class _1123_LowestCommonAncestorOfDeepestLeaves {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		_1123_LowestCommonAncestorOfDeepestLeaves lowetInstance = new _1123_LowestCommonAncestorOfDeepestLeaves();
		System.out.println(lowetInstance.lcaDeepestLeaves(node1).val);
	}
	
    TreeNode res = null;
	int maxDepth = 0;
	
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    public int helper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        if (node.left == null && node.right == null) {
        	if (depth + 1 > maxDepth) {
        		maxDepth = depth + 1;
        		res = node;
        	}
        	return depth + 1;
        }
        int leftDepth = helper(node.left, depth+1);
        int rightDepth = helper(node.right, depth+1);
        if (leftDepth == rightDepth & leftDepth >= maxDepth) 
        	res = node;
        return Math.max(leftDepth, rightDepth);
      
    }
}
