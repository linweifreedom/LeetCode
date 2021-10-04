package leetcode.stack;

import java.util.Stack;

public class _735_AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty())
                stack.push(asteroid);
            else {
                boolean explore = false;
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    if (stack.peek() == -asteroid) {
                        stack.pop();
                        explore = true;
                        break;
                    } else if (stack.peek() < -asteroid) {
                        stack.pop();
                    } else {
                    	explore = true;
                    	break;
                    }
                    	
                }
                if (!explore)
                    stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) 
            ans[i] = stack.pop();
        return ans;
    }
	
	public static void main(String[] args) {
		int[] input = {5, 10, -5};
		_735_AsteroidCollision instance = new _735_AsteroidCollision();
		System.out.println(instance.asteroidCollision(input));
	}
}
