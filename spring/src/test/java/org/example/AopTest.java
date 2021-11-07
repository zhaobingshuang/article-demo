package org.example;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testSimpleLoad() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring-config.xml");
        TestBean myTestBean = (TestBean) bf.getBean("test");
        myTestBean.test();
    }
}