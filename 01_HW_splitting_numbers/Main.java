import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    // a(n) and b(n)
    int a = 0;
    int b = 0;
    // counter
    int c = 0;
    // the number given in decimal
    int token;

    try {
      String line = br.readLine();

      while (line != null && line.length() != 0) {
        token = Integer.parseInt(line.trim());
        if (token == 0) {
          break;
        }

        for (int i = 0; i < 31; i++) {
          // using a bitmask to check if the i-th bit is on
          if ((token & (1 << i)) != 0) {
            if (c % 2 == 0) {
              // set the i-th bit of a
              a |= 1 << i;
            } else {
              // set the i-th bit of b
              b |= 1 << i;
            }
            c++;
          }
        }
        System.out.println(a + " " + b);
        a = b = c = 0;
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}