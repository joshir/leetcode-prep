package com.joshir.hmap;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
*
*  manhattan distance = |x2-x1| + |y2-y1|
*  euclidean distance = ((x2-x1)^2 + (y2-y1^2))^.5
*  these two can only be equal when xs or ys are the same
*  sparing the case when the distance is 0
* */
public class NonCoincidingPairs {
  private static class Pair<T> {
    final T x;
    final T y;
    Pair(T x, T y) {
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) {
    Integer []a = new Integer[] {4, 2, 4, 6, 2, 8, 4, 2};
    Integer []b = new Integer[] {3, 3, 6, 1, 3, 3, 6, 3};

    /* (4,3) (2,3) (4,6) (6,1) (2,3) (8,3) (4,6) (2,3)*/
    System.out.println(
      numNonCoincidingPairs(zip(a,b))
    );
  }

  public static <T> List<Pair<T>> zip(T [] a, T [] b) {
    return IntStream.range(0,Math.min(a.length, b.length))
      .mapToObj(index-> new Pair<>(a[index],b[index]))
      .toList();
  }

  public static int numNonCoincidingPairs(List<Pair<Integer>> pairs) {
    Map<Integer, Integer> cxMap = new HashMap<>();
    Map<Integer, Integer> cyMap = new HashMap<>();
    Map<Pair<Integer>, Integer> pairFrequency = new HashMap<>();

    return pairs.stream().reduce(0, (partialSum, pair) -> {
      partialSum = cxMap.getOrDefault(pair.x, 0) + cyMap.getOrDefault(pair.y,0) - 2 * pairFrequency.getOrDefault(pair,0);
      cxMap.put(pair.x, cxMap.getOrDefault(pair.x, 0) + 1);
      cyMap.put(pair.y, cyMap.getOrDefault(pair.y, 0) + 1);
      pairFrequency.put(pair, pairFrequency.getOrDefault(pair,0) + 1);
      return partialSum;
    }, Integer::sum);
  }
}
