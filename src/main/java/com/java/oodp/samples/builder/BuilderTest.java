package com.java.oodp.samples.builder;

import java.time.LocalDate;

public class BuilderTest {

    public static void main(String[] args) {
        //        Customer c1 = new Customer(1, "John", "Doe", LocalDate.now());

        Customer customer = Customer.builder()
                .id(10)
                .fullname("John", null)
                .birthday(LocalDate.now())
                .address(Address.builder()
                        .street("Av. J.K.")
                        .number(550)
                        .build())
                .buildAsNew();

        System.out.println(customer);

        customer.printName();

        System.out.println(customer.hasTheSameName(Name.of("John", "Doe")));

        System.out.println(customer.getName().getSurename().length());
//        if (customer.getName().getSurename() != null) {
//            System.out.println(customer.getName().getSurename().length());
//        } else {
//            System.out.println(0);
//        }
        
        Customer inconsistente = Customer.builder()
                .id(12)
                .name(Name.empty())
            .buildAsNew();
        
        System.out.println(inconsistente);
        inconsistente.printName();
        System.out.println(inconsistente.getName().getSurename().length());
        
        Customer inconsistente2 = Customer.builder()
                .id(12)
//                .name(Name.EMPTY)
            .buildAsNew();
        
        System.out.println(inconsistente2);
        inconsistente2.printName();
        System.out.println(inconsistente2.getName().getSurename().length());
    }

}
