package com.example.heima.test.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lidongsheng
 * @Package com.company.Synchronized.bank
 * @email lidongsheng@lasoplanet.com
 * @date 2021/12/9 17:25
 * @Copyright © Laso-beijing
 */
public class Account2Test {

    public static void main(String[] args) throws InterruptedException {
        // Account2-测试 for：解决死锁
        Account2 from = new Account2(100,1000);
        Account2 to = new Account2(101,200);
        //预分配资源
/*        List<Integer> allocatorLists = new ArrayList<>();
        allocatorLists.add(100);
        allocatorLists.add(101);
        Allocator allocator = new Allocator(allocatorLists);
        from.setAllocator(allocator);
        to.setAllocator(allocator);*/

        Thread thread = new Thread(() -> {
            from.transfer(to, 100);
        });

        thread.start();
//        thread.join();
        Thread.sleep(1000);

/*        new Thread(()->{
            to.transfer(from,100);
        }).start();*/

        System.out.println("from = " + from);
        System.out.println("to = " + to);


    }
}
