package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test() {
    }

//    @Before("test()")
    public void beforeTest() {
        System.out.println("Before");
    }

//    @After("test()")
    public void afterTest() {
        System.out.println("After");
    }

//    @AfterThrowing("test()")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }
//
//    @After("test()")
//    public void afterTest2() {
//        System.out.println("afterTest2");
//    }

//    @AfterReturning("test()")
    public void aftereturn() {
        System.out.println("AfterReturning");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("Aroundbefore");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Aroundafter");
        return o;
    }
}
