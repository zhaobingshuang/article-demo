package com.company.c3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.27
 */
public class Q3_23_ab {

    private static final Map<String, Integer> MAP = new HashMap<>();
    static {
        MAP.put("(", 5);
        MAP.put("^", 4);
        MAP.put("*", 3);
        MAP.put("/", 3);
        MAP.put("+", 2);
        MAP.put("-", 2);
        MAP.put(")", 1);
    }

    public static void midFixToPostFix(String[] args) {
        int length;
        if (args == null || (length = args.length) == 0) {
            return;
        }

        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            String c = args[i];
            if (MAP.containsKey(c)) {
                // 运算符
                if (stack.isEmpty() || getLevel(c) > getLevel(stack.peek())) {
                    // 栈为空，或当前优先级高于栈顶优先级，无条件入栈
                    stack.push(c);
                } else {
                    // 当前优先级低于、等于栈顶优先级
                    if ("(".equals(c)) {
                        // “(” 始终无条件入栈
                        stack.push(c);
                    } else if (")".equals(c)) {
                        // 无条件弹出，直到遇到 “(”
                        String top;
                        while (!stack.isEmpty() && !"(".equals(top = stack.pop())) {
                            System.out.print(top);
                        }
                    } else if ("^".equals(c)) {
                        // 只弹出高优先级的
                        while (!stack.isEmpty() && !"(".equals(stack.peek()) && getLevel(stack.peek()) > getLevel(c)) {
                            System.out.print(stack.pop());
                        }
                        stack.push(c);
                    } else {
                        // 弹出相同、高优先级的
                        while (!stack.isEmpty() && !"(".equals(stack.peek()) && getLevel(stack.peek()) >= getLevel(c)) {
                            System.out.print(stack.pop());
                        }
                        stack.push(c);
                    }
                }

            } else {
                // 操作数
                System.out.print(c);
            }

        }
        // 弹出剩余的
        stack.forEach(System.out::print);

    }

    public static int getLevel(String operator) {
        return MAP.get(operator);
    }

    public static void main(String[] args) {
        String a = "a + b * c + ( d * e + f ) * g";
//        String a = "a + b * c + d";
//        String a = "2 ^ 2 ^ 3";
        midFixToPostFix(a.split(" "));

    }

}
