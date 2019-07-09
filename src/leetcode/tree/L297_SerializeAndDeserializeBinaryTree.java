package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import test.structure.TreeNode;

/*Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
*/
public class L297_SerializeAndDeserializeBinaryTree {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null)
    		return "[null]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	TreeNode treeNode = queue.poll();
        	if (treeNode == null) 
        		sb.append("null");
        	else {
        		sb.append(Integer.toString(treeNode.val));
        		queue.offer(treeNode.left);
        		queue.offer(treeNode.right);
        	}
        	if (queue.size() > 0)
        		sb.append(",");
        }
        sb.append("]");
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("[null]") || data.equals("null"))
        	return null;
        String sub = data.substring(1, data.length() - 1);
        String[] dataArray = sub.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < dataArray.length) {
        	TreeNode treeNode = queue.poll();
        	if (!dataArray[i].equals("null")) {
        		TreeNode leftNode = new TreeNode(Integer.parseInt(dataArray[i]));
        		treeNode.left = leftNode;
        		queue.offer(leftNode);
        	}
        	i++;
        	if (!dataArray[i].equals("null")) {
        		TreeNode rightNode = new TreeNode(Integer.parseInt(dataArray[i]));
        		treeNode.right = rightNode;
        		queue.offer(rightNode);
        	}
        	i++;
        }
        return root;
    }
    
	
}
