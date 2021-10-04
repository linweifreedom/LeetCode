package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _460_LFUCache {
	class LFUCache {
	    Map<Integer, ListNode> nodeMap;
	    Map<Integer, DoublelyLinkedList> frequencyMap;
	    int capacity;
	    int lowestFrequency;
	    public LFUCache(int capacity) {
	        nodeMap = new HashMap<>();
	        frequencyMap = new HashMap<>();
	        this.capacity = capacity;
	        lowestFrequency = 0;
	    }
	    
	    public int get(int key) {
	        if (nodeMap.containsKey(key)) {
	            ListNode node = nodeMap.get(key);
	            updateNode(node);
	            return node.value;
	            
	        } 
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	        if (capacity == 0) return;
	        if (nodeMap.containsKey(key)) {
	            ListNode node = nodeMap.get(key);
	            node.value = value;
	            updateNode(node);
	        } else {
	            if (nodeMap.size() == capacity) {
	                DoublelyLinkedList list = frequencyMap.get(lowestFrequency);
	                ListNode node = list.removeFirst();
	                nodeMap.remove(node.key);
	            }
	            ListNode node = new ListNode(key, value, 1);
	            DoublelyLinkedList list = frequencyMap.getOrDefault(1, new DoublelyLinkedList());
	            list.addLast(node);
	            frequencyMap.put(1, list);
	            nodeMap.put(key, node);
	            lowestFrequency = 1;
	        }
	    }
	   
	    public void updateNode(ListNode node) {
	        DoublelyLinkedList list = frequencyMap.get(node.frequency);
	        list.remove(node);
	        if (list.isEmpty() && lowestFrequency == node.frequency) {
	            lowestFrequency++;
	        }
	        node.frequency++;
	        list = frequencyMap.getOrDefault(node.frequency, new DoublelyLinkedList());
	        list.addLast(node);
	        frequencyMap.put(node.frequency, list);
	    }
	    
	    class ListNode {
	        int value;
	        int key;
	        int frequency;
	        ListNode pre;
	        ListNode next;
	        public ListNode(int key, int value, int frequency) {
	            this.value = value;
	            this.key = key;
	            this.frequency = frequency;
	            this.pre = null;
	            this.next = null;
	        }
	    }
	    
	    class DoublelyLinkedList {
	        public ListNode head;
	        public ListNode tail;
	        
	        public boolean isEmpty() {
	            return head == null;
	        }
	        public void remove(ListNode node) {
	            if (node == null) return;
	            if (node.pre == null && node.next == null) {
	                head = null;
	                tail = null;
	            } else if (node.pre == null) {
	                head = head.next;
	                if (head == null) tail = null;
	                else 
	                    head.pre = null;
	            } else if (node.next == null) {
	                tail = tail.pre;
	                if (tail == null) head = null;
	                else
	                    tail.next = null;
	            } else {
	                node.pre.next = node.next;
	                node.next.pre = node.pre;
	            }
	            node.pre = null;
	            node.next = null;
	        }
	        public ListNode removeFirst() {
	            if (head == null) return null;
	            ListNode firstNode = head;
	            head = head.next;
	            if (head != null) {
	                head.pre = null;
	            } else {
	                tail = null;
	            }
	            firstNode.next = null;
	            firstNode.pre = null;
	            return firstNode;
	        }
	        
	        public void addLast(ListNode node) {
	            if (tail == null) {
	                head = node;
	                tail = node;
	                return;
	            }
	            tail.next = node;
	            node.pre = tail;
	            tail = node;
	        }
	    }
	    
	}

}
