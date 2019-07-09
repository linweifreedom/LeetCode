package test.testcase;

import leetcode.linkedlist.L146_LRUCache;

public class TestLRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L146_LRUCache lrucache = new L146_LRUCache(2);
		lrucache.put(1, 1);
		lrucache.put(2, 2);
		lrucache.get(1);
		lrucache.put(3, 3);
		lrucache.get(2);
		lrucache.put(4, 4);
		lrucache.get(1);
		lrucache.get(3);
		lrucache.get(4);
	}

}
