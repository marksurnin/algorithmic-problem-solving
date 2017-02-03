import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static boolean isStringAPalindrome(String test) {
        for (int i = 0; i < test.length() / 2; i++) {
            if (test.charAt(i) != test.charAt(test.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;

        try {
            line = br.readLine();
            while (line != null && (line.length() != 0)) {
                ArrayList<String> palindromes = new ArrayList<String>();
                for (int i = 0; i < line.length(); i++) {
                    for (int j = i + 1; j <= line.length(); j++) {
                        String combination = line.substring(i, j);
                        if (isStringAPalindrome(combination) && !palindromes.contains(combination)) {
                            palindromes.add(combination);
                        }
                    }
                }

                System.out.printf("The string '%s' contains %d palindromes.\n", line, palindromes.size());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}