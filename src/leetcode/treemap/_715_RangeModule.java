package leetcode.treemap;

import java.util.TreeMap;

public class _715_RangeModule {
    TreeMap<Integer, Integer> range;
    public _715_RangeModule() {
        this.range = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        while (range.floorKey(left) != null && range.floorEntry(left).getValue() >= left) {
            left = range.floorKey(left);
            right = Math.max(right, range.get(left));
            range.remove(left);
        }
        while (range.ceilingKey(left) != null && range.ceilingKey(left) <= right) {
            right = Math.max(right, range.ceilingEntry(left).getValue());
            range.remove(range.ceilingKey(left));
        }
        range.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        if (range.floorKey(left) != null && range.floorEntry(left).getValue() >= right)
            return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
    	Integer oldLeft = null; Integer oldRight = null;
        while (range.floorKey(right) != null && range.floorEntry(right).getValue() > left) {
            Integer leftSide = range.floorKey(right);
            Integer rightSide= range.get(leftSide);
            range.remove(leftSide);
            oldLeft = oldLeft == null ? leftSide : Math.min(leftSide, oldLeft);
            oldRight = oldRight == null ? rightSide : Math.max(rightSide, oldRight);
        }  
        if (oldLeft != null && oldLeft < left)
            range.put(oldLeft, left);
        if (oldRight != null && oldRight > right)
            range.put(right, oldRight);   
        System.out.println("finish");
    }
	
	public static void main(String[] args) {
		_715_RangeModule instance = new _715_RangeModule();
		instance.addRange(6, 8);
		instance.removeRange(7, 8);
		instance.removeRange(8, 9);
		instance.addRange(8, 9);
		instance.removeRange(1, 3);
		instance.addRange(1, 8);
		instance.queryRange(2, 9);
	}
}
