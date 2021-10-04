package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Note: Chapter 2 is a harder version of this puzzle.
You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
The encyclopedia consists of NN different web pages, numbered from 11 to NN. Each page ii contains nothing but a single link to a different page L_i.
A session spent on this website involves beginning on one of the NN pages, and then navigating around using the links until you decide to stop. That is, while on page ii, you may either move to page L_i, or stop your browsing session.
Assuming you can choose which page you begin the session on, what's the maximum number of different pages you can visit in a single session? Note that a page only counts once even if visited multiple times during the session.
*/
public class RabbitHoles {
	int ans = 0;
	  public int getMaxVisitableWebpages(int N, int[] L) {
	    // Write your code here
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 1; i <= N; i++) {
	      if (!map.containsKey(i)) {
	        helper(i, map, L);
	      }
	    }
	    return ans;
	  }
	  
	  public void helper(int currentNum, Map<Integer, Integer> map, int[] L) {
	    List<Integer> preList = new ArrayList<>();
	    Set<Integer> preSet = new HashSet<>();
	    while (!preSet.contains(currentNum) && !map.containsKey(currentNum)) {
	      preSet.add(currentNum);
	      preList.add(currentNum);
	      currentNum = L[currentNum - 1];
	    }
	    if (preSet.contains(currentNum)) {
	      int length = preList.size() - preList.indexOf(currentNum);
	      for (int i : preList)
	        map.put(i, length);
	      ans = Math.max(ans, length);
	    } else {
	      int length = map.get(currentNum);
	      for (int i = preList.size() - 1; i >= 0; i--) {
	        length++;
	        map.put(preList.get(i), length);
	      }
	      ans = Math.max(ans, map.get(preList.get(0)));
	    }
	  }
}
