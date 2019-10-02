package com.java.samples;

import com.java.samples.oop.Animal;
import com.java.samples.oop.Cat;
import com.java.samples.oop.Dog;
import com.java.samples.oop.Human;
import com.java.samples.oop.Pet;
import com.java.samples.oop.RubberDuck;

public class ExtendsTest {

    public static void main(String[] args) {

        System.out.println(new Animal() {

            @Override
            public int getLegs() {
                return 100;
            }
            
            @Override
            public String toString() {
                return "Crap!! It's working... [brain=" + hasBrain() + ", legs=" + getLegs() + "]";
            }
        });
        
        System.out.println(new Human());
        System.out.println(new Dog());
        System.out.println(new Dog(0));
        System.out.println(new Cat());

        Pet pet = new Pet() {

            @Override
            public int getFleas() {
                return 666;
            }

            @Override
            public String toString() {
                return "Unbelivable [fleas=" + getFleas() + "]";
            }
        };

        System.out.println(pet);
        System.out.println(new RubberDuck());
    }

}
