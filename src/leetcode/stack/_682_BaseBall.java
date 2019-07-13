package leetcode.stack;

import java.util.Stack;

public class _682_BaseBall {

	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		System.out.println(calPoints(ops));
	}
	
	public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        int points = 0;
        if (ops == null || ops.length == 0)
            return 0;
        for (int i = 0 ; i < ops.length; i++) {
            if (isNumeric(ops[i])) {
                Integer currentRound = Integer.parseInt(ops[i]);
                points += currentRound.intValue();
                stack.push(currentRound);
            } else {
                if (ops[i] == "C" && !stack.isEmpty()) {
                    Integer currentRound = stack.pop();
                    points -= currentRound.intValue();
                } else if (ops[i] == "D" && !stack.isEmpty()) {
                    points += stack.peek().intValue()*2;
                    stack.push(stack.peek().intValue()*2);
                } else if (ops[i] == "+" && stack.size() >= 2) {
                    Integer num1 = stack.pop().intValue();
                    Integer num2 = stack.pop().intValue();
                    Integer currentRound = num1 + num2;
                    points += currentRound;
                    stack.push(num1);
                    stack.push(num2);
                    stack.push(currentRound);
                    
                }
            }
            
        }
        return points;
    }
    
    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+?");
    }

}
