package joshir.stack;

import java.util.LinkedList;

class StockSpanner {

  static int spanCallCount = 0;

  static class Pair {
    int price;
    int index;
    Pair(int price, int index) {
      this.price = price;
      this.index = index;
    }
  }

  private static LinkedList<Pair>  stack = new LinkedList<>();

  public StockSpanner() {
    stack.add(new Pair( (int)Math.pow(10,5) + 1, -1));
  }

  public int next(int price) {
    Pair pair;
    for (pair = new Pair(price, spanCallCount++); stack.peekLast().price <= price; stack.removeLast()) ;
    int span = pair.index - stack.peekLast().index;
    stack.add(pair);
    return span;
  }
}