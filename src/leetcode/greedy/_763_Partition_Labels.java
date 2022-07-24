package leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _763_Partition_Labels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> partitionLabels(String s) {
        //get first and last index , merge interval
		if (s == null || s.isEmpty()) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int cur = 0;
        List<Integer> ans = new ArrayList<>();
        while (cur < s.length()) {
        	int index = cur;
        	char c = s.charAt(cur);
        	int end = map.get(c);
        	while (index < end) {
        		index++;
        		c = s.charAt(index);
        		end = Math.max(end, map.get(c));
        	}
        	int range = end - cur + 1;
        	ans.add(range);
        	cur = end + 1;
        }
        return ans;
        
    }

}
