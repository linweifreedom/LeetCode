package amazon;

import java.util.Stack;

/*判断一个string是否Valid。条件1：在一个valid的string头尾加相同字母， 比如 AA 是valid 那么 BAAB就是valid。空是valid。
条件2：两个valid的string的concatenation是valid，比如AA和BB是valid，那么AABB就是valid。

例子: EABBACDDFFCE
BB是Valid所以ABBA是valid，DD和FF是valid所以DDFF是valid，所以CDDFFC是valid 所以ABBACDDFFC是valid，
所以EABBACDDFFCE是valid.*/
public class ValidString {

	public static boolean isValid(String s) {
		Stack<Character> unPairedStack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!unPairedStack.isEmpty() && unPairedStack.peek() == c) {
				unPairedStack.pop();
			} else {
				unPairedStack.push(c);
			}
		}
		System.out.println(unPairedStack.isEmpty());
		return unPairedStack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidString.isValid("EABBACDDFFCE");
		ValidString.isValid("");
		ValidString.isValid("AB");
		ValidString.isValid("ABBA");
		ValidString.isValid("CABBA");
		ValidString.isValid("CABCAB");
	}

}
