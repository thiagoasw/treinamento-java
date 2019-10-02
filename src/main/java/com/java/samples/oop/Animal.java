package com.java.samples.oop;

public interface Animal {

    default public boolean hasBrain() {
        return true;
    }

    default int getLegs() {
        return 4;
    };

}
