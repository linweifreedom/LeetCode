package leetcode.tree;

import test.structure.TreeNode;

/*
 * Given the root node of a binary search tree and two integers low and high, return the sum of
 * values of all nodes with a value in the inclusive range [low, high] Input: root =
 * [10,5,15,3,7,null,18], low = 7, high = 15 Output: 32 Explanation: Nodes 7, 10, and 15 are in the
 * range [7, 15]. 7 + 10 + 15 = 32.
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10 Output: 23 Explanation: Nodes 6,
 * 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */
public class _938_RangeSumOfBST {
  public int rangeSumBST(TreeNode root, int low, int high) {
    int sum = 0;
    if (root == null) return 0;
    if (root.val == low) {
        // add all right children
        sum += root.val + rangeSumBST(root.right, low, high);
    }
    if (root.val == high) {
        // add all left children
        sum += root.val + rangeSumBST(root.left, low, high);
    }
    if (root.val > high) {
        sum = rangeSumBST(root.left, low, high);
    }
    if (root.val < low) {
        sum = rangeSumBST(root.right, low, high);
    }
    if (root.val > low && root.val < high) {
        sum += root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low , high);
    }
    return sum;
}
}
