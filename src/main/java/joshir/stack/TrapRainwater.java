package joshir.stack;

import java.util.LinkedList;

public class TrapRainwater {

  private static final LinkedList<Integer> stack = new LinkedList<>();

  public static int trapRain(int[] blocks) {
    stack.add(0);
    int trapped = 0;
    for(int i = 1, curr = 0; i < blocks.length; i++) {
      while(!stack.isEmpty() && blocks[i] >= blocks[stack.peekLast()]){
        curr = blocks[stack.removeLast()];
        if(stack.isEmpty()) break;
        /* trapped[i] = min(left block, right block) * width - curr * width */
        trapped += (Math.min(blocks[stack.peekLast()], blocks[i]) - curr) * (i-stack.peekLast()-1);
      }
      stack.add(i);
    }
    return trapped;
  }

  public static void main(String[] args) {
    int[] arr = {0,1,2,3,4,5};
    System.out.println(trapRain(arr));
  }
}
