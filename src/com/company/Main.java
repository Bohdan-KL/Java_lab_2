package com.company;

//import java.util.ArrayList;
import java.util.Scanner;

class StringCalculator{
    public static int Add(String numbers){
        if (numbers.length()==0) {return 0;}
        else {
            if (numbers.indexOf(",")!=-1) {
                int ind = numbers.indexOf(",");
                String a = numbers.substring(0, ind);
                String b = numbers.substring(ind+1);
                return Integer.parseInt(a.trim())+Integer.parseInt(b.trim());
            }
            else return Integer.parseInt(numbers.trim());
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
