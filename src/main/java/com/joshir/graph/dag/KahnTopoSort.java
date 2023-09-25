package com.joshir.graph.dag;

import java.util.*;

public class KahnTopoSort {

  /* count of vertex*/
  private int vertices;

  /* edges as x,y pair*/
  private Map<Integer, List<Integer>> adj;

  /* q for bfs*/
  private Queue<Integer> q;

  /* topological ordering out*/
  private List<Integer> l;

  /* count of indegree zero nodes after kahn is called*/
  private int zero_indegree = -1;

  /* in-degree for nodes 0 to V-1 */
  private int[] indegree;

  public KahnTopoSort(int vertices, int [][] edges) {
    this.vertices = vertices;
    this.indegree = new int[vertices];
    this.adj = adjacencyWithInDegree(edges);
    this.q = new ArrayDeque<>();
    this.l = new ArrayList<>();
  }

  private Map<Integer, List<Integer>> adjacencyWithInDegree(int[][] edges) {
    var adj = new HashMap<Integer, List<Integer>>();
    for (int[] e : edges) {
      var l = adj.getOrDefault(e[0], new ArrayList<>());
      l.add(e[1]);
      adj.put(e[0], l);
      indegree[e[1]]++;
    }
    return adj;
  }

  public List<Integer> kahn() {
    /* initialize queue with edges that have no dependencies */
    for (int i = 0; i < vertices; i++)
      if (indegree[i] == 0){
        q.offer(i);
      }


    for (zero_indegree = 0; !q.isEmpty() ; zero_indegree++) {
      int node = q.poll();
      l.add(node);
      for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
        /* "delete" the edge */
        if (--indegree[neighbor] == 0){
          q.offer(neighbor);
        }
      }
    }

    /* side effect but who cares */
    System.out.println((vertices == zero_indegree) ? "DAG" : "cycle present");
    return l;
  }

  public boolean isDAG() {
    kahn();
    return zero_indegree == this.vertices;
  }

  public static void main(String[] args) {
    var k = new KahnTopoSort(6, new int[][]{
      {5,2},
      {5,0},
      {4,0},
      {4,1},
      {2,3},
      {3,1}});
    System.out.println(Arrays.toString(k.kahn().toArray()));
  }
}
