package com.java.samples.oop;

public class RubberDuck implements Pet, Animal {

    @Override
    public boolean hasBrain() {
        return false;
    }

    @Override
    public int getLegs() {
        return 0;
    }

    @Override
    public int getFleas() {
        return 0;
    }

    @Override
    public String toString() {
        return "RubberDuck [" + hasBrain() + ", legs=" + getLegs() + ", fleas=" + getFleas() + "]";
    }
}
