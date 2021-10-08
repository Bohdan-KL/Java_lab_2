package com.company;

//import java.util.ArrayList;

import java.util.Scanner;

class StringCalculator {
    public static int Add(String numbers) {

        String delimiter;

        if (numbers.startsWith("//")){
            delimiter = numbers.substring(2, numbers.indexOf("\\n"));
            numbers = numbers.substring(numbers.indexOf("\\n")+2);}
        else  delimiter = ",";


        numbers = numbers.replaceAll("\\\\n", delimiter);
        while (numbers.contains(delimiter+delimiter))
            numbers = numbers.replace(delimiter+delimiter,delimiter);


        if (numbers.length() == 0) {
            return 0;
        } else {
            int s = 0;
            while (numbers.contains(delimiter)) {
                String number = numbers.substring(0, numbers.indexOf(delimiter));
                numbers = numbers.substring(numbers.indexOf(delimiter) + delimiter.length());
                s += Integer.parseInt(number.trim());
            }
            if (numbers.length()>0) s+=Integer.parseInt(numbers.trim());
             return s;
        }
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.print("\n\n\n                           >===============================<\n");
        System.out.print("                           |            Lab 2              |\n");
        System.out.print("                           |    Created by Bohdan Klots    |\n");
        System.out.print("                           |            KM-01              |\n");
        System.out.print("                           >===============================<\n\n\n");

        Scanner in = new Scanner(System.in);


        System.out.print("Write your data: ");
        String data = in.nextLine();
        int result = StringCalculator.Add(data);
        System.out.println(result);
    }
}
