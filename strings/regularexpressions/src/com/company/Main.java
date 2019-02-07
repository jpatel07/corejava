package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s1 = "apple, apple and oragnge please";
        String[] s2 = s1.split("\\b");

       // for (String thePart : s2) {
         //   System.out.println(thePart);
        //}

        for (String thePart : s2) {
            if (thePart.matches("\\w+")) {
                System.out.println(thePart);
            }
        }

        System.out.println("Using Compile Pattern");
        //more efficient way
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s1);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
