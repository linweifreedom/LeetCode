package leetcode.heap;

import java.util.PriorityQueue;

public class _703_KthLargest {
	private PriorityQueue<Integer> queue;
    private int size;

	public _703_KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>(k);
        size = k;
        if (nums == null || nums.length == 0)
            return;
        for (int val : nums)
            adjust(val);
	}

	public int add(int val) {
        adjust(val);
        return queue.peek();
	}

	private void adjust(int val) {
        if(queue.size() < size)
            queue.offer(val);
        else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
	}

	private boolean isNullOrEmpty(int[] nums) {
		return nums == null || nums.length == 0;
	}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		_703_KthLargest kLarge = new _703_KthLargest(2, nums);
		System.out.println(kLarge.add(-1));
		System.out.println(kLarge.add(1));
		System.out.println(kLarge.add(-2));
		System.out.println(kLarge.add(-4));
		System.out.println(kLarge.add(3));
	}
}
