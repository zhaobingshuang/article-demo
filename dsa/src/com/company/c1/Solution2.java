package com.company.c1;

import java.util.LinkedList;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.28
 */

class Solution2 {

    boolean[] visited;

    char[] chars;

    int n;

    List<String> res;

    public Solution2(String str) {
        this.chars = str.toCharArray();
        this.visited = new boolean[chars.length];
        this.res = new LinkedList<>();
        this.n = chars.length;
    }

    public static void main(String[] args) {
        String s = "abc";
        Solution2 solution1 = new Solution2(s);
        StringBuffer sb = new StringBuffer();
        solution1.back(sb, 0);
        System.out.println(solution1.res);
    }

    private void back(StringBuffer str, int i) {
        // 到头了
        if (i == n) {
            res.add(str.toString());
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                str.append(chars[j]);

                back(str, i + 1);

                visited[j] = false;
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}