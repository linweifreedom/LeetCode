package test.testcase;

import leetcode.linkedlist._146_LRUCache;

public class TestLRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_146_LRUCache lrucache = new _146_LRUCache(2);
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
