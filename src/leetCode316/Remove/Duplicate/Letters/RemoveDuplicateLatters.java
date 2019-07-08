package leetCode316.Remove.Duplicate.Letters;

public class RemoveDuplicateLatters {
	public static String removeDuplicateLetters(String s) {
		char[] chs = s.toCharArray();
		int[] count = new int[26];
		char[] stack = new char[26];
		boolean[] inStack = new boolean[26];
		for (char c : chs) count[c - 'a']++;
		int top = -1, n = s.length();
		for (char c : chs) {
			int i = c - 'a';
			count[i]--;
			if(inStack[i])continue;
			while(top >= 0 && count[stack[top] - 'a'] > 0 && stack[top] > c ) {
				inStack[stack[top--] - 'a'] = false;
				
			}
			stack[++top] = c;
			inStack[i] = true;
		}
		return String.valueOf(stack, 0, top+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbacdcbc";
		System.out.println(RemoveDuplicateLatters.removeDuplicateLetters(s));
	}
}
