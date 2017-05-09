import java.util.*;

public class ctci_8_1_staircase {
  public static int _waysToTheTop(int nSteps, int[] steps) {
    if (nSteps < 0) {
      return 0;
    } else if (nSteps == 0) {
      return 1;
    } else if (steps[nSteps] > -1) {
      return steps[nSteps];
    } else {
      steps[nSteps] = _waysToTheTop(nSteps-1, steps) + _waysToTheTop(nSteps-2, steps) + _waysToTheTop(nSteps-3, steps);
      return steps[nSteps];
    }
  }

  public static int waysToTheTop(int nSteps) {    
    int[] steps = new int[nSteps+1];
    Arrays.fill(steps, -1);
    return _waysToTheTop(nSteps, steps);
  }

  public static void main(String[] args) {
    int nSteps = 36;
    System.out.println(waysToTheTop(nSteps));
  }
}