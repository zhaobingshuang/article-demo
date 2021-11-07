//package com.example.heima.scope;
//
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//
///**
// * xxx
// *
// * @author 赵丙双
// * @date 2021.05.20
// */
//@Configuration
//public class Config {
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public BeanA beanA() {
//        return new BeanA();
//    }
//}