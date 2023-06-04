package com.joshir.twoptr;

public class BuyAndSellStock {
  static class Window {
    int buy;
    int sell;
    Window(int b, int s) {
      this.buy = b;
      this.sell = s;
    }
  }

  public static Window maximizeProfit(int[] arr) {
    Window best = null;
    for(int s = 0, e = 1, curr = 0; e < arr.length; e++) {
      if(arr[s] < arr[e]){
        if(curr < arr[e] - arr[s]){
          curr= arr[e] - arr[s];
          best = new Window(s,e);
        }
      }
      else
        s = e; /* start catches up to end if arr[e] < arr[s] */
    }
    return best;
  }

  public static void main(String[] args) {
    Window p = maximizeProfit(new int[] {0,2,1,6,9,3,4,11});
    System.out.println("buy: "+ p.buy + " sell: " + p.sell);
  }
}
