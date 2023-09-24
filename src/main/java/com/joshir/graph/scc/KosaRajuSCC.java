package com.joshir.graph.scc;

import com.joshir.graph.GraphUtils;

import java.util.*;

// https://www.topcoder.com/thrive/articles/kosarajus-algorithm-for-strongly-connected-components
public class KosaRajuSCC {
  private Map<Integer, List<Integer>> al;
  private final Stack<Integer> stack;
  private final boolean[] visited;
  private final int[] component;
  private final List<Integer>[] components;
  private final int v;

  @SuppressWarnings("unchecked")
  KosaRajuSCC(Map<Integer, List<Integer>> al, int max_nodes) {
    this.v = max_nodes;
    this.al = al;
    this.stack = new Stack<>();
    this.visited = new boolean[max_nodes];
    this.component = new int[v];
    this.components = (List<Integer>[]) new ArrayList<?>[v];

    for (int i = 0; i < v; i++) {
      this.components[i] = new ArrayList<>();
    }
  }

  public int kosaraju() {
    for (int node = 0; node < v; node++) {
      if(!visited[node]) {
        dfs(node);
      }
    }

    al = GraphUtils.reverse(al);
    for(int i = 0; i < v; i++)
      visited[i] = false;

    int componentsNum = 0;
    while(!stack.isEmpty()) {
      int node = stack.pop();
      if(!visited[node]){
        System.out.print("Component " + componentsNum + ": ");
        dfs(node, componentsNum);
        componentsNum++;
        System.out.println();
      }
    }

    return componentsNum;
  }

  private void dfs(int node) {
    visited[node] = true;
    for (int n: al.getOrDefault(node, new ArrayList<>())) {
      if (!visited[n]) {
        dfs(n);
      }
    }
    stack.add(node);
  }

  private void dfs(int node, int componentNumber) {
    System.out.print(" " + node + " ");
    component[node] = componentNumber;
    components[componentNumber].add(node);
    visited[node] = true;
    for (int n: al.getOrDefault(node, new ArrayList<>())) {
      if (!visited[n]) {
        dfs(n, componentNumber);
      }
    }
  }

  public static void main(String[] args) {
    int n = new KosaRajuSCC(
      GraphUtils.adjacencyList(List.of(
        new int[] {0,1},
        new int[] {1,2},
        new int[] {2,0},
        new int[] {2,3},
        new int[] {3,4},
        new int[] {4,5},
        new int[] {5,6},
        new int[] {6,7},
        new int[] {4,7},
        new int[] {6,4}
        )
      , true),8).kosaraju();
    System.out.println("Total number of components: "+ n);
  }
}
