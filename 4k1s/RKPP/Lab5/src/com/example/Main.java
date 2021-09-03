package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Calculator");
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        String symbol = "Y";

        while(flag == true) {
            System.out.println("\n PLease enter two numbers");
            System.out.println("\n First number : ");
            Float firstNumber = scanner.nextFloat();
            System.out.println("\n Second number : ");
            Float secondNumber = scanner.nextFloat();
            System.out.println("\n Select between (*,/,+,-)\n Type out the character in a single letter: ");
            String operation = scanner.next();

            String eo = "You have selected ";

            switch (operation) {
                case "*":
                    System.out.println(eo + "* \n Your result:  " + (firstNumber * secondNumber));
                    break;
                case "/":
                    System.out.println(eo + "/ \n Your result:  " + (firstNumber / secondNumber));
                    break;
                case "+":
                    System.out.println(eo + "+ \n Your result:  " + (firstNumber + secondNumber));
                    break;
                case "-":
                    System.out.println(eo + "- \n Your result:  " + (firstNumber - secondNumber));
                    break;
                default:
                    System.out.println("\n Please select a valid character");
            }
            System.out.println("Enter Y if you want to continue");
            String chose = scanner.next();
            if(chose.equals(symbol))
                flag = true;
            else
                flag = false;
        }
    }
}
