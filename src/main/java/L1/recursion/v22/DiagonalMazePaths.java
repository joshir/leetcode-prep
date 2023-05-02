package L1.recursion.v22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiagonalMazePaths {
  public static void main(String[] args) {
    diagonalMazePaths(0,0, 3,3).forEach(System.out::println);
  }

  public static List<String> diagonalMazePaths(int srcRow, int srcCol, int destRow, int destCol) {

    if(srcRow == destRow && srcCol == destCol) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }
    if (srcRow > destRow || srcCol > destCol) return new ArrayList<>();


    return null;
  }
}
