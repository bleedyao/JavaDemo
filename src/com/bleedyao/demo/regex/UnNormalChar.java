package com.bleedyao.demo.regex;

public class UnNormalChar {
    public static void main(String[] args) {
        String str = "sgsg*Albs*[-";
//        String str = "";
        String reg = "[*]";

        System.out.println(str.matches(reg));
    }
}
