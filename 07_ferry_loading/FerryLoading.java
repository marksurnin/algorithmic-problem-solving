//https://github.com/kp1381/Various-ACM-Problems/blob/b1378af69ed0ea0323794c5780437d53baf34786/FerryLoading.java
import java.io.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/102/10261.pdf
 * Author: Konstantin Petrov
 */
public class FerryLoading {
    public static boolean[][] lookup;
    public static Integer[] result=new Integer[2001];
    public static Integer[][] array=new Integer[2001][10001];;
    public static StringBuilder sb;
    
    public static void rec(int current, int length) {
          if(current == 0) {
            return;
          }
          rec(current - 1, array[current][length]);
          if(array[current][length] == length)
              sb.append("port\n");
          else
              sb.append("starboard\n");
        }
    
    public static void main(String args[]) throws Exception {
      sb = new StringBuilder();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int cases = Integer.parseInt(buf.readLine());  
        for(int k=0; k<cases; k++){
            buf.readLine();  
            
            int L = Integer.parseInt(buf.readLine()) * 100;    
            
            lookup = new boolean[2001][10001];
            lookup[0][0] = true;
           
            int current = 1, sum = 0, res = 0, length = 0;
            
            while (true) {
                result[current] = Integer.parseInt(buf.readLine());
                if(result[current] == 0) break;
                
                sum += result[current];
                for (int i = 0; i <= L; i++) {
                  if (sum - i <= L && lookup[current - 1][i]) {
                    lookup[current][i] = true;
                    array[current][i] = i;
                    res = current;
                    length = i;
                  } else if (i >= result[current] && lookup[current - 1][i - result[current]]) {
                    lookup[current][i] = true;
                    array[current][i] = i - result[current];
                    res = current;
                    length = i;
                  }
                  System.out.printf("%d %d\n", res, length);
                }
                current++;
            }
            
            sb.append(res+"\n");  
            System.out.printf("%d %d\n", res, length);  
            rec(res, length);
            
            if(k < cases-1)
                sb.append("\n");
        }    
        System.out.print(sb);
    }
}