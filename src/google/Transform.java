package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Give two area, A[0,1,3,5,6] B[1,5,3,6,0] . based on the mapping relationship, transform input array
public class Transform {
	Map<Integer, Integer> map;
	int n;
	public Transform(int[] A, int[] B) throws Exception {
		if(A.length != B.length)
			throw new Exception();
		n = A.length;
		Map<Integer, List<Integer>> cache = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<Integer> list = cache.getOrDefault(A[i], new ArrayList<>());
			list.add(i);
			cache.put(A[i], list);
		}
		for (int i = 0; i < n; i++) {
			List<Integer> list = cache.get(B[i]);
			if (list.isEmpty()) throw new Exception();
			map.put(list.get(0), i);
			list.remove(0);
		}
	}
	public String[] transform(String[] input) {
		String[] ans = new String[n];
		if (input.length != n) return ans;
		for (int i = 0; i < n; i++) {
			int newIndex = map.get(i);
			ans[newIndex] = input[i];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
