package com.java.samples.string;

public class Strings {

    public static void main(String[] args) {

        Person pessoa = new Person();
        pessoa.name = "José" + "Ola";
     
        System.out.println(pessoa.name.substring(4));
        System.out.println(pessoa.name.substring(4, 5));
        System.out.println(pessoa.name.substring(4, 4));
        
        System.out.println(pessoa.name.charAt(4));
        
        System.out.println(pessoa.name.indexOf("o"));
        System.out.println(pessoa.name.toLowerCase().lastIndexOf("o"));
        
        System.out.println("Ola Mundo !!"
                .replace("o", "a")
                .replace("O", "E")
                .replace("J", "G")
                .toUpperCase()
            );
        
        String a = null;
        
        if ("b".equalsIgnoreCase(a)) {
            System.out.println("Crap !! " + a);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) { 
                sb.append(i);
            } else {
                sb.append(" Crap ... ");
            }
        }
        
        System.out.println(sb);
    }

    static class Person {
        
        private String name;
        
    }
    
}
