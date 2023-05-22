package joshir.twoptr;

public class BuyAndSellStock {

  static class Pair {

    int buy;

    int sell;

    Pair(int b, int s) {
      this.buy = b;
      this.sell = s;
    }
  }

  public static Pair maximizeProfit(int[] arr) {
    Pair profit = null;
    for(int s = 0, e = 1, curr = 0; e < arr.length; e++) {
      if(arr[s] < arr[e]){
        if(curr < arr[e] - arr[s]){
          curr= arr[e] - arr[s];
          profit = new Pair(s,e);
        }
      }
      else
        s = e; /* start catches up to end if arr[e] < arr[s] */
    }
    return profit;
  }

  public static void main(String[] args) {
    Pair p = maximizeProfit(new int[] {0,2,1,6,9,3,4,11});
    System.out.println("buy: "+ p.buy + " sell: " + p.sell);
  }
}
