package L1.recursion.v22;

import java.util.ArrayList;
import java.util.List;

public class DiagonalMazePathsTwo {
  public static void main(String[] args) {
    diagonalMazePaths(0,0, 2,2,"");
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

    if (srcRow > destRow || srcCol > destCol) ;

    for (int index = 1 ; index < destCol - srcCol + 1; index++ ) {
      diagonalMazePaths(srcRow, srcCol+1, destRow, destCol, "h"+index+ssf );
    }

    for (int index = 1 ; index < destRow - srcRow + 1; index++ ) {
      diagonalMazePaths(srcRow+1, srcCol, destRow, destCol, "v"+index+ssf );
    }

    for (int index = 1 ; index < destRow - srcRow +1 && index < destCol - srcCol + 1; index++ ) {
      diagonalMazePaths(srcRow+1, srcCol+1, destRow, destCol, "d"+index+ssf );
    }
  }
}
