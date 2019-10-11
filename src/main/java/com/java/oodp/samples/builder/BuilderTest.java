package com.java.oodp.samples.builder;

import java.time.LocalDate;

public class BuilderTest {

    public static void main(String[] args) {
//        Customer c1 = new Customer(1, "John", "Doe", LocalDate.now());

        Customer customer = Customer.builder()
            .id(10)
            .fullname("John", "Doe")
            .birthday(LocalDate.now())
            .address(Address.builder()
                .street("Av. J.K.")
                .number(550)
            .build())
        .buildAsNew();
        
        System.out.println(customer);
        
        customer.printName();
        
        System.out.println(customer.hasTheSameName(Name.of("John", "Doe")));
    }
    
}
