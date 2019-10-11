package com.java.oodp.samples.factory;

import java.util.Random;

public class FacotryMethod {

    public static void main(String[] args) {
        
        RandomAnimalFactory factory = new RandomAnimalFactory();
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(factory.create().getType());
        }
    }
}

interface Animal {
    String getType();
}

class Dog implements Animal {
    @Override
    public String getType() {
        return getClass().getSimpleName();
    }
}

class Cat implements Animal {
    @Override
    public String getType() {
        return getClass().getSimpleName();
    }
}

class Duck implements Animal {
    @Override
    public String getType() {
        return getClass().getSimpleName();
    }
}

interface AnimalFactory {
    Animal create();

    Animal create(String type);
}

class RandomAnimalFactory implements AnimalFactory {

    private Random random = new Random();

    private String[] types = { "Dog", "Cat", "Duck" };

    @Override
    public Animal create() {
        int index = random.nextInt(types.length);
        return create(types[index]);
    }

    @Override
    public Animal create(String type) {
        switch (type) {
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            case "Duck":
                return new Duck();
            default:
                throw new IllegalArgumentException(
                        "Não existem nenhum animal disponivel para o tipo informado.");
        }
    }
}