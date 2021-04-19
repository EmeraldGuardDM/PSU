package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	// write your code here
        String text = "Hello World";
        System.out.println("Исходный текст : " +  text);
        MessageDigest sha1 = MessageDigest.getInstance("MD5");
        byte[] bytes = sha1.digest(text.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes){
            stringBuilder.append(String.format("%02X ", b));   //конверитрую в 16-ричку
        }
        System.out.print("Хеш-код : " + stringBuilder.toString());
    }
}

