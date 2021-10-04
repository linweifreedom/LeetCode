package fb;

//一个n size array， 理想情况下里面应该是1-n 每个数字出现一次，但是现在有miss的情况。找出来第一个miss的number
//This is LeetCode 41 First Missing Positive
public class FindFirstMissNumber {
	public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int n = nums.length;
        int i = 0;
        while (i < n) {
           if (nums[i] > 0 && nums[i] != i + 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
               int temp = nums[i];
               nums[i] = nums[temp - 1];
               nums[temp - 1] = temp;
           } else {
               i++;
           }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return n + 1;
    }
}
