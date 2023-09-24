package com.joshir.graph.mst;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
  /* vertex count*/
  private int vertices;
  /* edge in */
  private Edge[] edges;
  /* disjoint set for connected components */
  private UnionFind uf;
  /* min span tree out */
  private Edge[] mst;

  public Kruskal (Edge[] edges, int v) {
    Arrays.sort(edges, Comparator.comparingInt(e -> e.weight);
    this.edges = Arrays.copyOf(edges, edges.length);
    this.vertices = v;
    this.uf = new UnionFind(vertices);
    this.mst = new Edge[vertices];
  }

  public Edge[] findMST() {
    // trees can have a max of v-1 vertices in order that there isn't a cycle
    for (int i = 0, u = 0, v = 0,  es = 0; es <= vertices - 1 && i < edges.length ; i++) {
     if ((u = uf.find(edges[i].source)) == (v = uf.find(edges[i].destination)))
       continue;
     uf.union(u, v);
     mst[es++] = edges[i];
    }
    return mst;
  }
}
