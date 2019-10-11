package com.java.oodp.samples.factory;

public class SimpleFactory {

    public static void main(String[] args) {

        Telefone.fromNumber("3432432434");
        
    }
}

class Telefone {

    private int ddi;
    private int ddd;
    private String number;

    private Telefone() {} 
    
    protected Telefone(int ddi, int ddd, String number) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.number = number;
    }

    public static Telefone fromNumber(String number) {
        return new Telefone(0, 0, number);
    }
    
    public static Telefone withDDDAndNumber(int ddd, String number) {
        return new Telefone(0, ddd, number);
    }
    
    public static Telefone from(int ddi, int ddd, String number) {
        return new Telefone(ddi, ddd, number);
    }
}
