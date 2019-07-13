package leetcode.graph;

import java.util.HashMap;
import java.util.Map;

/*In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.*/
public class _997_FindTheTownJudge {
	public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> trustMap = new HashMap<>();
        Map<Integer, Integer> betrustMap = new HashMap<>();
        for (int[] t : trust) {
            int p1 = t[0];
            int p2 = t[1];
            trustMap.put(p1, trustMap.getOrDefault(p1, 0) + 1);
            betrustMap.put(p2, betrustMap.getOrDefault(p2, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : betrustMap.entrySet()) {
        	if ((entry.getValue() == N - 1) && !trustMap.containsKey(entry.getKey())) return entry.getKey();
        }
        return -1;
    }
}
