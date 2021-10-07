package google;

import java.util.HashSet;
import java.util.Set;

/*有两个func, 一个put, 放进去一个数，一个get,拿出已经put进去的数里面missing的最小的数。
比如put 1,2,3,6,8,7
那么get就应该返回4
再put4
get就返回5*/
public class MinMissingNum {
	Set<Integer> set;
	int currentMissing;
	boolean noMissing;
	public MinMissingNum() {
		set = new HashSet<>();
		currentMissing = 1;
	}
	
	public void put(int num) {
		set.add(num);
		if (num < currentMissing)
			currentMissing = num - 1;
		if (currentMissing == num) {
			while (set.contains(currentMissing)) {
				currentMissing++;
				if (currentMissing == Integer.MAX_VALUE) {
					noMissing = true;
					break;
				}
			}
		}
		get();
	}
	
	public int get() {
		System.out.println(currentMissing);
		if (noMissing)
			return -1;
		else
			return currentMissing;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinMissingNum instance = new MinMissingNum();
		int[] inputs = {1,2,3,6,8,7,4,10,5,20, 15,14,13,12,11, 9};
		for (int i = 0; i< inputs.length;i++) {
			instance.put(inputs[i]);
		}
	}

}
