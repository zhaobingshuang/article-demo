package com.company.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 小白专场：判断树是否相同 - 不建树
 *
 * @author 赵丙双
 * @since 2021.10.27
 */
public class SameBST {

    public boolean isSameBST(List<Integer> t1, List<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        // 节点数不同
        if (t1.size() != t2.size()) {
            return false;
        }

        // 两个树都为空
        if (t1.isEmpty()) {
            return true;
        }

        // 根节点的值不同
        if (!t1.get(0).equals(t2.get(0))) {
            return false;
        }

        // 分成两个子树
        List<List<Integer>> c1 = split(t1);
        List<List<Integer>> c2 = split(t2);
        // 递归判断
        return isSameBST(c1.get(0), c2.get(0)) && isSameBST(c1.get(1), c2.get(1));
    }

    /**
     * 分成左右子树
     */
    private List<List<Integer>> split(List<Integer> tree) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = tree.get(0);
        for (int i = 1; i < tree.size(); i++) {
            Integer n = tree.get(i);
            if (n < root) {
                left.add(n);
            } else {
                right.add(n);
            }
        }
        return Arrays.asList(left, right);
    }
}
