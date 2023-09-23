package com.joshir.graph;

import java.util.*;

public class KahnTopSort {
  public List<Integer> kahn(int v, int[][] edges) {
    int[] indegree = new int[v];
    var adj = new HashMap<Integer, List<Integer>>();
    var list = new ArrayList<Integer>();

    for (int[] e : edges) {
      var l = adj.getOrDefault(e[0], new ArrayList<>());
      l.add(e[1]);
      adj.put(e[0], l);
      indegree[e[1]]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    // initialize queue with edges that have no dependencies
    for (int i = 0; i < v; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    int n = 0; // count of nodes with indegree of 0
    for ( ;!queue.isEmpty(); n++) {
      int node = queue.poll();
      list.add(node);
      for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
        // "delete" the edge
        if (--indegree[neighbor] == 0)
          queue.offer(neighbor);
      }
    }

    // side effect but who cares
    System.out.println((v == n) ? "DAG" : "cycle present");
    return list;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays
        .toString(new KahnTopSort().kahn(6, new int[][]{{5,2},{5,0}, {4, 0}, {4, 1}, {2,3},{3,1}}).toArray()));
  }
}
