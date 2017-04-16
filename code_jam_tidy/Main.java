import java.io.*;
import java.util.*;

public class Main {

  public static String getTidy(StringBuilder s) {
    boolean isTidy = true;
    int temp = 0;
    int i;
    for (i = 0; i < s.length(); i++) {
      if (Character.getNumericValue(s.charAt(i)) < temp) {
        isTidy = false;
        break;
      }
      temp = Character.getNumericValue(s.charAt(i));
    }

    if (!isTidy) {
      int new_value = Character.getNumericValue(s.charAt(i-1)) - 1;

      if (i > 1) {
        if (Character.getNumericValue(s.charAt(i-1)) - Character.getNumericValue(s.charAt(i-2)) != 1) {
          boolean ready = false;
          while (i > 1) {
            int prev = Character.getNumericValue(s.charAt(i-2));
            if (prev >= new_value) i--;
            else break;
          }
        }
      }

      char c = (char) new_value;
      // System.out.println(new_value + " " + Character.forDigit(c, 10));
      // System.out.println(s);
      s.setCharAt(i - 1, Character.forDigit(c, 10));
      // System.out.println(s);
      for (int j = i; j < s.length(); j++) {
        s.setCharAt(j, '9');
      }
    }

    int consec_zeroes = 0;
    for (int k = 0; k < s.length(); k++) {
      if (s.charAt(k) == '0') {
        consec_zeroes++;
      } else {
        break;
      }
    }

    if (consec_zeroes != 0) {
      s.delete(0, consec_zeroes);
    }

    return s.toString();
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        StringBuilder number = new StringBuilder(br.readLine());
        String answer = getTidy(number);
        
        System.out.printf("Case #%d: %s\n", i+1, answer);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}