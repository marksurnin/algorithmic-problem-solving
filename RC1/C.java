import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int numTestCases;
        int numOfElementsToRemove = 0;
        String[] line;
        Map<String, Integer> hm = new HashMap();

        try {
            numTestCases = Integer.valueOf(br.readLine());
            for (int i = 0; i < numTestCases; i++) {
                // skip list length information
                br.readLine();
                // first list
                line = br.readLine().split(" ");
                for (String s : line) {
                    if (hm.containsKey(s)) {
                        hm.put(s, hm.get(s) + 1);
                    } else {
                        hm.put(s, 1);
                    }
                }
                // second list
                line = br.readLine().split(" ");
                for (String s : line) {
                    if (hm.containsKey(s)) {
                        hm.put(s, hm.get(s) - 1);
                    } else {
                        hm.put(s, -1);
                    }
                }

                for (String key : hm.keySet()) {
                    if (hm.get(key) != 0) {
                        numOfElementsToRemove += Math.abs(hm.get(key));
                    }
                    //System.out.println("Key = " + key + " - " + hm.get(key));
                }
                System.out.println(numOfElementsToRemove);
                hm.clear();
                numOfElementsToRemove = 0;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}