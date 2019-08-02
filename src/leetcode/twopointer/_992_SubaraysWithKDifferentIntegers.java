package leetcode.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.util.UtilityClass;

public class _992_SubaraysWithKDifferentIntegers {
	public static int subarraysWithKDistinct(int[] A, int K) {
		if (A.length == 0 || K == 0) return 0;
        int ans = 0;
        int tmp = -1;
        int n = A.length;
        int l = 0, r = 0;
        int[] count = new int[n];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        while (r < n) {
        	int tmpCount = 0;
            while (r < n && map.size() <= K ) {
                Queue<Integer> queue = map.getOrDefault(A[r], new LinkedList<Integer>());
                queue.offer(r);
                if (map.size() == K && !map.containsKey(A[r])) {
                	break;
                } else {
                	map.put(A[r], queue);
                    if (map.size() == K) {
                        tmpCount++;
                        count[r] = tmpCount;
                    }
                    r++;
                }
                
            }
            ans += tmpCount;
            r--;
            while (l <= r && map.size() == K) {
                map.get(A[l]).poll();
                if (map.get(A[l]).isEmpty()) {
                    map.remove(A[l]);
                } else {
                    int next = map.get(A[l]).peek();
                    tmp = Math.max(next, tmp);
                    if (tmp > 0) {
                        ans += tmpCount - count[tmp - 1];
                    }
                }
                l++;
            }
            r++;
        }
        return ans;
        
    }
	
	public static void printArray(int[] array, int l, int r) {
		StringBuilder sb = new StringBuilder();
		for (int i = l; i <= r; i++)
			sb.append(array[i] + "   ");
		System.out.println(sb.toString());
		System.out.println("______________________________");
	}
	
	
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = UtilityClass.stringToIntegerArray(line);
            line = in.readLine();
            int K = Integer.parseInt(line);
            
            int ret = subarraysWithKDistinct(A, K);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
