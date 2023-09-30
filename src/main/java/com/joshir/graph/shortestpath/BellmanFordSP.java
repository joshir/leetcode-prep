package com.joshir.graph.shortestpath;

import com.joshir.graph.mst.Edge;
import kotlin.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class BellmanFordSP {
  /* begin path from */
  private final int source;

  /* ending node*/
  private final int destination;

  /* number of edges */
  private final int vertices;

  /* number of nodes */
  private final int nodes;

  /* all vertices */
  private final List<Edge> edges;

  /* shortest path to reach node a is dist[a] */
  private final int[] dist;

  /* predecessor of node a is path[a] */
  private final int[] path;

  public BellmanFordSP(int source, int destination, Edge[] edges, int nodes) {
    this.source = source;
    this.destination = destination;
    this.vertices = edges.length;
    this.nodes = nodes;
    this.dist = new int[nodes];
    this.path = new int[nodes];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(path, -1);
    this.edges = Arrays.stream(edges).toList();
  }

  public Pair<int[],int[]> relax() {
    dist[source] = 0;

    for (int n = 0; n < nodes -1; n++) {
      for (Edge e : edges){
        if (dist[e.source] < Integer.MAX_VALUE) {
          if(dist[e.destination] >  dist[e.source] + e.weight) {
            dist[e.destination] =  dist[e.source] + e.weight;
            path[e.destination] = e.source;
          }
        }
      }
    }

    if (dist[destination] == Integer.MAX_VALUE) {
      return null;
    }else {
      int res[] = new int[nodes];
      ArrayDeque<Integer> s = new ArrayDeque<>();
      for(int cur = destination; cur != -1; cur = path[cur])
        s.push(cur);
      for(int i = 0; !s.isEmpty();) {
        res[i++] = s.pop();
      }
      return new Pair<>(dist,res);
    }
  }
}
