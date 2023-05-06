package joshir.hmap;

import java.util.*;

public class PairSum {
  private static final class Pair {
    final Integer x;
    final Integer y;
    Pair(Integer x, Integer y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public String toString(){
      return "(" + x +", "+ y+")";
    }
  }

  public static Map<Integer, List<Pair>> findPairs(int [] array) {
    Map<Integer, List<Pair>> map = new HashMap<>();
    List<Pair> pairs;
    for(int x = 0; x < array.length; x++) {
      for(int y = x + 1; y < array.length; y++) {
        pairs = map.getOrDefault(array[x]+array[y], new ArrayList<>());
        pairs.add(new Pair(array[x],array[y]));
        map.put(array[x]+array[y], pairs);
      }
    }
    return map;
  }

  public static void main(String[] args) {
    findPairs(new int[] {4, 2, 4, 6, 2, 8, 4, 2})
      .forEach((sum, pairs) ->
        System.out.println(sum+": "+ Arrays.toString(pairs.toArray()))
    );
  }
}
