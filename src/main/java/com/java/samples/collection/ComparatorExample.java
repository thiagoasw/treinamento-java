package com.java.samples.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ComparatorExample {

    public static void main(String[] args) {

        Set<Cliente> clientes = new HashSet<>();
        clientes.add(new Cliente("José", 23));
        clientes.add(new Cliente("Ana", 26));
        clientes.add(new Cliente("Ana", 26));
        clientes.add(new Cliente("Jose", 13));
        clientes.add(new Cliente("Claudia", 32));
        clientes.add(new Cliente("Danilo", 27));
        clientes.add(new Cliente("Bruno", 2));
        clientes.add(new Cliente("Bruno", 24));
        clientes.add(new Cliente("Aluisio", 36));

        clientes.stream()
                .sorted(new IdadeClienteComparator(false))
                .forEach(System.out::println);
    }

    static class Cliente implements Comparable<Cliente> {

        private int hashCode = 0;

        private final String nome;

        private final int idade;

        public Cliente(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        @Override
        public int hashCode() {
            if (hashCode == 0) {
                hashCode = 31 * Objects.hashCode(nome) + Objects.hashCode(idade);
            }
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            Cliente other = (Cliente) obj;

            return nome.equalsIgnoreCase(other.nome) && idade == other.idade;
        }

        @Override
        public String toString() {
            return "Cliente [nome=" + nome + ", idade=" + idade + "]";
        }

        @Override
        public int compareTo(Cliente other) {

            int result = nome.compareToIgnoreCase(other.nome);

            if (result == 0) {
                return Integer.compareUnsigned(idade, other.idade);
            }

            return result;
        }

    }

    static class IdadeClienteComparator implements Comparator<Cliente> {

        private final boolean asc;

        public IdadeClienteComparator(boolean asc) {
            this.asc = asc;
        }

        @Override
        public int compare(Cliente o1, Cliente o2) {
            if (asc) {
                return Integer.compareUnsigned(o1.getIdade(), o2.getIdade());
            } else {
                return Integer.compareUnsigned(o2.getIdade(), o1.getIdade());
            }
        }
    }

}
