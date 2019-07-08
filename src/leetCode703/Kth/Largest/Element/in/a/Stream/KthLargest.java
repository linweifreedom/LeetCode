package leetCode703.Kth.Largest.Element.in.a.Stream;

import java.util.Arrays;

public class KthLargest {
	//Use Linked List
    class LinkedNode {
        int val;
        LinkedNode next;
        LinkedNode pre;
        LinkedNode(int val) {
            this.val = val;
        }
    }
    private LinkedNode head, target, tail;
    
    public KthLargest(int k, int[] nums) {
        head = new LinkedNode(0);
        tail = head;
        if (nums != null && nums.length > 0) {
        	Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                LinkedNode tmpNode = new LinkedNode(nums[i]);
                tail.next = tmpNode;
                tmpNode.pre = tail;
                tail = tmpNode;
                if (i == nums.length - k)
                    target = tmpNode;
            }
        }
        if (nums != null && nums.length < k)
        	target = tail;
        
    }
    
    public int add(int val) {
        LinkedNode cur = head.next;
        LinkedNode newNode = new LinkedNode(val);
        if (cur == null) {
        	head.next = newNode;
        	newNode.pre = head;
        	target = newNode;
        	return target.val;
        }
        while (cur != null && cur.next != null && val <= cur.val) {
            cur = cur.next;
        }
        
        if (val > cur.val) {
            cur.pre.next = newNode;
            newNode.pre = cur.pre;
            newNode.next = cur;
            cur.pre = newNode;
            
        } else if (cur.next == null) {
            cur.next = newNode;
            newNode.pre = cur;
        }
        if (val <= target.val)
            return target.val;
        else  {
            target = target.pre;
            return target.val;
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		KthLargest kLarge = new KthLargest(2, nums);
		System.out.println(kLarge.add(-1));
		System.out.println(kLarge.add(1));
		System.out.println(kLarge.add(-2));
		System.out.println(kLarge.add(-4));
		System.out.println(kLarge.add(3));
	}
}
