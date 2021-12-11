package com.example.heima.test.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidongsheng
 * @Package com.company.Synchronized.bank
 * @email lidongsheng@lasoplanet.com
 * @date 2021/12/9 17:19
 * @Copyright © Laso-beijing
 */
public class Allocator {

    public Allocator(List<Integer> als) {
        this.als = als;
    }

    public Allocator() {
    }

    private List<Integer> als = new ArrayList<>();

    public void setAls(List<Integer> als) {
        this.als = als;
    }

    public List<Integer> getAls() {
        return als;
    }

    /**
     * 一次性申请所有的资源
     * @param from
     * @param to
     * @return
     */
    synchronized boolean apply(Integer from, Integer to){
        if (als.contains(from)|| als.contains(to)) {
            return false;
        } else{
            als.add(from);
            als.add(to);
        }
        System.out.println("申请资源成功");
        return true;
    }

    /**
     * 归还资源
     * @param from
     * @param to
     */
    synchronized void free(Integer from, Integer to){
        als.remove(from);
        als.remove(to);
    }

}
