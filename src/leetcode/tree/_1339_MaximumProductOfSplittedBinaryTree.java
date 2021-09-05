package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import leetcode.util.UtilityClass;
import test.structure.TreeNode;

public class _1339_MaximumProductOfSplittedBinaryTree {
  long modulo = (long)1e9+7;
  public int maxProduct(TreeNode root) {
      List<Integer> sumList = new ArrayList<>();
      long totalSum = calculateSum(root, sumList);
      long maxProduct = 0;
      for (int sum : sumList) {
          maxProduct = Math.max(maxProduct, sum * (totalSum - sum));
      }
      return (int)(maxProduct % modulo);
      
  }
  
  public int calculateSum(TreeNode root, List<Integer> sumList) {
      if (root == null) return 0;
      int leftSum = calculateSum(root.left, sumList);
      int rightSum = calculateSum(root.right, sumList);
      int sum = root.val + leftSum + rightSum;
      sumList.add(sum);
      return sum;
  }
  
  public static void main(String[] args) {
    int[] test = {1,2,3,4,5,6};
    TreeNode root = UtilityClass.insertLevelOrder(test, new TreeNode(0), 0);
    _1339_MaximumProductOfSplittedBinaryTree instance = new _1339_MaximumProductOfSplittedBinaryTree();
    System.out.println(instance.maxProduct(root));
  }
}
