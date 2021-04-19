package com.company;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	// write your code here
        String text = "Hello World";
        System.out.println("Исходный текст : " +  text);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(text.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes){
            stringBuilder.append(String.format("%02X ", b));   //конверитрую в 16-ричку
        }
        System.out.println("Хеш-код : " + stringBuilder.toString());

        File file = new File("input.txt");
        byte[] bytesF = new byte[(int) file.length()];

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesF);
            System.out.println("Данные из файла : ");
            for (int i = 0; i < bytesF.length; i++) {
                System.out.print((char)bytesF[i]);
            }
            for (byte b : bytes){
                stringBuilder.append(String.format("%02X ", b));   //конверитрую в 16-ричку
            }
            System.out.println("Хеш-код : " + stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

