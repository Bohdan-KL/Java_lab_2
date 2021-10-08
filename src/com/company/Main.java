package com.company;

//import java.util.ArrayList;

import java.util.Scanner;

class StringCalculator {
    public static int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        } else {
            int s = 0;
            while (numbers.contains(",")) {
                String number = numbers.substring(0, numbers.indexOf(","));
                numbers = numbers.substring(numbers.indexOf(",") + 1);
                s += Integer.parseInt(number.trim());
            }
             return s+Integer.parseInt(numbers.trim());
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
