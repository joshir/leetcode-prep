package com.joshir.recursion.one;

import java.util.stream.IntStream;

public class DiagonalMazePathsTwo {
  public static void main(String[] args) {
    diagonalMazePaths(0,0, 2,2,""); /* implies 3x3*/
  }

  public static void diagonalMazePaths(int srcRow,
                                       int srcCol,
                                       int destRow,
                                       int destCol,
                                       String ssf) {

    if (srcRow == destRow && srcCol == destCol) {
      System.out.println(ssf);
      return;
    }

    IntStream.range(1, destCol - srcCol + 1)
      .forEach( index -> diagonalMazePaths(srcRow, srcCol+1, destRow, destCol, "h"+index+ssf ));
    IntStream.range(1, destRow - srcRow + 1)
      .forEach( index -> diagonalMazePaths(srcRow+1, srcCol, destRow, destCol, "v"+index+ssf ));
    IntStream.range(1,
      Math.min(destRow - srcRow +1, destCol - srcCol + 1))
      .forEach( index -> diagonalMazePaths(srcRow+1, srcCol+1, destRow, destCol, "d"+index+ssf ));
  }
}
