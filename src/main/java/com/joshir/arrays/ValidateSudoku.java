package com.joshir.arrays;

import java.util.Arrays;
public class ValidateSudoku {
  public static boolean isValidSudoku(char[][] board) {
    int xfreq[] = new int[10];
    int yfreq[] = new int[10];
    int sfreq[] = new int[10];
    int k,m;

    for(int i = 0; i < 9; i++) {
      k = i/3;
      for(int j = 0; j < 9; j++){
        m = j/3;
        if(board[i][j] !='.')
          yfreq[board[i][j]-'0']++;
        if(board[j][i] != '.')
          xfreq[board[j][i]-'0']++;
        if(board[k*3+m][3*(i%3)+j%3] !='.') {
          sfreq[board[k*3+m][3*(i%3)+j%3]-'0']++;
        }
      }

      for(int o = 1; o < 10; o++) {
        if(xfreq[o] > 1 || yfreq[o] > 1 || sfreq[o] > 1){
          return false;
        }else {
          xfreq[o] = 0;
          yfreq[o] = 0;
          sfreq[o] = 0;
        }
      }
    }
    return true;
  }


  public static void main(String[] args) {
    char[][] board1 = {
      {'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
      {'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},
      {'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},
      {'.','.','.','.','8','.','.','7','9'},
    };

    char[][] board2 = {
      {'.','.','4','.','.','.','6','3','.'},
      {'.','.','.','.','.','.','.','.','.'},
      {'5','.','.','.','.','.','.','9','.'},
      {'.','.','.','5','6','.','.','.','.'},
      {'4','.','3','.','.','.','.','.','1'},
      {'.','.','.','7','.','.','.','.','.'},
      {'.','.','.','5','.','.','.','.','.'},
      {'.','.','.','.','.','.','.','.','.'},
      {'.','.','.','.','.','.','.','.','.'}};

    System.out.println(isValidSudoku(board2));
  }


// 0,0        0,1        0,2
// 00 01 02   03 04 05   06 07 08
// 10 11 12   13 14 15   16 17 18
// 20 21 22   23 24 25   26 27 28

// 1,0        1,1        1,2
// 30 31 32   33 34 35   36 37 38
// 40 41 42   43 44 45   46 47 48
// 50 51 52   53 54 55   56 57 58

// 2,0        2,1        2,2
// 60 61 62   63 64 65   66 67 68
// 70 71 72   73 74 75   76 77 78
// 80 81 82   83 84 85   86 87 88

}
