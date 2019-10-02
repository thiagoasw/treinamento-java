package com.java.samples.oop;

public class Dog implements Pet, Animal {

    private final int fleas;

    public Dog(int fleas) {
        this.fleas = fleas;
    }

    public Dog() {
        fleas = 8;
    }

    @Override
    public int getFleas() {
        return fleas;
    }

    @Override
    public String toString() {
        return "Dog [brain=" + hasBrain() + ", legs=" + getLegs() + ", fleas=" + getFleas() + "]";
    }

}
