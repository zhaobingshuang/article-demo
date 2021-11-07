package com.example.heima.enumtest;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/10
 */
public enum FileType {

    /**
     * aa
     */
    DOC("doc");

    public final String name;

    FileType(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        System.out.println(DOC);
        System.out.println(DOC.name);
        System.out.println(DOC.name());

//        DOC.name = "test";

        System.out.println(DOC);
        System.out.println(DOC.name);
        System.out.println(DOC.name());
    }
}
