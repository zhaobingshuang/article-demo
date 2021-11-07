package com.company.leetcode.q0150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 逆波兰表达式求值，String 栈
 *
 * 如果遇到操作数，则将操作数入栈；
 * 如果遇到运算符，则将两个操作数出栈，其中先出栈的是右操作数，后出栈的是左操作数，使用运算符对两个操作数进行运算，将运算得到的新操作数入栈。
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class Q150 {

    private static final Set<String> operators = new HashSet<>();
    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                // 运算符
                String b = stack.pop();
                String a = stack.pop();
                int c = calculate(a, b, token);
                stack.push(c + "");
            } else {
                // 操作数
                stack.push(token);
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(stack.pop());
    }

    public int calculate(String x, String y, String operator) {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
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
}