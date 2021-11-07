package com.company.c3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 后缀转中缀，可能有多余的括号
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class Q3_23_c {

    private static final Set<String> operators = new HashSet<>();
    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("^");
    }

    public static String evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String token : tokens) {
            // 运算符
            if (operators.contains(token)) {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(token);
            }
        }

        if (stack.isEmpty()) {
            return "";
        }

        return stack.peek();
    }

    public static String calculate(String a, String b, String operator) {
        return "(" + a + operator + b + ")";
    }

    public static void main(String[] args) {
        String a = "223^^";
//        String a = "abc*+de*f+g*+";
        System.out.println(evalRPN(a.split("")));

    }

}
