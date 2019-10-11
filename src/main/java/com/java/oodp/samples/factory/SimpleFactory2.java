package com.java.oodp.samples.factory;

public class SimpleFactory2 {

    public static void main(String[] args) {

        ShortDescription.from("3432432434");
        ShortDescription.from("");

    }
}

class ShortDescription {

    private String value;

    @SuppressWarnings("unused")
    private ShortDescription() {}

    protected ShortDescription(String valor) {
        this.value = valor;
    }

    public String getValue() {
        return value;
    }

    public static ShortDescription from(String description) {

        if (null == description)
            throw new NullPointerException("A descricao informada é nulla.");

        if (description.isBlank()) {
            throw new IllegalArgumentException("A descricao informado está em branco.");
        }

        return new ShortDescription(description);
    }
}
