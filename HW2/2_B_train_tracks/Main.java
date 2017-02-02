import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // set up I/O
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        int m = 0;
        int f = 0;

        try {
            line = br.readLine();
            int numTestCases = Integer.parseInt(line);

            for (int i = 1; i <= numTestCases; i++) {
                line = br.readLine();

                for (char ch : line.toCharArray()) {
                    if (ch == 'M') m++;
                    if (ch == 'F') f++;
                }

                if (m == f && m > 1) {
                    System.out.println("LOOP");
                } else {
                    System.out.println("NO LOOP");
                }

                // reset m & f counters
                m = 0;
                f = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
