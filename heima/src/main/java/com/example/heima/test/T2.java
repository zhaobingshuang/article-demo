package com.example.heima.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.24
 */
public class T2 {

    public static void main(String[] args) {
//        Super[] supers = new Sub[2];


//        List<Super> ls = new ArrayList<Sub>();
        
        Sub[] sub = {new Sub()};
        List<Super> subs = Arrays.asList(sub);
        Super aSuper = subs.get(0);
        System.out.println(aSuper);
    }

    static class Super {}

    static class Sub extends Super {}
}
