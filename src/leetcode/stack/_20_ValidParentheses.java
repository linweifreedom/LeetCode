package leetcode.stack;

import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.*/
public class _20_ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		if (s.length() % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '[' || c == '(' || c == '{') 
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if ((c ==']' && top != '[') || (c == ')' && top != '(') || (c == '}' && top != '{'))
					return false;
				
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
