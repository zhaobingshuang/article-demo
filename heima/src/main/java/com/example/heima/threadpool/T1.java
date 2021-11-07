package com.example.heima.threadpool;

import java.util.concurrent.*;

public class T1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try {
            int i = 1/ 0;
        } finally {
            System.out.println("finally");
        }

        ExecutorService executorService = new MyExecutorService(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        executorService.execute(() -> {
            System.out.println("执行");
            throw new Error("aaa");
        });


        Future<Object> submit = executorService.submit(() -> {
            System.out.println("执行");
            throw new Error("bbb");
        });

        submit.get();
    }

}

class MyExecutorService extends ThreadPoolExecutor {

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("beforeExecute 异常");
        throw new Error();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            System.out.println("111111111111");
        } finally {
            super.afterExecute(r, t);
        }
    }
}