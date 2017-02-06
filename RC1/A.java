import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int numTestCases;
        String line;
        int score = 0;

        try {
            numTestCases = Integer.valueOf(br.readLine());
            line = br.readLine();
            while (line != null && (line.length() != 0)) {
                if (line.length() == 5) {
                    System.out.println("3");
                } else {
                    if (line.charAt(0) == 'o') {
                        score++;
                    }
                    if (line.charAt(1) == 'n') {
                        score++;
                    }
                    if (line.charAt(2) == 'e') {
                        score++;
                    }

                    if (line.charAt(0) == 't') {
                        score += 5;
                    }
                    if (line.charAt(1) == 'w') {
                        score += 5;
                    }
                    if (line.charAt(2) == 'o') {
                        score += 5;
                    }

                    if (score < 8) {
                        System.out.println("1");
                    } else {
                        System.out.println("2");
                    }
                    score = 0;
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}