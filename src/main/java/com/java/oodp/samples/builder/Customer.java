package com.java.oodp.samples.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Thiago A. de Souza Weber
 *
 */
public class Customer {

    private final int id;

    private final Name name;

    private final LocalDate birthday;

    private final LocalDateTime createAt;

    private final Address address;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = Objects.requireNonNull(builder.name);
        this.birthday = builder.birthday;
        this.createAt = builder.createAt;
        this.address = builder.address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", birthday=" + birthday + ", createAt="
                + createAt + ", address=" + address + "]";
    }

    static class Builder {

        private int id;

        private Name name;

        private LocalDate birthday;

        private LocalDateTime createAt;
        
        private Address address;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder fullname(String name, String surename) {
            this.name = Name.of(name, surename);
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder createAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder address(String street, int number) {
            this.address = Address.builder()
                .street(street)
                .number(number)
            .build();
            return this;
        }
        
        public Builder address(Address address) {
            this.address = address;
            return this;
        }
        
        public Customer build() {
            
            if (null == name) {
                name = Name.EMPTY;
            }
            
            return new Customer(this);
        }

        public Customer buildAsNew() {
            this.createAt = LocalDateTime.now();
            return this.build();
        }
    }

    public void printName() {
        System.out.println(name.getFirstName() + " - " + name.getFirstName().length());
//        if (name.getSurename() != null) {
//            System.out.println(name.getSurename() + " - " + name.getSurename().length());
//        } else {
//            System.out.println(name.getSurename() + " - " + 0);
//        }
        System.out.println(name.getSurename() + " - " + name.getSurename().length());
        System.out.println(name.getFullName() + " - " + name.getFullName().length());
    }

    public boolean hasTheSameName(Name name) {
        if (null == name) return false;
        return this.name.equals(name);
    }
}
