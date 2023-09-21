package com.joshir.graph;

import java.util.List;
import java.util.Map;

public class CountStronglyConnectedComponents extends TopSort{

  CountStronglyConnectedComponents(Map<Integer, List<Integer>> al, int v) {
    super(al, v);
  }

  public static void main(String[] args) {
    new CountStronglyConnectedComponents(GraphUtils.adjacencyList(GraphUtils.edges),6).topSort();
  }
}
