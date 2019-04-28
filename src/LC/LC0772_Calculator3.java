package LC;

import java.util.Stack;

public class LC0772_Calculator3 {
    private int calculate(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {

            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i < len - 1 && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numbers.push(sum);
            }
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                operations.push(c);
            }
            if (c == ')') {
                while (operations.peek() != '(') {
                    numbers.push(pollHelper(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.pop();   //get rid of '('
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operations.isEmpty() && hasPriority(c, operations.peek())) {
                    numbers.push(pollHelper(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.push(c);
            }
        }

        while (!operations.isEmpty()) {
            numbers.push(pollHelper(operations.pop(), numbers.pop(), numbers.pop()));
        }
        return numbers.pop();
    }
    private boolean hasPriority(char cur, char prev) {
        //prev has high priority -> can calculate
        if ((prev == '+' || prev == '-') && (cur == '*' || cur == '/')) {
            return false;
        }
        if (prev == '(' || prev == ')') {
            return false;
        }
        return true;
    }
    private int pollHelper(char operator, int b, int a) {
        if (operator == '+') {
            return a + b;
        }
        if (operator == '-') {
            return a - b;
        }
        if (operator == '*') {
            return a * b;
        }
        if (operator == '/') {
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC0772_Calculator3 test = new LC0772_Calculator3();

        String s = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(test.calculate(s));
    }

}
