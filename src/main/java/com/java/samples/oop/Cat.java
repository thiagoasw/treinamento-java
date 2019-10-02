package com.java.samples.oop;

public class Cat implements Pet, Animal {

    @Override
    public int getFleas() {
        return 4;
    }

    @Override
    public String toString() {
        return "Cat [brain=" + hasBrain() + ", legs=" + getLegs() + ", fleas=" + getFleas() + "]";
    }
}
