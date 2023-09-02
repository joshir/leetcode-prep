package com.joshir.graph;

public class FloodFill {
  class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      int color = image[sr][sc];
      if (color != newColor)
        dfs(image, sr, sc, color, newColor);
      return image;
    }

    private void dfs(int[][] image, int row, int col, int origColor, int newColor) {
      if (row < 0 || col < 0 || row == image.length || col == image[0].length )
        return;
      if( image[row][col] != origColor)
        return;

      image[row][col] = newColor; // mark color

      dfs(image, row - 1, col, origColor, newColor); // recurse in all directions
      dfs(image, row + 1, col, origColor, newColor);
      dfs(image, row, col + 1, origColor, newColor);
      dfs(image, row, col - 1, origColor, newColor);
    }
  }
}
