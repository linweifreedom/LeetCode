package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import test.structure.TreeNode;

/*Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.*/
public class _872_LeafSimilarTrees {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    public void dfs(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leaves.add(node.val);
            dfs(node.left, leaves);
            dfs(node.right, leaves);
        }
    }
}
