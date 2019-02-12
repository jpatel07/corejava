package com.company;

public class MyClass implements  Comparable<MyClass>{
    String label, value;

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  label + " | " + value;
    }
    @Override
    public boolean equals(Object o) {
        MyClass other = (MyClass) o;
        return value.equalsIgnoreCase(other.value);
    }

    @Override
    public int compareTo(MyClass o) {
        return  value.compareToIgnoreCase(o.value);
    }
}
