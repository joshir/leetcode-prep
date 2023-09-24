package com.joshir.graph;


import java.util.List;
import java.util.Map;

public class EdgeClassification {
  private int vertices;
  private Map<Integer, List<Integer>> adj;

  EdgeClassification (Map<Integer, List<Integer>> adj, int vertices) {
    this.vertices = vertices;
    this.adj = adj;
  }

  public static void main(String[] args) {
    var g = GraphUtils.adjacencyList(GraphUtils.edges,false);
    new EdgeClassification(g, 6);
  }
}
