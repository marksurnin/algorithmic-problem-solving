import java.io.*;
import java.util.*;

public class Main
{
  static final double EPS = 1e-9;
  static class Point
  {
    public double x, y;
    public int id;
    public Point(double x, double y, int id) { this.x = x; this.y = y; this.id = id;}
    public String toString() { return String.format("(%.03f,%.03f)", x,y); }
  } 
  /** Computes the unsigned angle abc */
  static double angle(Point a, Point b, Point c)
  {
    double d1 = dist(a,b), d2 = dist(b,c);
    if (d1 < EPS || d2 < EPS) return 0;
    return Math.acos( ((a.x-b.x)*(c.x-b.x)+(a.y-b.y)*(c.y-b.y))/(d1*d2) );
  }
  /** Uses winding numbers to test for inside */
  static boolean inside(ArrayList<Point> al, Point p)
  {
    int n = al.size();
    if (n == 0) return false;
    double ret = 0;
    for (int i = 0; i < n; ++i)
    {
      int ii = (i+1)%n; 
      if (isCollin(al.get(i), p, al.get(ii))) return true;
      ret += (isLeft(al.get(i),p,al.get(ii))?-1:1) * angle(al.get(i),p,al.get(ii));
    }
    return Math.abs(ret)>EPS;
  }
  /** Cross product (b-a) x (c-b) */
  static double cross(Point a, Point b, Point c)
  {
    double y1 = b.y-a.y, y2 = c.y-b.y;
    double x1 = b.x-a.x, x2 = c.x-b.x;
    return x1*y2-x2*y1;
  }
  /** Distance from c to the line through a,b */
  static double height(Point a, Point b, Point c) { return Math.abs(cross(a,b,c))/dist(a,b); }
  /** Distance from a to b */
  static double dist(Point a, Point b) { return Math.hypot(a.x-b.x,a.y-b.y); }
  /** Area of the polygon given in al */
  static double area(ArrayList<Point> al)
  {
    int N = al.size();
    if (N <= 2) return 0;
    double ret = 0;
    for (int i = 0; i < N; ++i)
    {
      int ii = (i+1)%N;
      ret += al.get(i).x*al.get(ii).y-al.get(ii).x*al.get(i).y;
    }
    return ret/2;     
  }
  /** Perimeter of the polygon given in al */
  static double perimeter(ArrayList<Point> al)
  {
    int N = al.size();
    double ret = 0;
    for (int i = 0; i < N; ++i)
    {
      int ii = (i+1)%N;
      ret += dist(al.get(i),al.get(ii));
    }
    return ret;
  }
  /** Returns if a->b->c forms a left turn */
  static boolean isLeft(Point a, Point b, Point c) { return cross(a,b,c) >= 0; }
  /** Returns if a,b,c are collinear*/
  static boolean isCollin(Point a, Point b, Point c) { return Math.abs(cross(a,b,c)) < EPS; }
  /** Comparator used to sort for Graham Scan*/
  static class PivotComp implements Comparator<Point>
  {
    Point p;
    public PivotComp(Point p) { this.p = p; }
    @Override
    public int compare(Point o1, Point o2)
    {
      double cr = cross(o1,p,o2);
      if (Math.abs(cr) < EPS) 
      {
        double d1 = Math.hypot(o1.y-p.y, o1.x-p.x);
        double d2 = Math.hypot(o2.y-p.y, o2.x-p.x);
        return d1 < d2 ? -1 : d1 > d2 ? 1 : 0;
      }
      return cr >= 0 ? 1 : -1;
    }
  }
  /** Convex hull */
  static ArrayList<Point> chull(ArrayList<Point> al)
  {
    ArrayList<Point> stack = new ArrayList<Point>();
    if (al.size() <= 3)
    {
      stack.addAll(al);
      return stack;
    }
    int best = 0;
    for (int i = 1; i < al.size(); ++i)
      if (al.get(i).y < al.get(best).y || Math.abs(al.get(i).y-al.get(best).y) < EPS && al.get(i).x < al.get(best).x) best = i;
    Point tmp = al.get(0); al.set(0, al.get(best)); al.set(best, tmp);
    tmp = al.remove(0);
    Collections.sort(al,new PivotComp(tmp));
    al.add(0,tmp);
    stack.add(al.get(0)); stack.add(al.get(1));
    for (int i = 2; i < al.size(); ++i)
    {
      stack.add(al.get(i));
      while (stack.size() > 2)
      {
        int S = stack.size();
        if (isLeft(stack.get(S-3),stack.get(S-2),stack.get(S-1))) break;
        else stack.remove(S-2);
      }
    }
    return stack;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numTestCases = sc.nextInt();

    for (int i = 0; i < numTestCases; i++) {
      double ribbonLength = sc.nextDouble();
      int numNails = sc.nextInt();

      ArrayList<Point> points = new ArrayList<Point>();

      for (int j = 0; j < numNails; j++) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        points.add(new Point(x, y, j));
      }

      ArrayList<Point> convexHull = chull(points);
      double convexHullPerimeter = perimeter(convexHull);
      ribbonLength = Math.max(ribbonLength, convexHullPerimeter);
      System.out.printf("%.5f\n", ribbonLength);
    }
  }
}