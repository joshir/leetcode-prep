package com.joshir.graph;

public class WordSearch {
  public class Solution{
    private char[][] board;
    private boolean[][] visited;
    private String word;
    public Solution(char[][] board, String word) {
      this.board = board;
      this.word = word;
      this.visited =  new boolean[board.length][board[0].length];
    }

    public boolean exists(char[][] board, String word){
      for (int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          // this shouldn't take too long
          if(search(0, i,j))
            return true;
        }
      }
      return false;
    }

    private boolean search(int start_i, int start_j, int index) {
      if(start_i < 0 || start_j < 0 || start_i == board.length || start_j == board[0].length)
       return false;
      if(visited[start_i][start_j])
        return false;
      if(board[start_i][start_j] != word.charAt(index))
        return false;

      visited[start_i][start_j] = true;
      boolean fu= search(start_i+1, start_j,index+1) ||
        search(start_i - 1, start_j,index+1) ||
        search(start_i, start_j + 1,index+1) ||
        search(start_i, start_j - 1,index+1);
      visited[start_i][start_j] = false;
      return fu;
    }
  }
}
