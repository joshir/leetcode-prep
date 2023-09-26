package com.joshir.graph.problems;

import java.util.Stack;

public class MaxAreaOfIsland {
  class SolutionDFS {
    private boolean[][] seen;
    public int dfs(int[][] grid, int r, int c) {
      if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0)
        return 0;
      // obv mark as seen once we know r,c is a valid island
      seen[r][c] = true;

      // area of this island + area of possible other islands
      return (1 + dfs(grid, r+1, c) + dfs(grid,r-1, c)+ dfs(grid,r, c-1) + dfs(grid,r, c+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
      seen = new boolean[grid.length][grid[0].length];
      int ans = 0;
      for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
          ans = Math.max(ans, dfs(grid, r, c));
        }
      }
      return ans;
    }
  }

  class SolutionDFSIterative {
    public int maxAreaOfIsland(int[][] grid) {
      boolean[][] seen = new boolean[grid.length][grid[0].length];
      int[] dr = new int[]{1, -1, 0, 0};
      int[] dc = new int[]{0, 0, 1, -1};

      int ans = 0;
      for (int r0 = 0; r0 < grid.length; r0++) {
        for (int c0 = 0; c0 < grid[0].length; c0++) {
          if (grid[r0][c0] == 1 && !seen[r0][c0]) {
            int shape = 0;
            Stack<int[]> stack = new Stack();
            stack.push(new int[]{r0, c0});
            seen[r0][c0] = true;

            while (!stack.empty()) {
              int[] node = stack.pop();
              int r = node[0], c = node[1];
              shape++;

              for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < grid.length &&
                  0 <= nc && nc < grid[0].length &&
                  grid[nr][nc] == 1 && !seen[nr][nc]) {
                  stack.push(new int[]{nr, nc});
                  seen[nr][nc] = true;
                }
              }
            }
            ans = Math.max(ans, shape);
          }
        }
      }
      return ans;
    }
  }

  class SolutionUF {

    private static final int[][] dirs = {
      {1, 0},
      {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
      int r = grid.length, c = grid[0].length;
      UnionFind uf = new UnionFind(r * c);
      boolean having1 = false;
      for(int i = 0; i < r; i += 1) {
        for(int j = 0; j < c; j += 1) {
          if(grid[i][j] == 1) {
            having1 = true;
            for(int[] xy : dirs) {
              int x = i + xy[0];
              int y = j + xy[1];
              if(check(grid, x, y)) {
                uf.union(i * c + j, x * c + y);
              }
            }
          }
        }
      }

      return having1 ? uf.maxSize() : 0;
    }

    private boolean check(int[][] grid, int i, int j) {
      if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return false;
      return true;
    }
  }

  class UnionFind {

    private static final int DEFAULT_CAPACITY = 25_00;
    private int size;
    private int[] parent;
    private int[] sz;
    private int maxComponent;
    private int componentCnt;

    public UnionFind() {
      size = DEFAULT_CAPACITY;
      componentCnt = size;
      parent = new int[size];
      sz = new int[size];

      for(int i = 0; i < size; i += 1) {
        parent[i] = -1;
      }
    }

    public UnionFind(int n) {
      this.size = this.componentCnt = n;
      parent = new int[size];
      sz = new int[size];
      maxComponent = 1;
      for(int i = 0; i < size; i += 1) {
        parent[i] = i;
        sz[i] = 1;
      }
    }

    private int find(int v) {
      int root = v;
      while(root != parent[root]) {
        root = parent[root];
      }

      //Path Compression
      while(v != root) {
        int immediateParent = parent[v];
        parent[v] = root;
        v = immediateParent;
      }

      return root;
    }

    public void union(int a, int b) {

      int v1 = find(a);
      int v2 = find(b);

      if(v1 != v2) {
        if(sz[v1] < sz[v2]) {
          parent[v1] = v2;
          sz[v2] += sz[v1];
          maxComponent = Math.max(maxComponent, sz[v2]);
        } else {
          parent[v2] = v1;
          sz[v1] += sz[v2];
          maxComponent = Math.max(maxComponent, sz[v1]);
        }

        //Since we merge [One of them into single one]. Component count must be decrease by 1
        componentCnt -= 1;
      }

    }

    public int size() {
      return componentCnt;
    }

    public int maxSize() {
      return maxComponent;
    }
  }
}
