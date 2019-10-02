package com.java.samples.oop;

public class Human implements Animal {

    @Override
    public int getLegs() {
        return 2;
    }
    
    @Override
    public String toString() {
        return "Human [brain=" + hasBrain() + ", legs=" + getLegs() + "]";
    }
}
