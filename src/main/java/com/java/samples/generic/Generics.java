package com.java.samples.generic;

import java.io.Serializable;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        var clienteRepository = new ClienteRepository();
        var notaFiscalRepository = new NotaFiscalRepository();

        String name = clienteRepository.get(1L).name;
        System.out.println(name);

        for (var item : notaFiscalRepository.get("XPTO").items) {
            System.out.println(item);
        }
    }

}

class NotaFiscal implements ModeloDeDados<String> {
    String numero;
    List<Long> items;
    @Override
    public String getId() {
        return numero;
    }
}

class NotaFiscalRepository extends BancosDados<String, NotaFiscal> {
}

class Cliente implements ModeloDeDados<Long> {
    long id;
    String name;
    @Override
    public Long getId() {
        return id;
    }
}

class ClienteRepository extends BancosDados<Long, Cliente> {}

interface ModeloDeDados<ID extends Serializable> {
    ID getId();
}

abstract class BancosDados<ID extends Serializable, T> {

    @SuppressWarnings("unchecked")
    public T get(ID id) {

        T result = null;

        if (id.getClass().equals(String.class)) {
            NotaFiscal nf = new NotaFiscal();
            nf.numero = "XPTO";
            nf.items = List.of(3l, 55l, 938l);
            result = (T) nf;
        } else {
            Cliente cliente = new Cliente();
            cliente.name = "Ana";
            result = (T) cliente;
        }

        return result;
    }
}