package com.joshir.backtrack;

import java.util.HashSet;

public class NQueensII {
  public class Solution {
    private final HashSet<Integer> cols = new HashSet<>();
    private final HashSet<Integer> p_diagonals = new HashSet<>();
    private final HashSet<Integer> n_diagonals = new HashSet<>();
    private int solutions = 0;

    public int solveNQueens(int n) {
      char[][] board = new char[n][n];
      for(int i = 0; i < board.length; i++)
        for(int j = 0; j < board[i].length; j++)
          board[i][j] = '.';

      backtrack(board, 0, 0);
      return solutions;
    }

    private void backtrack(char [][] board, int row, int col) {
      // all solutions are unique, even if one is a "symmetry" of another
      if (row == board.length)
        ++solutions;

      for(int colx = 0; colx < board[0].length; colx++) {
        if(isValidPosition(board, row, colx)){
          board[row][colx] = 'Q';
          cols.add(colx);
          p_diagonals.add(row + colx);
          n_diagonals.add(row - colx);

          backtrack(board, row, colx);

          cols.remove(colx);
          p_diagonals.remove(row + colx);
          n_diagonals.remove(row - colx);
          board[row][colx] = '.';
        }
      }
    }

    private boolean isValidPosition(char[][] board, int row, int col){
      return !(cols.contains(col) ||  p_diagonals.contains(row+col) || n_diagonals.contains(row-col));
    }
  }
}
