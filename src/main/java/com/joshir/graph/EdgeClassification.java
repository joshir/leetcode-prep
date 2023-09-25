package com.joshir.graph;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

public class EdgeClassification {
  private int vertices;
  private Map<Integer, List<Integer>> adj;
  private int[] disc;
  private int[] low;
  private boolean inprogress[];
  private ArrayDeque<Integer> stack;
  private int time = -1;

  EdgeClassification (Map<Integer, List<Integer>> adj, int vertices) {
    this.vertices = vertices;
    this.adj = adj;
    this.disc = new int[vertices];
    this.low = new int[vertices];
    this.inprogress = new boolean[vertices];
    this.stack = new ArrayDeque<>();
    time = 0;
    for (int i = 0; i < vertices; i++) {
      this.disc[i] = -1;
      this.low[i] = -1;
    }
  }

  public void dfs(int node) {
  }

  public void classify() {
    for (int i = 0; i < vertices; i++)
      if (disc[i] == -1)
        dfs(i);
  }

  public static void main(String[] args) {
    var g = GraphUtils.adjacencyList(false, GraphUtils.edges);
    new EdgeClassification(g, 6);
  }
}
