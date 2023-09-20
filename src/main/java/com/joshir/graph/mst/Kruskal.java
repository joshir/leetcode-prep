package com.joshir.graph.mst;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
  public static Edge[] findMST(Edge[] edges, int n) {
    Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));
    UnionFind uf = new UnionFind(n);
    Edge[] mst = new Edge[n];
    for (int i = 0, edgecounter = 0; edgecounter <= n - 1 && i < edges.length ; i++) {
     int u = uf.find(edges[i].source);
     int v = uf.find(edges[i].destination);

     if (u == v)
       continue;
     uf.union(u, v);
     mst[++edgecounter] = edges[i];
    }
    return mst;
  }
}
