package com.example.springtx.service;

import com.example.springtx.dao.DaoA;
import com.example.springtx.entity.TableA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ServiceA {

    private final DaoA daoA;

    private final ServiceB serviceB;

    public ServiceA(DaoA daoA, ServiceB serviceB) {
        this.daoA = daoA;
        this.serviceB = serviceB;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void never() {
        daoA.insert(new TableA("A"));

        serviceB.never();
    }


//    @Transactional(propagation = Propagation.REQUIRED)
    public void mandatory() {
        daoA.insert(new TableA("A"));

        serviceB.mandatory();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void supports() {
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        daoA.insert(new TableA("A"));

        serviceB.supports();
        int a = 1 / 0;
    }

//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void notSupports() {
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        daoA.insert(new TableA("A"));

        serviceB.notSupports();
//        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        daoA.insert(new TableA("A"));
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

                serviceB.required();
            try {

            } catch (Exception e) {

            }
//        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiredNew() {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        daoA.insert(new TableA("A"));

        serviceB.requiredNew();
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void nested() {
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        daoA.insert(new TableA("A"));

        serviceB.nested();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        int a = 1 / 0;
    }
}
