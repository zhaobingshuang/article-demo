package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

    @Test
    public void testSimpleLoad() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring-config.xml");
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(myTestBean.getTestSr());

    }
}