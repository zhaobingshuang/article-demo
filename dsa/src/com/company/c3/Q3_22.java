package com.company.c3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class Q3_22 {

    private static final Set<String> operators = new HashSet<>();
    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            // 运算符
            if (operators.contains(token)) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int calculate(Integer a, Integer b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {


    }

}
