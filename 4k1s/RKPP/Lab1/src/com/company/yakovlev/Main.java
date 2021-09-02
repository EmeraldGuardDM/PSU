package com.company.yakovlev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("FIRST TASK");
        firstTask();
        System.out.println("SECOND TASK :");
        secondTask();
    }

    public static void firstTask(){
        Scanner in =  new Scanner(System.in);
        System.out.println("Input x (real number) ");
        int x = in.nextInt();
        System.out.println("Input n (array size) ");
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
            System.out.print(array[i] + " ");
        }

        float midValue;
        float closesValue = array.length > 1 ? (array[0] + array[1]) / 2 : 0;
        float closesValues[] = new float[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i == j)
                    continue;
                midValue = (array[i] + array[j]) / 2;
                if(Math.abs(midValue - x) < closesValue){
                    closesValue = Math.abs(midValue - x);
                    closesValues[0] = array[i];
                    closesValues[1] = array[j];
                }
            }
        }
        System.out.println("\nClosest values to " + x + " -> " + closesValues[0] + " + " + closesValues[1] + " = " + (closesValues[0] + closesValues[1]) / 2);
    }

    public static void secondTask(){
        Scanner in = new Scanner(System.in);
        int rows = 0, columns = 0;
        System.out.println("Enter rows : ");
        rows = in.nextInt();
        System.out.println("Enter columns : ");
        columns = in.nextInt();
        int[][] array = new int[rows][columns];

        System.out.println("\nOriginal array :");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) Math.round((Math.random() * 100) - 50);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int minI = 0, minJ = 0, maxI = 0, maxJ = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[minI][minJ] > array[i][j]){
                    minI = i;
                    minJ = j;
                }
                else if(array[maxI][maxJ] < array[i][j]){
                    maxI = i;
                    maxJ = j;
                }

            }
        }
        System.out.println("\nMax : " + array[maxI][maxJ] +"\nMin : " + array[minI][minJ]);

        var tmp = array[maxI][maxJ];
        array[maxI][maxJ] = array[minI][minJ];
        array[minI][minJ] = tmp;

        System.out.println("\nMixed array :");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
