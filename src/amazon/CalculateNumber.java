package amazon;

import java.util.PriorityQueue;

//input is stream of integer, implement add(int num), findAvg, findMedian
public class CalculateNumber {
	
	PriorityQueue<Integer> minHeap;//minHeap store large value
	PriorityQueue<Integer> maxHeap;//maxHeap store small value
	long sum; //if sum is very large, can use avg * count + module
	int n;
	public CalculateNumber() {
		minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
		maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
	}
	
	public void add(int num) {
		sum += num;
		n++;
		if (minHeap.size() <= maxHeap.size())
			minHeap.add(num);
		else
			maxHeap.add(num);
		if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
			maxHeap.add(minHeap.poll());
			minHeap.add(maxHeap.poll());
		}
		
	}
	
	public void findAvg() {
		System.out.println((int) (sum / n));
	}
	
	public void findMedian() {
		if (n % 2 == 1)
			System.out.println(minHeap.peek());
		else
			System.out.println((minHeap.peek() + maxHeap.peek()) / 2);
	}
	
	
	public static void main(String[] args) {
		CalculateNumber c = new CalculateNumber();
		c.add(1);
		c.add(3);
		c.findAvg();
		c.findMedian();
		c.add(5);
		c.findAvg();
		c.findMedian();
		c.add(3);
		c.findAvg();
		c.findMedian();
		c.add(5);
		c.findAvg();
		c.findMedian();
		c.add(6);
		c.findAvg();
		c.findMedian();
		
		
	}

}
