package com.joshir.graph.dag;

import com.joshir.graph.GraphUtils;

import java.util.*;

public class TopoSort {
  private final Map<Integer, List<Integer>> al;
  private final List<Integer> list;
  private final boolean[] visited;
  private int v = 0;

  TopoSort(Map<Integer, List<Integer>> al, int v) {
    this.v = v;
    this.al = al;
    this.list = new ArrayList<>();
    this.visited = new boolean[v];
  }

  public List<Integer> topSort() {
    for(int node = 0; node < v ; node++) {
      if (!visited[node]) {
        dfs(node);
      }
    }
    return list;
  }

  private void dfs(int node) {
    // build up all my dependencies and then push myself onto the stack
    visited[node] = true;
    for(Integer neighbor: al.getOrDefault(node, new ArrayList<>())) {
      if(!visited[neighbor])
        dfs(neighbor);
    }
    list.add(node);
  }


  public static void main(String[] args) {
    var al = GraphUtils.adjacencyList(true, GraphUtils.edges);
    new TopoSort(al,6).topSort();
  }
}
