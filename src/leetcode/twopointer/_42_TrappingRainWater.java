package leetcode.twopointer;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.*/
public class _42_TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 3)
			return 0;
		int left = 0, right = height.length - 1,  count = 0;
		int left_max = 0, right_max = 0;
		//Use Two Pointer
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max)
					left_max = height[left];
				else
					count += left_max - height[left];
				left++;
			} else {
				if (height[right] >= right_max) 
					right_max = height[right];
				else
					count += right_max - height[right];
				right--;
			}
		}
		return count;
		
	}
}
