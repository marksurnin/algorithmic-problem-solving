import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // set up I/O
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        String output;
        char correctChar;
        String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        try {
            line = br.readLine();
            while (line != null && (line.length() != 0)) {
                output = "";
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        correctChar = ' ';
                    } else {
                        correctChar = keyboard.charAt(keyboard.indexOf(line.charAt(i)) - 1);
                    }
                    output = output.concat(Character.toString(correctChar));
                }
                System.out.println(output);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
