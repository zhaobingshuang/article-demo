package com.example.heima.test.t1;

/**
 * @author lidongsheng
 * @Package com.company.Synchronized.bank
 * @email lidongsheng@lasoplanet.com
 * @date 2021/12/9 17:20
 * @Copyright © Laso-beijing
 */
public class Account2 {

    private Allocator allocator = new Allocator();

    private int id;

    private int balance;

    public Allocator getAllocator() {
        return allocator;
    }

    public void setAllocator(Allocator allocator) {
        this.allocator = allocator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account2(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account2{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    /**
     * 转账
     *
     * @param target
     * @param amt
     */
    void transfer(Account2 target, int amt) {
        //一次性申请转出转入账户
//        while (allocator.apply(this.getId(), target.getId())) ;

        try {
            //锁定转出账户
            synchronized (this) {
                //锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.setBalance(balance - amt);
                        target.setBalance(target.getBalance()+amt);
                    }
                }
            }
        } finally {
            //最终释放锁
//            allocator.free(this.getId(), target.getId());
        }
    }

}
