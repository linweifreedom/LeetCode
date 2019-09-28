package leetcode.tree;

import java.util.Stack;

public class _1106_ParsingABooleanExpression {
	public boolean parseBoolExpr(String expression) {
        Stack<Character> symbolStack = new Stack<Character>();
        Stack<Character> numberStack = new Stack<Character>();
        int i = 0; 
        char[] chars = expression.toCharArray();
        int n = chars.length;
        while (i < n) {
            char c = chars[i];
            if (c == '!' || c == '&' || c == '|') symbolStack.push(c);
            else if (c == '(' || c == 't' || c == 'f') numberStack.push(c);
            else if (c == ')') {
                char symbol = symbolStack.pop();
                Boolean curbool = null;
                while (!numberStack.isEmpty()) {
                    char next = numberStack.pop();
                    if (next == '(') {
                        char cur = curbool ? 't' : 'f';
                        numberStack.push(cur);
                        break;
                    } else {
                        boolean nextbool = next =='t' ? true : false;
                        if (curbool == null) curbool = nextbool;
                        if (symbol == '!')
                            curbool = !nextbool;
                        else if (symbol == '&')
                            curbool = curbool && nextbool;
                        else if (symbol == '|')
                            curbool = curbool || nextbool;
                    }
                }
            }
            i++;
        }
        return numberStack.pop() == 't' ? true : false;
    }
}
/*
 * Return the result of evaluating a given boolean expression, represented as a
 * string.
 * 
 * An expression can either be:
 * 
 * "t", evaluating to True; "f", evaluating to False; "!(expr)", evaluating to
 * the logical NOT of the inner expression expr; "&(expr1,expr2,...)",
 * evaluating to the logical AND of 2 or more inner expressions expr1, expr2,
 * ...; "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner
 * expressions expr1, expr2, ...
 */