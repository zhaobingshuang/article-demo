package com.example.heima.pattern;

public class GO {

    Object o = null;

    public Object get(int millis) {
        long base = System.currentTimeMillis();

        long now = 0;
        synchronized (this) {
            while (o == null) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                try {
                    this.wait(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                now = System.currentTimeMillis() - base;
            }
            return o;

        }
    }

    public void set(Object o) {
        synchronized (this) {
            this.o = o;
            this.notifyAll();
        }
    }

}
