package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _990_SatisfiabilityOfEqualityEquations {
	public boolean equationsPossible(String[] equations) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Consider == 
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                Integer left = equation.charAt(0) - 'a';
                Integer right = equation.charAt(3) - 'a';
                ArrayList<Integer> leftList = map.getOrDefault(left, new ArrayList<>());
                ArrayList<Integer> rightList = map.getOrDefault(right, new ArrayList<>());
                leftList.add(right);
                rightList.add(left);
                map.put(left, leftList);
                map.put(right, rightList);
            }
        }
        int[] grouparray = new int[26];
        int group = 1;
        for (int i = 0; i <= 25; i++) {
            if (grouparray[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int top = stack.pop();
                    grouparray[top] = group;
                    if (map.containsKey(top)) {
                        for (Integer node : map.get(top)) {
                            if (grouparray[node.intValue()] == 0)
                                stack.push(node);
                        }
                    }
                }
                group++;
            }
        }
        
        //Consider != 
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char left = equation.charAt(0);
                char right = equation.charAt(3);
                if (left == right || (grouparray[left - 'a'] == grouparray[right - 'a']))
                    return false;
            }
        }
        return true;
        
    }
}
