package leetcode.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _843_GuessTheWord {

	public void findSecretWord(String[] wordlist, Master master) {
		if (wordlist.length == 1) {
			master.guess(wordlist[0]);
			return;
		}
		int[][] totalCount = totalCount(wordlist);
		List<String> list = new LinkedList<String>(Arrays.asList(wordlist));
		Iterator<String> iter = null;
		PriorityQueue<String> pq = new PriorityQueue<String>(
				(o1, o2) -> getScore(o2, totalCount) - getScore(o1, totalCount));
		for (String word : list)
			pq.add(word);
		String firstWord = pq.poll();
		list.remove(firstWord);
		int match = master.guess(firstWord);
		if (match == 6)
			return;
		if (match == 0) {
			// remove all matched word
			iter = list.iterator();
			while (iter.hasNext()) {
				String next = iter.next();
				if (countMatch(firstWord, next) > 0)
					iter.remove();
			}
			pq.clear();
			for (String word : list)
				pq.add(word);

		}
		

		while (!pq.isEmpty()) {
			String word = pq.poll();
			list.remove(word);
			int testResult = master.guess(word);
			if (testResult == 6)
				return;
			if (testResult == 0) {
				// remove all matched word
				iter = list.iterator();
				while (iter.hasNext()) {
					String next = iter.next();
					if (countMatch(word, next) > 0)
						iter.remove();
				}
			}
			if (testResult > match) {
				match = testResult;
				// remove all record which match is less than testResult;
				iter = list.iterator();
				while (iter.hasNext()) {
					String next = iter.next();
					if (countMatch(word, next) < match)
						iter.remove();
				}
			}
			pq.clear();
			for (String tmp : list)
				pq.add(tmp);
		}

	}

	private int countMatch(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < 6; i++)
			if (s1.charAt(i) == s2.charAt(i))
				count++;
		return count;
	}

	private int[][] totalCount(String[] wordlist) {
		int[][] count = new int[6][26];
		for (String word : wordlist)
			for (int i = 0; i < 6; i++) {
				count[i][word.charAt(i) - 'a']++;
			}
		return count;
	}

	private int getScore(String word, int[][] totalCount) {
		int ans = 0;
		for (int i = 0; i < 6; i++)
			ans += totalCount[i][word.charAt(i) - 'a'];
		return ans;
	}

	public static void main(String[] args) {
		String[] words = { "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa", "qrjasy",
				"pcldos", "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw", "evtkhl",
				"bhpfla", "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb", "vdjgxx", "bugbyv",
				"zipjpc", "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop", "nkrfwn", "puvgve", "rqsqpq",
				"jwoswl", "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte", "hbaczn", "coifed", "hrctvp", "vkytbw",
				"dizcxz", "arabol", "uywurk", "ppywdo", "resfls", "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw",
				"onnwcy", "novblw", "mtxgwe", "rgrdbt", "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv",
				"ifwmwp", "jqmbib", "mypnvf", "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp",
				"mjcgvm", "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj", "yjjlwn", "blrogv", "bdplzs", "oxblph",
				"twejel", "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq",
				"brklfk" };
		_843_GuessTheWord instance = new _843_GuessTheWord();
		instance.findSecretWord(words, new Master());
	}
}

class Master {
	int count = 0;

	public int guess(String word) {
		String answer = "hbaczn";
		int same = 0;
		this.count++;
		for (int k = 0; k < 6; k++)
			if (word.charAt(k) == answer.charAt(k))
				same++;
		System.out.println("Test Time is  " + this.count + " Input is " + word + " match count " + same);
		return same;
	}

	public Master() {
	};
}
