import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String city = scan.nextLine();
        System.out.println(city.endsWith("burg"));      
    }
}
