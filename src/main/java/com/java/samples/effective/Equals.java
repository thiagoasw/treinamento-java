package com.java.samples.effective;

import java.util.Objects;

public class Equals {

    public static void main(String[] args) {

        Name n1 = new Name("claudio");
        Name n2 = new Name("Claudio");
        Name n3 = new Name("ClauDio");

        System.out.println("Reflexivo");
        System.out.println("n1.equals(n1): " + n1.equals(n1));

        System.out.println("Simetrico: 'true'");
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println("n2.equals(n1): " + n2.equals(n1));

        System.out.println("Transitivo: 'true'");
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println("n2.equals(n3): " + n2.equals(n3));
        System.out.println("n3.equals(n1): " + n3.equals(n1));

        System.out.println("Consistente: 'true'");
        System.out.println("n1.equals(n1): " + n1.equals(n1));
        System.out.println("n1.equals(n1): " + n1.equals(n1));
        System.out.println("n1.equals(n1): " + n1.equals(n1));
        System.out.println("n1.equals(n1): " + n1.equals(n1));

        System.out.println("Null safe: 'false'");
        System.out.println("n1.equals(null): " + n1.equals(null));
        
        
    }

    static class Name implements Cloneable {

        private int hashCode = 0;
        
        private final String name;

        public Name(String name) {
            this.name = name;
        }
        
        public Name(Name name) {
            this.name = name.getName();
        }
        
        @Override
        public int hashCode() {
            if (hashCode == 0) {
                this.hashCode = Objects.hashCode(this.name);
            }
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            
            Name other = (Name) obj;
            
            return this.name.equalsIgnoreCase(other.name);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Name [" + name + "]";
        }
    }
}
