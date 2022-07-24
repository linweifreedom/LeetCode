package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ConsistenseHashing {
	public static class Solution {
	    public int n, k;
	    public Set<Integer> ids = null;
	    public Map<Integer, List<Integer>> machines = null;
	    /*
	     * @param n: a positive integer
	     * @param k: a positive integer
	     * @return: a Solution object
	     */
	    public static Solution create(int n, int k) {
	        // Write your code here
	        Solution solution = new Solution();
	        solution.n = n;
	        solution.k = k;
	        solution.ids = new TreeSet<Integer>();
	        solution.machines = new HashMap<>();
	        return solution;
	    }

	    /*
	     * @param machine_id: An integer
	     * @return: a list of shard ids
	     */
	    public List<Integer> addMachine(int machine_id) {
	        // write your code here
	        Random r = new Random();
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < k; i++) {
	            int nextIndex = r.nextInt(n);
	            while (ids.contains(nextIndex))
	                nextIndex = r.nextInt(n);
	            ids.add(nextIndex);
	            list.add(nextIndex);
	        }
	        Collections.sort(list);
	        machines.put(machine_id, list);
	        return list;
	    }

	    /*
	     * @param hashcode: An integer
	     * @return: A machine id
	     */
	    public int getMachineIdByHashCode(int hashcode) {
	        // write your code here
	        int distance = n + 1;
	        int machine_id = 0;
	        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
	            int key = entry.getKey();
	            List<Integer> nodes = entry.getValue();
	            for (Integer num : nodes) {
	                int d = num - hashcode;
	                if (d < 0)
	                    d += n;
	                if (d < distance) {
	                    distance = d;
	                    machine_id = key;
	                }
	            }
	        }
	        return machine_id;
	    }
	}
}
