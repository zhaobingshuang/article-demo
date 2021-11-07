package com.example.heima.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.21
 */
@RestController
@RequestMapping
@Slf4j
public class Controller {

    @Autowired
    private BeanA beanA;

    @GetMapping("/a")
    public String a() {

        log.info(String.valueOf(beanA));
        log.info(String.valueOf(beanA.hashCode()));
        return "ok";
    }

}
