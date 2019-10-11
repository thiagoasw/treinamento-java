package com.java.oodp.samples.adapter;

public class AdapterExample {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(new Caminhar());
        p1.andar();
        
        Carro carro = new Carro();
        PessoaCarroAdapter adapter = new PessoaCarroAdapter(carro);
        Pessoa p2 = new Pessoa(adapter);
        p2.andar();
    }

}

interface Locomover {
    void andar();
}

class Caminhar implements Locomover {
    @Override
    public void andar() {
        System.out.println("Caminhando...");
    }
}

class Pessoa implements Locomover {

    private final Locomover locomover;

    public Pessoa(Locomover locomover) {
        this.locomover = locomover;
    }

    @Override
    public void andar() {
        locomover.andar();
    }
}

class Carro {
    void dirigir() {
        System.out.println("Dirigindo o carro...");
    }
}

class PessoaCarroAdapter implements Locomover {

    private Carro carro;

    public PessoaCarroAdapter(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void andar() {
        carro.dirigir();
    }
}