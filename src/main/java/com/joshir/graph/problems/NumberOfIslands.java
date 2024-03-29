package com.joshir.graph.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
  class Solution {
    public int numIslands(char[][] grid) {
      int count = 0;

      // O(m*n)
      for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == '1') {
            count++;
            dfs(grid, i, j);
          }
        }
      }

      return count;
    }

    private void dfs(char[][] grid, int i, int j) {
      if( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
      if ( grid[i][j] == '0') return;

      grid[i][j] = '0'; // mark as visited
      dfs(grid, i + 1, j);
      dfs(grid, i - 1, j);
      dfs(grid, i, j + 1);
      dfs(grid, i, j - 1);
    }
  }

  // editorial
  class SolutionWithBFS {
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) return 0;

      int nr = grid.length;
      int nc = grid[0].length;
      int num_islands = 0;

      for (int r = 0; r < nr; ++r) {
        for (int c = 0; c < nc; ++c) {
          if (grid[r][c] == '1') {
            ++num_islands;
            grid[r][c] = '0'; // mark as visited
            Queue<Integer> neighbors = new ArrayDeque<>();
            neighbors.add(r * nc + c);

            while (!neighbors.isEmpty()) {
              int id = neighbors.remove();
              int row = id / nc;
              int col = id % nc;
              if (row - 1 >= 0 && grid[row-1][col] == '1') {
                neighbors.add((row-1) * nc + col);
                grid[row-1][col] = '0';
              }
              if (row + 1 < nr && grid[row+1][col] == '1') {
                neighbors.add((row+1) * nc + col);
                grid[row+1][col] = '0';
              }
              if (col - 1 >= 0 && grid[row][col-1] == '1') {
                neighbors.add(row * nc + col-1);
                grid[row][col-1] = '0';
              }
              if (col + 1 < nc && grid[row][col+1] == '1') {
                neighbors.add(row * nc + col+1);
                grid[row][col+1] = '0';
              }
            }
          }
        }
      }
      return num_islands;
    }
  }

  // editorial
  class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) { // path compression
      if (parent[i] != i) parent[i] = find(parent[i]);
      return parent[i];
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx; rank[rootx] += 1;
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    UnionFind uf = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r-1][c] == '1') {
            uf.union(r * nc + c, (r-1) * nc + c);
          }
          if (r + 1 < nr && grid[r+1][c] == '1') {
            uf.union(r * nc + c, (r+1) * nc + c);
          }
          if (c - 1 >= 0 && grid[r][c-1] == '1') {
            uf.union(r * nc + c, r * nc + c - 1);
          }
          if (c + 1 < nc && grid[r][c+1] == '1') {
            uf.union(r * nc + c, r * nc + c + 1);
          }
        }
      }
    }

    return uf.getCount();
  }
}
