package com.company;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();
        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "xvy");
        MyClass v3 = new MyClass("v3", "abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);

      //  list.forEach(m -> System.out.println(m.getLabel()));
        //list.removeIf(m -> m.getValue().equals("abc"));
        //list.forEach(m -> System.out.println(m.getLabel()));
        System.out.println("---------------------");
        Object[] objArray = list.toArray();
        MyClass[] a1 = list.toArray(new MyClass[0]);

        for(MyClass m:a1){
            System.out.println(m.getLabel());
        }
        System.out.println("---------------------");
        MyClass[] a2 = new MyClass[3];//creat new array
        MyClass[] a3 = list.toArray(a2);

         for(MyClass m:a3) {
             System.out.println(m.getLabel());
        }

        if(a2 == a3)
            System.out.println("a2 & a3 reference the same array");

        System.out.println("--------  TREE SET  -------------");

        TreeSet<MyClass> tree = new TreeSet<>();
        tree.add(new MyClass("2222", "ghi"));
        tree.add(new MyClass("3333","abc"));
        tree.add(new MyClass("1111", "def"));

        tree.forEach(m -> System.out.println(m));

        System.out.println("--------  TREE SET using Comparator -------------");

        TreeSet<MyClass> tree2 = new TreeSet<>(new MyComparator());
        tree2.add(new MyClass("2222", "ghi"));
        tree2.add(new MyClass("3333","abc"));
        tree2.add(new MyClass("1111", "def"));
        tree2.forEach(m -> System.out.println(m));






    }
}
