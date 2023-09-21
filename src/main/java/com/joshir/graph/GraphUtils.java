package com.joshir.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GraphUtils {
  public static HashMap<Integer, List<Integer>> adjacencyList (List<int[]> edges) {
    var al = new HashMap<Integer, List<Integer>>();
    for (var e : edges) {
      var l = al.getOrDefault(e[0], new ArrayList<>());
      l.add(e[1]);
      al.put(e[0],l);
    }
    return al;
  }

  public static void g (HashMap<Integer, List<Integer>> al) {
    for (var e : al.entrySet()) {
      System.out.println(e.getKey() + " : " + Arrays.toString(e.getValue().toArray()));
    }
  }
}
