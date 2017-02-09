import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Main {

  // PQsort definition from http://www.programcreek.com/2009/02/using-the-priorityqueue-class-example/
  static class PQsort implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return two - one;
    }
  }

  public static void main(String[] args) {

    Boolean is_s, is_q, is_pq;
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {

      Stack<Integer> s = new Stack<Integer>();
      Queue<Integer> q = new LinkedList<Integer>();

      PQsort pqs = new PQsort();
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, pqs);
      is_s = is_q = is_pq = true;
      int numOperations = sc.nextInt();

      for (int i = 0; i < numOperations; i++) {
        int operation = sc.nextInt();
        int token = sc.nextInt();

        if (operation == 1) {
          if (is_s)
            s.push(token);
          if (is_q)
            q.add(token);
          if (is_pq)
            pq.add(token);
        } else {
          if (is_s) {
            if (s.empty()) is_s = false;
            else if (s.pop() != token) is_s = false;
          }
          if (is_q) {
            if (q.isEmpty()) is_q = false;
            else if (q.poll() != token) is_q = false;
          }
          if (is_pq) {
            if (pq.isEmpty()) is_pq = false;
            else if (pq.poll() != token) is_pq = false;
          }
        }
      }

      if (is_s && !is_q && !is_pq) {
        System.out.println("stack");
      } else if (is_s && !is_q && !is_pq) {
        System.out.println("stack");
      } else if (!is_s && is_q && !is_pq) {
        System.out.println("queue");
      } else if (!is_s && !is_q && is_pq) {
        System.out.println("priority queue");
      } else if (!is_s && !is_q && !is_pq) {
        System.out.println("impossible");
      } else {
        System.out.println("not sure");
      }
    }
  }

}