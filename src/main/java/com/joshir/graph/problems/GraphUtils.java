package com.joshir.graph.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphUtils {
  public static final List<int[]> edges = List.of(
    new int[] {0,1},
    new int[] {1,2},
    new int[] {2,3},
    new int[] {0,4},
    new int[] {0,5},
    new int[] {2,5});

  public static Map<Integer, List<Integer>> adjacencyList(boolean isDirected, List<int[]> edges) {
    var al = new HashMap<Integer, List<Integer>>();
    for (var e : edges) {
      var l = al.getOrDefault(e[0], new ArrayList<>());
      l.add(e[1]);
      al.put(e[0],l);

      if(!isDirected) {
        var s = al.getOrDefault(e[1], new ArrayList<>());
        s.add(e[0]);
        al.put(e[1],s);
      }
    }
    return al;
  }

  public static Map<Integer, List<Integer>> reverse(Map<Integer, List<Integer>> al) {
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

  public static void g(HashMap<Integer, List<Integer>> al) {
    for (var e : al.entrySet()) {
      System.out.println(e.getKey() + " : " + Arrays.toString(e.getValue().toArray()));
    }
  }

  public static Set<Integer> dfs(Map<Integer, List<Integer>> al, int v) {
    var visited = new HashMap<Integer, Boolean>();
    Stack<Integer> q = new Stack<>();
    Set<Integer> res = new HashSet<>();

    for (int i = 0; i < v; i++)
      visited.put(i, false);

    for(int node = 0; node < v ; node++) { // g may be disconnected
      if (!visited.getOrDefault(node,false)) {
        q.push(node);
        visited.put(node, true);
        while(!q.isEmpty()) {
          int front = q.pop();
          res.add(front);
          for (int n: al.getOrDefault(front, new ArrayList<>())) {
            if(!visited.getOrDefault(n, false))
              q.push(n);
            visited.put(n, true);
          }
        }
      }
    }
    return res;
  }

  public static Set<Integer> bfs(Map<Integer, List<Integer>> al, int v) {
    var visited = new HashMap<Integer, Boolean>();
    Queue<Integer> q = new ArrayDeque<>();
    Set<Integer> res = new HashSet<>();

    for (int i = 0; i < v; i++)
      visited.put(i, false);

    for(int node = 0; node < v ; node++) {
      if (!visited.getOrDefault(node,false)) {
        q.offer(node);
        visited.put(node, true);
        while(!q.isEmpty()) {
          int front = q.poll();
          res.add(front);
          for (int n: al.getOrDefault(front, new ArrayList<>())) {
            if(!visited.getOrDefault(n, false))
              q.offer(n);
            visited.put(n, true);
          }
        }
      }
    }
    return res;
  }

  public static Map<Integer, List<Integer>> pairs( boolean isDirected , Integer... pairs) {
    List<int[]> arr = new ArrayList<>();
    for (int i = 0; i < pairs.length - 1; i++)
      arr.add(new int[] {pairs[i], pairs[i+1]});
    return adjacencyList(isDirected, arr);
  }

  public static int vertices(Integer... pairs) {
    return Stream.of(pairs).collect(Collectors.toSet()).size();
  }

  public static int vertices(List<int[]> pairs) {
    Set<Integer> s = new HashSet<>();
    pairs.forEach(p -> s.addAll(List.of(p[0], p[1])));

    return s.size();
  }

  public static int vertices(int[][] pairs) {
    return vertices(Arrays.stream(pairs).toList());
  }
}
