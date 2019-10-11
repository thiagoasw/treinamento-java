package com.java.oodp.samples.singleton;

public class Singleton {

    private static Singleton instance;
    
    private int count = 0;

    private Singleton() {}

    public int getAcessoTotalAoToString() {
        return count;
    }

    @Override
    public String toString() {
        count++;
        return "Singleton [ toString ... ]";
    }
    
    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
