package amazon;

import test.structure.NarrTreeNode;

/*
Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.

Example 1:

Input:
         20
       /   \
     12     18
  /  |  \   / \
11   2   3 15  8

Output: 18
Explanation:
There are 3 nodes which have children in this tree:
12 => (11 + 2 + 3 + 12) / 4 = 7
18 => (18 + 15 + 8) / 3 = 13.67
20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

18 has the maximum average so output 18.*/
public class MaximumAvgSubTree {
  double ans = 0.0;
  public double maximumAvgSubTree(NarrTreeNode root) {
    helper(root);
    return ans;
  }
  
  // result[0] store count, result[1] store sum
  public int[] helper(NarrTreeNode root) {
    if (root == null) return new int[] {0,0};
    int[] rootArr = new int[] {1, root.val};
    if (root.children.length > 0) {
      for (NarrTreeNode child : root.children) {
        int[] childArr = helper(child);
        rootArr[0] += childArr[0];
        rootArr[1] += childArr[1];
      }
      if (rootArr[0] != 0) {
        ans = Math.max(ans,  (double) rootArr[1]/rootArr[0]);
      }
    }
    return rootArr;
    
  }
  
}
