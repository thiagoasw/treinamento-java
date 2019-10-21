package com.java.oodp.samples.builder;

import java.util.Objects;

public class Name {

    public static final Name EMPTY = Name.of("Não informado.", "");
    
    private final String firstname;

    private final String surename;

    private Name(String firstname, String surename) {
        this.firstname = firstname;
        this.surename = surename;
    }

    public static Name empty() {
        System.out.println("Devolvendo uma nova referencia de Name");
        return Name.of("Não informado.", "");
    }
    
    public static Name of(String firstname, String surename) {

        if (null == firstname || firstname.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (null == surename) {
            surename = "";
        }

        return new Name(firstname, surename);
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSurename() {
        return surename;
    }

    public String getFullName() {
        return firstname + " " + surename;
    }

    @Override
    public String toString() {
        return "Name [" + getFullName() + "]";
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hash(firstname, surename);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (getClass().equals(obj.getClass()) == false) {
            return false;
        }

        Name other = (Name) obj;

        return Objects.equals(firstname, other.firstname)
                && Objects.equals(surename, other.surename);
    }

}
