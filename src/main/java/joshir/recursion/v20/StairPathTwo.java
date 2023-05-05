package joshir.recursion.v20;

public class StairPathTwo {
  public static void main(String[] args) {
    getStairPaths(4, "");
  }

  public static void getStairPaths(int n, String ssf) {
    if (n < 0) ; // do nothing and break out
    else if (n==0) {
      System.out.println(ssf);
    }
    else {
      getStairPaths(n-1, 1+ssf);
      getStairPaths(n-2, 2+ssf);
      getStairPaths(n-3, 3+ssf);
    }
  }
}
