package leetcode.string;

public class _729_CustomSortString {
	public static String customSortString(String order, String s) {
		StringBuilder str = new StringBuilder();
		char arrS[] = s.toCharArray();
		char arr[] = order.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arrS.length; j++) {
				if (arr[i] == arrS[j])
					str.append(arrS[j]);

			}
		}
		for (char c : s.toCharArray()) {
			if (order.indexOf(c) == -1)
				str.append(c);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String order = "cbafg";
		String s = "abcd";
		System.out.println(customSortString(order, s));
	}

}
