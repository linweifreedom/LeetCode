package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.structure.TreeNode;

public class _655_PrintBinaryTree {
	String[][] array;
    int m = 0;
    int n = 0;
    public List<List<String>> printTree(TreeNode root) {
        m = findMaxHeight(root);
        n = (int)(Math.pow(2, m) - 1.0);
        array = new String[m][n];
        for (String[] a : array)
            Arrays.fill(a, "");
       
        for (int i = 0; i < m; i++) {
            fillRow(root, i, 0, n - 1, i);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String[] a : array) {
            result.add(Arrays.asList(a));
        }
        return result;
        
    }
    
    public int findMaxHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(findMaxHeight(root.left), findMaxHeight(root.right)) + 1;
        
    }
    
    public void fillRow(TreeNode node, int height, int left, int right, int row) {
        if (node == null) return;
        if (height == 0) {
            array[row][left + (right - left) / 2] = String.valueOf(node.val);
        } else {
            int mid = left + (right - left) / 2;
            fillRow(node.left, height - 1, left, mid - 1, row);
            fillRow(node.right, height - 1, mid + 1, right, row);
        }
    }
}
