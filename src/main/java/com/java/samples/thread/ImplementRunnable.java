package com.java.samples.thread;

public class ImplementRunnable {
    public static void main(String args[]) {
        new Thread(new X()).start();
        new Thread(new Y()).start();
        System.out.println("End of main Thread");
    }
}
class X implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("From thread X : i " + i);
        }
        System.out.println("Exit from X");
    }
}
class Y implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("From thread Y : i " + i);
        }
        System.out.println("Exit from Y");
    }
}