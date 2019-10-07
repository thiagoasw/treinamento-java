package com.java.samples.tdd;

public class Vacina {

    private final Virus virus;

    private final Seringa seringa;

    public Vacina(Virus virus, Seringa seringa) {
        this.virus = virus;
        this.seringa = seringa;
    }

    public Virus getVirus() {
        return virus;
    }

    public Seringa getSeringa() {
        return seringa;
    }

}
