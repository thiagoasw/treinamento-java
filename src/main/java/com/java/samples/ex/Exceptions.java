package com.java.samples.ex;

import java.io.IOException;

public class Exceptions {

    private static Exceptions exs;

    static {
        exs = new Exceptions();
    }

    public static void main(String[] args) {        
        try {
            exs.checkedException(6);
        } catch (IOException | RuntimeException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        System.err.println("-----");
        
        try {
            exs.statckOverflow();
        } catch (Error e) {
            System.out.println("Deu certo !!" + e.getMessage());
        } finally {
            System.out.println("Eu sempre executo !");
        }
    }

    void divideByZero1() {
        try {
            System.out.println(10 / 0);
            throw new RuntimeException("Crap !!");
        } catch (ArithmeticException aex) {
            System.out.println("Não da pra dividir por ZERO !!");
            throw aex;
        } catch (Exception e) {
            System.out.println("Deu pau na paradinha: " + e.getMessage());
        } finally {
            System.out.println("Ao menos eu tentei !!");
        }
        
        System.out.println("Fim !!");
    }

    void divideByZero2() {
        System.out.println(10 / 0);
    }

    void checkedException(int value) throws IOException {
        if (value % 2 == 0) {
            throw new RuntimeException("Foi sem querer !!");
        } else {
            System.out.println("Deu bom: " + value);
        }
    }

    void statckOverflow() {
        throw new StackOverflowError("Será que funciona?");
    }

}