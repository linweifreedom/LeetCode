package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class L22_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0)
			result.add("");
		else {
			for (int i = 0; i < n; i++) {
				for (String left : generateParenthesis(i))
					for (String right : generateParenthesis(n - i - 1))
						result.add("(" + left + ")" + right);
			}
		}
		return result;
	}
}
