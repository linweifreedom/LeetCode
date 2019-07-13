package leetcode.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146_LRUCache {

	private int capacity;
    private class LinkedNode {
        int key;
        int value;
    }
    private int count;
    private Map<Integer, LinkedNode> map = new HashMap<>();
    private LinkedList<LinkedNode> linkedList = new LinkedList<>();
     public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
         
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            moveNodeToTop(node);
            return node.value;
        } else {
        	return -1;
        }
            
    }
    
    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node == null) {
            node = new LinkedNode();
            node.key = key;
            node.value = value;
            linkedList.offerFirst(node);
            map.put(key, node);
            count++;
            if (count > capacity) {
            	map.remove(linkedList.getLast().key);
                linkedList.removeLast();
                
                count--;
            }
        } else {
            linkedList.remove(node);
            node.value = value;
            map.put(key, node);
            linkedList.offerFirst(node);
            
        }
    }
    
    public void moveNodeToTop(LinkedNode linkedNode) {
        linkedList.remove(linkedNode);
        linkedList.offerFirst(linkedNode);
    }
}
