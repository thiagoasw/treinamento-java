package com.java.oodp.samples.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Thiago A. de Souza Weber
 *
 */
public class Customer {

    private final int id;

    private final String name;

    private final String surename;

    private final LocalDate birthday;

    private final LocalDateTime createAt;

    private final Address address;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surename = builder.surename;
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

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
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
        return "Customer [id=" + id + ", name=" + name + ", surename=" + surename + ", birthday=" + birthday + ", createAt="
                + createAt + ", address=" + address + "]";
    }

    static class Builder {

        private int id;

        private String name;

        private String surename;

        private LocalDate birthday;

        private LocalDateTime createAt;
        
        private Address address;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surename(String surename) {
            this.surename = surename;
            return this;
        }

        public Builder fullname(String name, String surename) {
            this.name = name;
            this.surename = surename;
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
            return new Customer(this);
        }

        public Customer buildAsNew() {
            this.createAt = LocalDateTime.now();
            return new Customer(this);
        }
    }
}
