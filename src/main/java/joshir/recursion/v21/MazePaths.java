package joshir.recursion.v21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MazePaths {
  public static void main(String[] args) {
    getMazePaths(0,0,2,2).forEach(System.out::println);
  }

  public static List<String> getMazePaths(int srcRow, int srcCol, int destRow, int destCol) {
    if(srcRow == destRow && srcCol == destCol) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }
    if(srcRow > destRow || srcCol > destCol) {
      return new ArrayList<>();
    }

    List<String> movesDown = getMazePaths(srcRow+1,srcCol, destRow, destCol)
      .stream().map(move-> "v"+move).toList();
    List<String> movesRight = getMazePaths(srcRow, srcCol+1, destRow, destCol)
      .stream().map(move-> "h"+move).toList();
    return Stream.of(movesDown,movesRight)
      .flatMap(List::stream).toList();
  }
}
