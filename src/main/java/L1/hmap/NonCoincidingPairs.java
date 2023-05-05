package L1.hmap;


import java.util.HashMap;
import java.util.Map;

/*
*
*  manhattan distance = |x2-x1| + |y2-y1|
*  euclidean distance = ((x2-x1)^2 + (y2-y1^2))^.5
*  these two can only be equal when xs or ys are the same
*  sparing the case when the distance is 0
* */
public class NonCoincidingPairs {
  private static class Pair {
    Integer x;
    Integer y;
    Pair(Integer x, Integer y) {
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) {
    /* (4,3) (2,3) (4,6) (6,1) (2,3) (8,3) (4,6) (2,3)*/
    System.out.println(
      numNonCoincidingPairs(
        new int[] {4, 2, 4, 6, 2, 8, 4, 2},
        new int[] {3, 3, 6, 1, 3, 3, 6, 3}, 8)
    );
  }

  public static int numNonCoincidingPairs(int[] xs, int[] ys, int N) {
    Map<Integer, Integer> cxMap = new HashMap<>();
    Map<Integer, Integer> cyMap = new HashMap<>();
    Map<Pair, Integer> coordinateMap = new HashMap<>();

    int pairs = 0; Pair currentPair;
    for (int index = 0; index < N; index++){
      currentPair = new Pair(xs[index],ys[index]);
      pairs = cxMap.getOrDefault(xs[index], 0) + cyMap.getOrDefault(ys[index],0) - 2 * coordinateMap.getOrDefault(currentPair,0);
      cxMap.put(xs[index], cxMap.getOrDefault(xs[index], 0) + 1);
      cyMap.put(ys[index], cyMap.getOrDefault(ys[index], 0) + 1);
      coordinateMap.put(currentPair, coordinateMap.getOrDefault(currentPair,0) + 1);
    }
    return pairs;
  }
}
