package org.example;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(myTestBean.getTestSr());

//        Car car = (Car) bf.getBean("car");
//        System.out.println(car.getBrand());


    }
}
