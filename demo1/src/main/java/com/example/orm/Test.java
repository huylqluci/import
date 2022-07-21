package com.example.orm;

public class Test {
    public static void main(String[] args) {
        KeySite k1 = new KeySite("Khu A", -1);
        KeySite k2 = new KeySite("Khu A", -1);
        System.out.println(k1.equals(k2));
    }
}
