import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // set up I/O
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        ArrayList<String> output = new ArrayList<String>();
        String line;

        try {
            line = br.readLine();
            int numTestCases = Integer.parseInt(line);
            int currentTestCase = 1;
            int currentLine = 0;
            int maxRank = 0;
            int rank;
            String url;
            // advance to the url data
            line = br.readLine();

            while (line != null && (line.length() != 0)) {
                String[] entry = line.split(" ");
                url = entry[0];
                rank = Integer.parseInt(entry[1]);

                // always put the first url into the `output` array
                // only replace it if the rank of the new url is higher
                if (currentLine == 0) {
                    maxRank = rank;
                    output.add(url);
                } else if (currentLine < 10) {
                    if (rank > maxRank) {
                        output.clear();
                        output.add(url);
                        maxRank = rank;
                    } else if (rank == maxRank) {
                        output.add(url);
                    }
                }

                // increment currentLine here as it could be reset in the following if statement
                currentLine ++;

                // we are done with this test case, output the results
                if (currentLine == 10) {
                    System.out.printf("Case #%d:\n", currentTestCase);

                    for (String result : output) {
                        System.out.println(result);
                    }

                    // reset variables before a new test case
                    maxRank = 0;
                    output.clear();
                    currentLine = 0;
                    if (currentTestCase == numTestCases) break;
                    currentTestCase ++;
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
