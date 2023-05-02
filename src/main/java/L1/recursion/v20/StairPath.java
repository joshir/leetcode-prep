package L1.recursion.v20;

import java.util.ArrayList;
import java.util.List;

public class StairPath {
  public static void main(String[] args) {
    getStairPaths(4).forEach(System.out::println);
  }

  public static List<String> getStairPaths(int n) {
    if (n < 0) return new ArrayList<>();
    if (n==0) {
      List<String> list = new ArrayList<>();
      list.add("");
      return list;
    }
    List<String>  paths1 = getStairPaths(n-1);
    List<String>  paths2 = getStairPaths(n-2);
    List<String>  paths3 = getStairPaths(n-3);

    List<String> allPaths = new ArrayList<>();
    for (String path: paths1) {
      allPaths.add(1+path);
    }

    for (String path: paths2) {
      allPaths.add(2+path);
    }

    for (String path: paths3) {
      allPaths.add(3+path);
    }
    return allPaths;
  }
}
