package com.example.springtx.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final ServiceA serviceA;

    private final ServiceB serviceB;

    public TestService(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

}
