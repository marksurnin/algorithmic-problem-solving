import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // set up I/O
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        long numSnowflakes;
        long snowflake;

        try {
            line = br.readLine();
            long numTestCases = Integer.parseInt(line);

            for (long i = 0; i < numTestCases; i++) {
                HashSet<Long> hm = new HashSet<Long>();
                numSnowflakes = Integer.parseInt(br.readLine());

                for (long j = 0; j < numSnowflakes; j++) {
                    snowflake = Integer.parseInt(br.readLine());
                    hm.add(snowflake);
                }

                System.out.println(hm.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}