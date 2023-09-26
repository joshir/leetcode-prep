package com.joshir.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HamiltonianPaths {
  private int vertices;
  private Map<Integer, List<Integer>> adj;
  private List<List<Integer>> ll = new ArrayList<>();
  private boolean[] visited;
  public HamiltonianPaths (int v, Map<Integer, List<Integer>> adj) {
    this.vertices = v;
    this.adj = adj;
    this.visited = new boolean[v];
  }

  public List<List<Integer>> hamiltonian () {
    for (int i = 0; i < vertices; i++){
      if(!visited[i])
        backtrack(i, 0, new ArrayList<>());
    }
    return ll;
  }

  public void backtrack(int node, int len, List<Integer> l) {
    if (len == vertices) {
      ll.add(l);
      return;
    }
    visited[node] = true;
    l.add(node);
    for (int n : adj.getOrDefault(node, new ArrayList<>())) {
      if(!visited[n])
        backtrack(n, len + 1, l);
    }
    visited[node] = false;
  }
  public static void main(String[] args) {
    var g = GraphUtils.adjacencyList(true, GraphUtils.edges);
    var ll = new HamiltonianPaths(6, g).hamiltonian();
    for (List l : ll)
      System.out.println(Arrays.toString(l.toArray()));
    if (ll.isEmpty())
      System.out.println("no hamiltonian paths");
  }
}
