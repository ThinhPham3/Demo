package com.mothaiba.mot.hai;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class hash {
    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<>();

        // Adding elements to the hashtable
        hashmap.put("A", 1);
        hashmap.put("B", 2);
        hashmap.put("C", 3);
        hashmap.put("C", null);

        // Getting values from the hashtable
        int valueA = hashmap.get("A");
        System.out.println("Value of A: " + valueA);

        hashmap.remove("B");

        for (String i : hashmap.keySet()) {
            System.out.println("Key: " + i + ", Value: " + hashmap.get(i));
        }
        System.out.println(hashmap);
    }
}
