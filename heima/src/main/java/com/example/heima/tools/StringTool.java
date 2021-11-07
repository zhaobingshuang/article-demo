package com.example.heima.tools;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.01
 */
public class StringTool {

    public static void main(String[] args) {

    }

    public static void join(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        // String.join
        String s1 = String.join(", ", list);
        System.out.println(s1);

        // stream
        String s2 = list.stream().collect(Collectors.joining(", "));
        System.out.println(s2);

        // StringJoiner
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String s : list) {
            stringJoiner.add(s);
        }
        String s3 = stringJoiner.toString();
        System.out.println(s3);
    }

}
