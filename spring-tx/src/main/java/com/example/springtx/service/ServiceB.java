package com.example.springtx.service;

import com.example.springtx.dao.DaoB;
import com.example.springtx.entity.TableB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ServiceB {

    private final DaoB daoB;

    public ServiceB(DaoB daoB) {
        this.daoB = daoB;
    }

    @Transactional(propagation = Propagation.NEVER)
    public void never() {
        daoB.insert(new TableB("B"));
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        daoB.insert(new TableB("B"));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {

        daoB.insert(new TableB("B"));
//        int a = 1 / 0;
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupports() {

        daoB.insert(new TableB("B"));
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        daoB.insert(new TableB("B"));
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiredNew() {
        daoB.insert(new TableB("B"));
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested() {
        daoB.insert(new TableB("B"));
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        int a = 1 / 0;
    }
}
