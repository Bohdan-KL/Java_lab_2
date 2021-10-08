package com.company;

import java.util.Scanner;
import java.util.ArrayList;


class StringCalculator {

    static int delimiter_count(String numbers, String delimiter) {
        /*
         *   Function for getting count delimiter in numbers string
         *   input: numbers - numbers and delimiters string
         *   input: delimiter - delimiter that the function will count
         *   output: count - number of repetitions of the delimiter in numbers
         * */
        int count = 0;
        while (numbers.contains(delimiter)) {
            count++;
            numbers = numbers.substring(numbers.indexOf(delimiter) + delimiter.length());
        }
        return count;
    }


    static int get_min_index_or_delimiter_len(String numbers, ArrayList delimiters, String what_need) {
        /*
         *   Function for getting min index or delimiter length
         *   input: numbers - numbers and delimiters string
         *   input: delimiters - array of delimiter
         *   input: what_need - what need to get(min index or delimiter length)
         *   output: min index or delimiter length or -1
         * */
        int min_index = 1000000000, delimiter_len = 0;
        for (Object delimiter : delimiters) {
            if (min_index > numbers.indexOf((String) delimiter) && numbers.contains((String) delimiter)) {
                min_index = numbers.indexOf((String) delimiter);
                delimiter_len = ((String) delimiter).length();
            }
        }
        if (what_need.equals("min_index")) return min_index;
        if (what_need.equals("delimiter_len")) return delimiter_len;
        return -1;
    }


    public static int Add(String numbers) {
        /*
         *   Function for add numbers
         *   input: numbers - string what user write to console
         *   output: sum all numbers in input string
         * */

        //create delimiters list and string
        ArrayList<String> delimiters = new ArrayList<String>();
        String delimiters_all_in_one = null;


        //check the most simple situation
        if (numbers.length() == 0) {
            return 0;
        } else {


            //getting numbers string and delimiters string
            if (numbers.startsWith("//[")) {
                delimiters_all_in_one = numbers.substring(3, numbers.indexOf("\\n") - 1);
                numbers = numbers.substring(numbers.indexOf("\\n") + 2);
            } else {
                if (numbers.startsWith("//")) {
                    delimiters_all_in_one = numbers.substring(2, numbers.indexOf("\\n"));
                    numbers = numbers.substring(numbers.indexOf("\\n") + 2);
                } else delimiters.add(",");
            }


            //filling delimiters array
            while (delimiters_all_in_one != null) {
                if (!delimiters_all_in_one.contains("]")) break;
                String delimiter = delimiters_all_in_one.substring(0, delimiters_all_in_one.indexOf("]"));
                delimiters_all_in_one = delimiters_all_in_one.substring(delimiters_all_in_one.indexOf("]") + 2);
                delimiters.add(delimiter);
            }
            if (delimiters_all_in_one != null) delimiters.add(delimiters_all_in_one);


            //clearing and formatting numbers string
            numbers = numbers.replaceAll("\\\\n", delimiters.get(0));
            while (numbers.contains(delimiters.get(0) + delimiters.get(0)))
                numbers = numbers.replace(delimiters.get(0) + delimiters.get(0), delimiters.get(0));


            // initializing sum value, error value and getting delimiters count
            int s = 0, delimiter_count = 0;
            boolean error_negative_number = false;
            for (String delimiter : delimiters)
                delimiter_count += delimiter_count(numbers, delimiter);


            // main loop, where getting total sum
            while (delimiter_count != 0) {


                //getting min delimiter index and delimiter length
                int min_index = get_min_index_or_delimiter_len(numbers, delimiters, "min_index");
                int delimiter_len = get_min_index_or_delimiter_len(numbers, delimiters, "delimiter_len");


                //getting number and change numbers string
                String number = numbers.substring(0, min_index);
                numbers = numbers.substring(min_index + delimiter_len);


                //check is number negative and >1000
                if (number.startsWith("-") && !error_negative_number) {
                    System.out.println("Negatives not allowed!");
                    error_negative_number = true;
                }
                if (number.startsWith("-")) System.out.print("(" + number + " ");
                if (Integer.parseInt(number.trim()) >= 1000) continue;


                //sum numbers and change delimiter count
                s += Integer.parseInt(number.trim());
                delimiter_count -= 1;
            }

            // checking last number
            if (numbers.startsWith("-") && !error_negative_number) {
                System.out.println("Negatives not allowed!");
                System.out.println("(" + numbers + ")");
            }
            if (numbers.startsWith("-") && error_negative_number)
                System.out.println(numbers + ")");
            if (Integer.parseInt(numbers.trim()) < 1000)
                s += Integer.parseInt(numbers.trim());

            //checking what return
            if (error_negative_number) return -1;
            else return s;
        }
    }

}

public class Main {

    public static void main(String[] args) {

        //printing title
        System.out.print("\n\n\n                           >===============================<\n");
        System.out.print("                           |            Lab 2              |\n");
        System.out.print("                           |    Created by Bohdan Klots    |\n");
        System.out.print("                           |            KM-01              |\n");
        System.out.print("                           >===============================<\n\n\n");


        //read data from console
        Scanner in = new Scanner(System.in);
        System.out.print("Write your data: ");
        String data = in.nextLine();


        // checking and printing result
        int result = StringCalculator.Add(data);
        if (result >= 0) System.out.println("The sum: " + result);
    }
}
