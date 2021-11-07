package org.example;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class MyTestBean {

    private String testSr = "testSr";

    public String getTestSr() {
        return testSr;
    }

    public void setTestSr(String testSr) {
        this.testSr = testSr;
    }
}