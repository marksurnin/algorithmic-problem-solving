import java.io.*;
import java.util.*;

public class Main {

  public static int pre;

  public static class Node {
    char val;
    Node left, right;
  }

  public static Node constructTree(String preorder, String inorder, int l, int r) {
    if (l > r) {
      return null;
    }
    Node temp = new Node();
    temp.val = preorder.charAt(pre++);
    int inIndex = 0;
    for (int i = l; i <=r; i++) {
      if (inorder.charAt(i) == temp.val) {
        inIndex = i;
      }
    }
    temp.left = constructTree(preorder, inorder, l, inIndex - 1);
    temp.right = constructTree(preorder, inorder, inIndex + 1, r);
    return temp;
  }

  public static void printPostorder(Node root) {
    if (root == null) {
      return;
    }
    printPostorder(root.left);
    printPostorder(root.right);
    System.out.print(root.val);
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    line = br.readLine();
    while (line != null && !line.equals("")) {
      String[] tokens = line.trim().split("\\s+");
      String preorder = tokens[0];
      String inorder = tokens[1];
      pre = 0;
      Node root = constructTree(preorder, inorder, 0, preorder.length() - 1);
      printPostorder(root);
      System.out.println();
      line = br.readLine();
    }
  }
}