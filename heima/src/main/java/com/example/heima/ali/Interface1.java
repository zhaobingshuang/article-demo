package com.example.heima.ali;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.23
 */
public interface Interface1 {

    public static final int i = 0;

    public abstract int m1(int a);

    /**
     * 方法1
     *
     * @param a 参数 a
     * @return 返回
     */
    default int m2(int a) {
        System.out.println(a);
        return 0;
    }
}