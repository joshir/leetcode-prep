package L1.recursion.v22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiagonalMazePaths {
  public static void main(String[] args) {
    diagonalMazePaths(0,0, 2,2).forEach(System.out::println);
  }

  public static List<String> diagonalMazePaths(int srcRow,
                                               int srcCol,
                                               int destRow,
                                               int destCol) {

    if(srcRow == destRow && srcCol == destCol) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }

    if (srcRow > destRow || srcCol > destCol) return new ArrayList<>();

    List<String>  allPaths = new ArrayList<>() ;
    IntStream.range(1, destCol-srcCol+1)
      .forEach(index ->
        allPaths
          .addAll(diagonalMazePaths(srcRow, srcCol+index , destRow, destCol)
          .stream()
          .map(path -> "h" + index +path).toList())
    );

    IntStream.range(1, destRow-srcRow+1).forEach(index->
      allPaths
        .addAll(diagonalMazePaths(srcRow+index, srcCol , destRow, destCol)
        .stream()
        .map(path -> "v" + index + path).toList()));

    IntStream.range(1,Math.min(destRow - srcRow,  destCol - srcCol)+1).forEach(index ->
      allPaths
        .addAll(diagonalMazePaths(srcRow+index, srcCol+index , destRow, destCol)
        .stream()
        .map(path -> "d" + index + path).toList()));

    return allPaths;
  }
}
