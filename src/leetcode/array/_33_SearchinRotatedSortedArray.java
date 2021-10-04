package leetcode.array;

public class _33_SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] == target) return left;
            else if (nums[right] == target) return right;
            else if (target < nums[mid]) {
               //should find small number
                if (nums[mid] > nums[right]) {
                    if (target > nums[right])
                        right = mid - 1;
                    else
                        left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //should find larger number
                if (nums[mid] > nums[right])
                    left = mid + 1;
                else {
                    if (target < nums[right])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }
        if (left == right && target == nums[left]) return left;
        return -1;
    }
}
