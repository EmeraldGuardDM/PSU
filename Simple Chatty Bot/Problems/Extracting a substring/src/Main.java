import jdk.dynalink.linker.ConversionComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // put your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String secondString = reader.readLine();
        int firstNumber = Integer.parseInt(String.valueOf(secondString.charAt(0)));
        int secondNumber = Integer.parseInt(String.valueOf(secondString.charAt(2))) + 1;
        System.out.println(text.substring(firstNumber, secondNumber));
    }
}