package L1.recursion.v21;

import java.util.ArrayList;
import java.util.List;

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

    List<String> movesDown = getMazePaths(srcRow+1,srcCol, destRow, destCol);
    List<String> movesRight = getMazePaths(srcRow, srcCol+1, destRow, destCol);

    List<String> paths = new ArrayList<>();

    for (String down: movesDown) {
      paths.add("v" + down );
    }

    for (String right: movesRight) {
      paths.add("h" + right);
    }

    return paths;
  }
}
