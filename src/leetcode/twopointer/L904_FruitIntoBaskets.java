package leetcode.twopointer;

/*In a row of trees, the i-th tree produces fruit with type tree[i].
You start at any tree of your choice, then repeatedly perform the following steps:
Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: 
you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
What is the total amount of fruit you can collect with this procedure?*/
public class L904_FruitIntoBaskets {
	public int totalFruit(int[] tree) {
		if (tree.length <= 2)
			return tree.length;
		int fruit1 = tree[0];
		int index = 1;
		int curLength = 1;
		while (index < tree.length && tree[index] == fruit1) {
			curLength++;
			index++;
		}
		if (index == tree.length)
			return tree.length;
		int fruit2 = tree[index];
		curLength++;
		int maxLength = curLength;
		for (int i = index + 1; i < tree.length; i++) {
			if (tree[i] == fruit1 || tree[i] == fruit2) {
				curLength++;
				maxLength = Math.max(maxLength, curLength);
			} else {
				fruit1 = tree[i - 1];
				fruit2 = tree[i];
				int k = i - 1;
				while(k >= 0 && tree[k] == fruit1)
					k--;
				curLength = i - k;
			}
		}
		return maxLength;
	}
}
