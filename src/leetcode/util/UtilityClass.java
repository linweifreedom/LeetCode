package leetcode.util;

import test.structure.TreeNode;

public class UtilityClass {
	public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
	
    // Function to insert nodes in level order
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
      // Base case for recursion
      if (i < arr.length) {
        TreeNode temp = new TreeNode(arr[i]);
        root = temp;

        // insert left child
        root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

        // insert right child
        root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
      }
      return root;
    }

    // Function to print tree nodes in InOrder fashion
    public void inOrder(TreeNode root) {
      if (root != null) {
        inOrder(root.left);
        inOrder(root.right);
      }
    }
}
