import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // put your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        replaceAtoB(reader.readLine());
    }

    public static void replaceAtoB(String text){
        String output = "";
        for (int i = 0; i < text.length(); i++) {
                char outputSign = text.charAt(i);
                if(outputSign == 'a')
                    output += 'b';
                else
                    output += outputSign;
            }
        System.out.println(output);
        }
    }
