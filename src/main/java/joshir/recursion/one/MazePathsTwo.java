package joshir.recursion.one;
public class MazePathsTwo {
  public static void main(String[] args) {
    getMazePaths(0,0,2,2, "");
  }

  public static void getMazePaths(int srcRow, int srcCol, int destRow, int destCol, String ssf) {
    if(srcRow == destRow && srcCol == destCol) {
      System.out.println(ssf);
    }
    else if(srcRow > destRow || srcCol > destCol) ;
    else {
      getMazePaths(srcRow, srcCol+1, destRow, destCol, "x"+ssf ); /* move x */
      getMazePaths(srcRow+1, srcCol, destRow, destCol, "y"+ssf ); /* move y */
    }
  }
}
