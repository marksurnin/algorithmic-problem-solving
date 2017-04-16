import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // set up I/O
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        BigInteger curInt = new BigInteger("1");
        BigInteger nxtInt;
        long i;

        try {
            // advance to the url data
            line = br.readLine();

            while (line != null && (line.length() != 0)) {
                if (Objects.equals(line, "END")) {
                    break;
                } else {
                    nxtInt = new BigInteger(line);
                    i = 0;
                    while ((Object.equals(curInt.toByteArray(), nxtInt.toByteArray())) || (i == 0)) {
                        curInt = new BigInteger(nxtInt.toByteArray());
                        nxtInt = BigInteger.valueOf(curInt.toByteArray().length); // 2
                        i++;
                    }
                    System.out.println(i);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}