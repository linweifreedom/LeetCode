package amazon;

import java.util.Stack;

/*�ж�һ��string�Ƿ�Valid������1����һ��valid��stringͷβ����ͬ��ĸ�� ���� AA ��valid ��ô BAAB����valid������valid��
����2������valid��string��concatenation��valid������AA��BB��valid����ôAABB����valid��

����: EABBACDDFFCE
BB��Valid����ABBA��valid��DD��FF��valid����DDFF��valid������CDDFFC��valid ����ABBACDDFFC��valid��
����EABBACDDFFCE��valid.*/
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
