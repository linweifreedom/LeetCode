package fb;

import java.util.HashMap;
import java.util.Map;

public class OrderString {
	public static String orderString(String a, String b) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : b.toCharArray())
			map.put(c, 0);
		StringBuilder sb = new StringBuilder();
		for (char c : a.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				sb.append(c);
		}
		for (int i = b.length() - 1; i >= 0; i--) {
			char c = b.charAt(i);
			int count= map.get(c);
			while (count > 0) {
				sb.insert(0, c); count--;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String a = "bbcadabcxyz";
		String b = "bca";
		System.out.println(orderString(a, b));
	}
}
