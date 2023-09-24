package com.joshir.graph.mst;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
  private int vertices;
  private Edge[] edges;
  private UnionFind uf;
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
    for (int i = 0, u = 0, v = 0,  edgecounter = 0; edgecounter <= vertices - 1 && i < edges.length ; i++) {
     if ((u = uf.find(edges[i].source)) == (v = uf.find(edges[i].destination)))
       continue;
     uf.union(u, v);
     mst[edgecounter++] = edges[i];
    }
    return mst;
  }
}
