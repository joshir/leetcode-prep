package com.joshir.backtrack;

public class SudokuSolver {
  class Solution {
    private boolean isValidPlacement(char[][] board, int row, int col, char value) {
      for (int index = 0; index < board.length; index++) {
        if (board[index][col] == value ||
          board[row][index] == value ||
          board[3 * (row / 3) + index / 3][3 * (col / 3) + index % 3] == value) {
          return false;
        }
      }
      return true;
    }

    private void backtrack(char[][] board, int row, int col) {
      if (row == board.length) // all levels done
        ;
      else if (col == board[0].length)
        backtrack(board, row + 1, 0);
      else if (board[row][col] != '.')
        backtrack(board, row, col + 1);
      else {
        for (char possible = '1'; possible <= '9'; possible++) {
          if (isValidPlacement(board, row, col, possible)) {
            board[row][col] = possible;
            backtrack(board, row, col + 1);
            board[row][col] = '.';
          }
        }
      }
    }

    public void solveSudoku(char[][] board) {
      backtrack(board, 0, 0);
    }
  }
}
