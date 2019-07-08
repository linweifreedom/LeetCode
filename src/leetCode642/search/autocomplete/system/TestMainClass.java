package leetCode.search.autocomplate.system;

public class TestMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s = {"i love you","island","iroman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem autosystem = new AutocompleteSystem(s, times);
		System.out.println(autosystem.input('i'));
		System.out.println(autosystem.input(' '));
		System.out.println(autosystem.input('a'));
		System.out.println(autosystem.input('#'));
	}

}
