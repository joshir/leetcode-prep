package com.joshir.graph.elementary;

import com.joshir.graph.problems.GraphUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BackedgeDetection {
  private final int vertices;
  private final Map<Integer, List<Integer>> adj;
  private final List<int[]> backedges = new ArrayList<>();
  private final int[] visited;

  public BackedgeDetection (int v, Map<Integer, List<Integer>> adj) {
    this.vertices = v;
    this.adj = adj;
    this.visited = new int[v];
  }

  public List<int[]> detect () {
    for(int node = 0; node < vertices; node++) {
      if(visited[node] == 0)
        dfs(node, 0);
    }
    return backedges;
  }

  private void dfs(int node, int parent) {
    visited[node] = 1; // visited and on the call stack
    for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
      if (visited[neighbor] == 0) { // uncharted territory
        dfs(neighbor, node);
      }
      else if (neighbor != parent && visited[neighbor] == 1) { // on the call stack and not equal to parent? must be a back-edge
        backedges.add(new int[] {node, neighbor});
      }
    }
    visited[node] = 2; // visited and off the call stack
  }

  public static void main(String[] args) {
    var al = GraphUtils.adjacencyList(false, GraphUtils.edges);
    System.out.println(Arrays.toString(new BackedgeDetection(6, al).detect().toArray()));
  }
}
