package com.java.oodp.samples.decorator;

public class Coffee {

    public static void main(String[] args) {
        
        Espresso e = new Espresso();
        Capuccino c = new Capuccino();
        
        System.out.println("Espresso: " + e.getPrice());
        System.out.println("Capuccino: " + c.getPrice());
        
        System.out.println("Espresso com canela: " + new ComCanela(e).getPrice());
        System.out.println("Capuccino com canela: " + new ComCanela(c).getPrice());
        
        System.out.println("Espresso duplo: " + new Espresso(new Espresso()).getPrice());
        System.out.println("Espresso duplo com canela: " + new ComCanela(new Espresso(new Espresso())).getPrice());
    }
    
}

interface Drink {
    int getPrice();
}

class Espresso implements Drink {
    
    private Drink drink;
    
    public Espresso() {}
    
    public Espresso(Drink drink) {
        this.drink = drink;
    }
    
    @Override
    public int getPrice() {
        if (drink == null) {
            return 5;
        }
        return drink.getPrice() + 5;
    }
}

class Capuccino implements Drink {
    @Override
    public int getPrice() {
        return 10;
    }
}

class ComCanela implements Drink {
    
    private Drink drink;
    
    public ComCanela(Drink drink) {
        this.drink = drink;
    }
    
    @Override
    public int getPrice() {
        return drink.getPrice() + 3;
    }
}