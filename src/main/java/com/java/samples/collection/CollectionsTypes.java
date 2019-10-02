package com.java.samples.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CollectionsTypes {

    public static int hash = 0;
    
    public static void main(String[] args) {
//        arrayList();
        hashSet();
//        hashMap("k3");
    }
    
    static void arrayList() {

        List<Object> num = new ArrayList<>();
        num.add(9);
        num.add(12);
        num.add(10);
        num.add(16);
        num.add(6);
        num.add(8);
        num.add(56);
        num.add("ABRACADABRA");

        System.out.println("Elements : " + num);

        System.out.println("Size of array list is: " + num.size());

        int n = num.indexOf(10);
        System.out.println(num.get(n));

        num.remove(2);
        System.out.println("Elements : " + num);
    }

    static void hashSet() {

        Set<Object> hs = new HashSet<>();
        hs.add("D");
        hs.add("W");
        hs.add("G");
        hs.add("L");
        hs.add(3);
        hs.add("3");
        hs.add("Y");
        hs.add("4");
        hs.add("4");
        hs.add("4");
        hs.add(20);
        hs.add(new Name("Ana"));
        hs.add(new Name("Ana"));
        hs.add(new Name("Ana"));
        hs.add(new Name("Ana"));

        System.out.println("The elements are :" + hs);
        System.out.println(hash);
    }

    static void hashMap(String search) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("K1", new String("V1"));
        map.put("K2", new String("V2"));
        map.put("K3", new String("V3"));
        map.put("K4", new String("V4"));
        map.put("K5", new String("V5"));

        search = search.toUpperCase();
        
        if (map.containsKey(search)) {
            System.out.println("[Found] " + search + ": " + map.get(search));
        } else {
            System.err.println("[Key not found]");
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    static class Name {
        
        private int hashCode = 0;
        
        private final String name;

        public Name(String name) {
            this.name = name;
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
        
        @Override
        public String toString() {
            return "Name [" + name + "]";
        }
    }
}
