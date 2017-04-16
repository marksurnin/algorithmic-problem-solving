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
        ArrayList<Integer> al = new ArrayList<Integer>();

        try {
            line = br.readLine();
            int i = 0;

            while (line != null && line.length() != 0) {
                String[] tokens = line.trim().split("\\s+");
                if (i == 1) {
                    for (String s : tokens) {
                        al.add(Integer.parseInt(s));
                    }
                } else if (i > 2) {
                    int c = 0;
                    for (int j = 1; j < al.size(); j++) {
                        if (al.get(j) == Integer.parseInt(tokens[1])) {
                            c++;
                            if (c == Integer.parseInt(tokens[0])) {
                                System.out.println(j);
                            }
                        }
                    }
                }
                System.out.println(i);
                i++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}