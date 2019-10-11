package com.java.oodp.samples.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Address {

    private final String street;

    private final int number;

    static class AddressBuilder {
        
        public Address buildAsEmpty() {
            this.street = "Empty";
            this.number = 0;
            return this.build();
        }
        
    }
    
}
