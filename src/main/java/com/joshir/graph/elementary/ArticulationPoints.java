package com.joshir.graph.elementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ArticulationPoints {
  private final int vertices;
  private final Map<Integer, List<Integer>> adj;
  private final int[] discovered;
  private final int[] lowlinked;
  private final List<int[]> bridges = new ArrayList<>();
  private final List<Integer> aps = new ArrayList<>();
  private int clock;

  public ArticulationPoints(int vertices, Map<Integer, List<Integer>> adj){
    this.vertices = vertices;
    this.adj = adj;
    this.discovered = new int[vertices];
    this.lowlinked = new int[vertices];
    Arrays.fill(this.discovered, -1);
    Arrays.fill(this.lowlinked, -1);
    this.clock = 0;
  }

  private void dfsWrapper() {
    for(int node = 0; node < vertices; node++){
      if(discovered[node]== -1)
        dfs(node, -1);
    }
  }


  private void dfs(int node, int parent) {
    this.discovered[node] = this.lowlinked[node] = clock++;
    int siblings = 0;
    for (int nbr : adj.getOrDefault(node, new ArrayList<>())) {
      if (-1 == discovered[node]) {
        siblings++;
        dfs(nbr, node);
        lowlinked[node] = Math.min(lowlinked[nbr], lowlinked[node]);

        if(lowlinked[nbr] > discovered[node])
          bridges.add(new int[] {node, nbr});

        if(parent != -1 && lowlinked[nbr] >= discovered[node])
          aps.add(node);

      }else if(nbr != parent)
        lowlinked[node] = Math.min(discovered[nbr], lowlinked[node]);
    }

    if(parent == -1 && siblings > 1)
      aps.add(node);
  }

  public List<int[]> bridges() {
    if(bridges.isEmpty()) {
      dfsWrapper();
    }
    return bridges;
  }

  public List<Integer> articulationPoints() {
    if(aps.isEmpty()) {
      dfsWrapper();
    }
    return aps;
  }

  public static void main(String[] args) {

  }
}
