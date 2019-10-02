package com.java.samples.thread;

public class ExtendThread {
    public static void main(String args[]) throws InterruptedException {
        final StringBuffer builder = new StringBuffer("Start...\n");
        
        A a = new A(builder);
        B b = new B(builder);
        
        a.start();
        
        
        b.start();
        
        b.join();
        a.join();
        
        System.out.println("End of main Thread: " + builder);
    }
}

class A extends Thread {

    private StringBuffer builder;

    public A(StringBuffer builder) {
        this.builder = builder;
    }

    @Override
    public void run() {
        builder.append("\nStart: ");
        for (int i = 1; i <= 5; i++) {
            //            System.out.println("From thread A : i " + i);
            builder.append("A: ").append(i).append(", ");
        }
        //        System.out.println("Exit from A");
        builder.append("exit from A.");
    }
}

class B extends Thread {

    private StringBuffer builder;

    public B(StringBuffer builder) {
        this.builder = builder;
    }

    @Override
    public void run() {
        builder.append("\nStart: ");
        for (int i = 0; i <= 5; i++) {
            //            System.out.println("From thread B : i " + i);
            builder.append("B: ").append(i).append(", ");
        }
        //        System.out.println("Exit from B");
        builder.append("exit from B.");
    }
}
