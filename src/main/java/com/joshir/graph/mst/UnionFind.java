package com.joshir.graph.mst;

public class UnionFind {
  private int size;
  private int[] parent;
  private int[] rank;

  public UnionFind(int size) {
    this.size = size;
    parent = new int[size + 1];
    rank = new int[size + 1];
    for (int i = 0; i < size + 1; i++) {
      parent[i] = i;
      rank[i] = 0;
    }
  }

  public void union(int u, int v) {
    u = find(u);
    v = find(v);

    if (rank[u] == rank[v]) {
      parent[u] = v;
      rank[v]++;
    }
    else
      parent[rank[u] < rank[v] ? u : v] = rank[u] < rank[v] ? v : u;
  }

  public int find(int node) {
    if(parent[node] == node)
      return node;
    return parent[node] = find(parent[node]);
  }
}
