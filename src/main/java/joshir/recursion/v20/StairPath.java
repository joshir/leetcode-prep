package joshir.recursion.v20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    List<String>  paths1 = getStairPaths(n-1).stream()
      .map(path->1+path)
      .toList();
    List<String>  paths2 = getStairPaths(n-2).stream()
      .map(path->2+path)
      .toList();
    List<String>  paths3 = getStairPaths(n-3).stream()
      .map(path->3+path)
      .toList();

    return
      Stream.of(paths1, paths2, paths3)
        .flatMap(List::stream)
        .toList();
  }
}
