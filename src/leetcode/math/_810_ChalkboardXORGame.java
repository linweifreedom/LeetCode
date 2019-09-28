package leetcode.math;

public class _810_ChalkboardXORGame {
	public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;
        int x = 0;
        for (int i : nums) x ^= i;
        return x == 0;
    }
}
