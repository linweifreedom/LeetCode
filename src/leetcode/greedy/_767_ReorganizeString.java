package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _767_ReorganizeString {
	public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> q = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for (Character key : map.keySet())
            q.offer(key);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            if (!q.isEmpty() && sb.length() > 0 && curr == sb.charAt(sb.length() - 1)) {
                char nextChar = q.poll();
                q.offer(curr);
                curr = nextChar;
            }
            int count = map.get(curr);
            count--;
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == curr) 
                return "";
            sb.append(curr);
            if (count == 0) {
                map.remove(curr);
            } else {
                map.put(curr, count);
                q.offer(curr);
            }
        }
        return sb.toString();
    }
}
