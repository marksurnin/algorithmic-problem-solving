import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public class Node {
    private int data;
    private Node c1;
    private Node c2;
    private Node c3;
    private Node c4;

    Node(int data, Node c1, Node c2, Node c3, Node c4) {
      this.data = data;
      this.c1 = c1;
      this.c2 = c2;
      this.c3 = c3;
      this.c4 = c4;
    }
  }

  public static void build(Node root, String[] tokens) {
    if 
  }

  public static void main(String[] args) {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    String line;
    String[] tokens;
    int numTestCases;

    // represent 1024 pixels as a nested array
    // int[][] image = new int[32][32];

    try {
      numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine();
        tokens = line.split("\\s+");

        Node root1;
        build(root1, tokens);

        line = br.readLine();
        tokens = line.split("\\s+");
        for (String s : tokens1) {
          System.out.print(s + " ");
        }
        System.out.print("\n");

        for (String s : tokens2) {
          System.out.print(s + " ");
        }
        System.out.print("\n\n");
      }
    } catch(IOException e) {
      e.printStackTrace();
    }

  }

}