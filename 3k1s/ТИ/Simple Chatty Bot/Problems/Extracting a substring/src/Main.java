import jdk.dynalink.linker.ConversionComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        System.out.print(word.substring(num1, num2 + 1));
    }
}
