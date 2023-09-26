package com.joshir.graph.elementary;


import com.joshir.graph.problems.GraphUtils;

import java.util.*;

public class EdgeClassification {
  /* vertex 0 to n-1*/
  private final int vertices;

  /* adjacency list*/
  private final Map<Integer, List<Integer>> adj;

  /* edge type */
  private enum Classification {T, B, F, C}

  /* start time for u pushed on the call stack*/
  private final int[] start;

  /* end times for vertex v for stack unwinding */
  private final int[] end;

  /* time/clock record stack trace begin and end*/
  private int clock = 0;

  /* tree edge - 0, back edge - 1, forward edge - 2, cross edge - 3 */
  private final Map<Classification, List<int[]>> es = new EnumMap<>(Classification.class);


  EdgeClassification (Map<Integer, List<Integer>> adj, int vertices) {
    this.vertices = vertices;
    this.adj = adj;
    this.start = new int[vertices];
    this.end = new int[vertices];
    Arrays.fill(this.start, -1);
  }

  /*   https://www.cs.yale.edu/homes/aspnes/pinewiki/DepthFirstSearch.html
  *
  *    Tree edge      start[u] < start[v]        end[u] > end[v]
  *    Back edge      start[u] > start[v]        end[u] < end[v]
  *    Forward edge   start[u] < start[v]        end[u] > end[v]
  *    Cross edge     start[u] > start[v]        end[u] > end[v]
  *
  * */
  public void dfs(int u) {
    start[u] = clock++;
    for (int v: adj.getOrDefault(u, new ArrayList<>())) {
      Classification c = Classification.T;
      if(start[v] == -1) {
        mapEdge(Classification.T, u, v);
        dfs(v);
      } else if (start[u] > start[v] && end[u] < end[v]) c = Classification.B;
      else if (start[u] < start[v] && end[u] > end[v]) c = Classification.F;
      else if (start[u] > start[v] && end[u] > end[v]) c = Classification.C;

      mapEdge(c, u, v);
      end[u] = clock++; // keep incrementing end time for node u until there are no more neighbors to visit
    }
  }

  private void mapEdge(Classification c, int u, int v) {
    var l = es.getOrDefault(c, new ArrayList<>());
    l.add(new int[] {u, v});
    es.put(c, l);
  }

  public Map<Classification, List<int[]>> classify() {
    for (int node = 0; node < vertices; node++)
      if (-1 == start[node])
        dfs(node);
    return es;
  }

  public static void main(String[] args) {
    var g =
      GraphUtils.pairs(true,0,5,1,3,1,7,2,4,2,3,2,8,2,9,3,3,4,0,5,2,5,0,6,0,7,7,7,4,7,3,8,8,8,9,9,9);
    var es =  new EdgeClassification(g, 10).classify();
    es.forEach((c,l) ->
      System.out.println(c + ": \n"+ l.stream()
      .toList()
      .stream()
      .map(edge -> edge[0] +", " + edge[1] +"\n").reduce("", String::concat)));
  }
}
