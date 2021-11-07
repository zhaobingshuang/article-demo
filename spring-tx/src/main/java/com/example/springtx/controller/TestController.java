package com.example.springtx.controller;

import com.example.springtx.service.ServiceA;
import com.example.springtx.service.ServiceB;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ServiceA serviceA;
    private final ServiceB serviceB;


    public TestController(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    @RequestMapping("never")
    public String never () {
        serviceA.never();
        return "never";
    }

    @RequestMapping("mandatory")
    public String mandatory () {
        serviceA.mandatory();
        return "mandatory";
    }

    @RequestMapping("supports")
    public String supports () {
        serviceA.supports();
        return "supports";
    }

    @RequestMapping("not_supports")
    public String notSupports () {
        serviceA.notSupports();
        return "not_supports";
    }

    @RequestMapping("required")
    public String required () {
        serviceA.required();
        return "required";
    }

    @RequestMapping("required_new")
    public String required_new () {
        serviceA.requiredNew();
        return "required_new";
    }

    @RequestMapping("nested")
    public String nested () {
        serviceA.nested();
        return "nested";
    }

//    @RequestMapping("t2")
//    public String t2 () {
//        tableBService.insert();
//        return "ok";
//    }
}
