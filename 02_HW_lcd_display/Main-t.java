import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int s;
        int digit;
        String line;
        String digitStr;
        String digitBitmap;
        boolean on = false;

        try {
            line = br.readLine();
            while (line != null && (line.length() != 0)) {
                s = Integer.parseInt(line.split(" ")[0]);
                digitStr = line.split(" ")[1];

                String[] digits = new String[10];
                /* LC-display digits are encoded as bitmaps in the order of   //   -
                 * three horizontal bars from top to bottom, then vertical:   //  |
                 * top left, bottom left, top right, bottom right.            //   -
                 * for example, 5 is "111" for the horizontal bars and "1001" //    |
                 * for vertical bars. Actual bitmasks could be used here.     //   -
                 */
                digits[0] = "1110111";
                digits[1] = "0010010";
                digits[2] = "1011101";
                digits[3] = "1011011";
                digits[4] = "0111010";
                digits[5] = "1101011";
                digits[6] = "1101111";
                digits[7] = "1010010";
                digits[8] = "1111111";
                digits[9] = "1111011";

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < digitStr.length(); j++) {
                        digit = Character.getNumericValue(digitStr.charAt(j));
                        digitBitmap = digits[digit];

                        if (i == 0 || i == 2 || i == 4) {
                            // whether the current 'bit' is on
                            on = digitBitmap.charAt(3 * i / 2) == '1';

                            if (on) {
                                System.out.print(" - ");
                            } else {
                                System.out.print("   ");
                            }

                            // take care of end of digit or line
                            if (j == digitStr.length() - 1) {
                                System.out.print("\n");
                            } else {
                                System.out.print(" ");
                            }
                        } else {
                            if (i == 1) {
                                on = digitBitmap.charAt(1) == '1';
                            } else if (i == 3) {
                                on = digitBitmap.charAt(4) == '1';
                            }

                            if (on) {
                                System.out.print("| ");
                            } else {
                                System.out.print("  ");
                            }

                            if (i == 1) {
                                on = digitBitmap.charAt(2) == '1';
                            } else if (i == 3) {
                                on = digitBitmap.charAt(5) == '1';
                            }

                            if (on) {
                                System.out.print("|");
                            } else {
                                System.out.print(" ");
                            }

                            // take care of end of digit or line
                            if (j == digitStr.length() - 1) {
                                System.out.print("\n");
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}