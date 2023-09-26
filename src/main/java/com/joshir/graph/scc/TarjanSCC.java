package com.joshir.graph.scc;

import com.joshir.graph.GraphUtils;

import java.util.*;

public class TarjanSCC {
  private final int vertices;
  private final Map<Integer, List<Integer>> adj;
  private final int[] discovered;
  private final int[] lowlink;
  private final ArrayDeque<Integer> stack;
  private int time = 0;

  /* https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm */
  public TarjanSCC( Map<Integer, List<Integer>> adj, int vertices) {
    this.vertices = vertices;
    this.adj = adj;
    this.discovered = new int[vertices];
    this.lowlink = new int[vertices];
    this.stack = new ArrayDeque<>();
    Arrays.fill(this.discovered, -1);
    Arrays.fill(this.lowlink, -1);
  }

  void dfs(int node, int parent) {
    discovered[node] = lowlink[node] = time++;
    stack.push(node);

    for(int child : adj.getOrDefault(node, new ArrayList<>())){
      if (discovered[child] == -1) {
        dfs(child, parent);
        lowlink[node] = Math.min(lowlink[node], lowlink[child]);
      }
      else if (child != parent)
        lowlink[node] = Math.min(lowlink[node], discovered[child]);
    }

    /* this can only be true a "root" node of an SCC*/
    if (lowlink[node] == discovered[node]) {
      int n;
      do {
        n = stack.pop();
        System.out.print(n + ", ");
      }while( n != node) ;
      System.out.println();
    }
  }

  public void tarjan() {
    for (int node = 0; node < vertices; node++)
      if (discovered[node] == -1){
        dfs(node, -1);
      }
  }

  public static void main(String args[]) {
    var t = new TarjanSCC(GraphUtils.pairs(true,0,1,1,2,2,0,2,3,3,4,4,5,5,6,6,7,4,7,6,4), 8 );
    t.tarjan();
  }
}