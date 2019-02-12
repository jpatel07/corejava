package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Map<String, String> map = new HashMap<>();
        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        String s1 = map.get("3333");
        System.out.println(s1);

        String s2 = map.get("9999");//null
        String s3 = map.getOrDefault("9999", "xyz");

        System.out.println(s3);

        map.forEach((k, v) -> System.out.println(k + " | " + v));

        map.replaceAll((k,v) -> v.toUpperCase());

        map.forEach((k,v) -> System.out.println(k + " | " + v));

        System.out.println("--------------Sorted Map------------------");
        SortedMap<String, String> sortedMap = new TreeMap();
        sortedMap.put("2222", "ghi");
        sortedMap.put("3333", "abc");
        sortedMap.put("1111", "def");
      //  sortedMap.put("1111", "dezf");
        sortedMap.put("6666", "xyz");
        sortedMap.put("4444","mno");

        sortedMap.put("5555", "pqr");
        sortedMap.forEach((k,v) -> System.out.println(k + " | " + v));

        System.out.println("--------------Head Map------------------");

        SortedMap<String, String> hMap =  sortedMap.headMap("3333");
        hMap.forEach((k,v) -> System.out.println(k + " | " + v));

        System.out.println("--------------Tail Map------------------");
        SortedMap<String, String> tMap =  ((TreeMap<String, String>) sortedMap).tailMap("3333");
        tMap.forEach((k,v) -> System.out.println(k + " | " + v));





    }
}
