package com.joshir.graph;

import java.util.*;

public class GraphUtils {
  public static final List<int[]> edges = List.of((
    new int[] {0,1},
    new int[] {1,2},
    new int[] {2,3},
    new int[] {0,4},
    new int[] {0,5},
    new int[] {2,5});

  public static Map<Integer, List<Integer>> adjacencyList (List<int[]> edges) {
    var al = new HashMap<Integer, List<Integer>>();
    for (var e : edges) {
      var l = al.getOrDefault(e[0], new ArrayList<>());
      l.add(e[1]);
      al.put(e[0],l);
    }
    return al;
  }

  public static Map<Integer, List<Integer>> reverse (Map<Integer, List<Integer>> al) {
    var transpose = new HashMap<Integer, List<Integer>>();
    for (var entry : al.entrySet()) {
      for (int node: entry.getValue()) {
        var list = transpose.getOrDefault(node, new ArrayList<>());
        list.add(entry.getKey());
        transpose.put(node, list);
      }
    }
    return transpose;
  }

  public static void g (HashMap<Integer, List<Integer>> al) {
    for (var e : al.entrySet()) {
      System.out.println(e.getKey() + " : " + Arrays.toString(e.getValue().toArray()));
    }
  }
}
