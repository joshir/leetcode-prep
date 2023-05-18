package joshir.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class TrapRainwater {

  private static final LinkedList<Integer> stack = new LinkedList<>();

  private static final HashMap<Integer, Pair> map = new HashMap<>();

  final static class Pair {
    Integer i1;
    Integer i2;
  }

  public static int trapRain(int[] blocks) {
    Pair temp = new Pair();
    temp.i1 = -1;  /* left  */
    temp.i2 = -1;  /* right */

    stack.add(0);
    map.put(0, temp);
    for(int i = 1; i < blocks.length; i++) {
      temp = new Pair();
      while(!stack.isEmpty() && blocks[i] >= blocks[stack.peekLast()])
        map.get(stack.removeLast()).i2 = i;

      temp.i1 = stack.isEmpty() ? -1 : stack.peekLast();
      map.put(i, temp);
      stack.add(i);
    }

    while(!stack.isEmpty())
      map.get(stack.removeLast()).i2 = -1;

    int trapped = 0;
    for (int i = 0; i < blocks.length; i++) {
      temp =  map.get(i);
      if(temp.i1==-1 || temp.i2 == -1) continue;
      trapped += (Math.min(blocks[temp.i1], blocks[temp.i2]) - blocks[i]) * (temp.i2-temp.i1-1);
    }
    return trapped;
  }

  public static void main(String[] args) {
    int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trapRain(arr));
  }
}
