package com.java.samples.tdd;

public enum Virus {

    GRIPE(100);

    private final int dose;

    Virus(int dose) {
        this.dose = dose;
    }

    public int getDosePadrao() {
        return dose;
    }

}
