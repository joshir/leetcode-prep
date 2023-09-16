package com.joshir.trie;


public class MaxXorPair {
  class Solutions {
    private Trie root;
    static final class Trie {
      Trie zero;
      Trie one;
    }

    private int maxima (int n) {
      Trie cur = root;

      int max = 0, i = 32, bit = 0;
      while(--i >= 0) {
        bit = (n>>i) & 1;

        // greedy choice is to xor with opposite msb of n
        // so if bit is 1 choose trie.zero and if bit is 0 choose trie.one
        if(bit == 0) {
          if(cur.one != null){
            cur = cur.one;
            max += (1<<i);
          }
          else
            cur = cur.zero;
        }

        if(bit == 1) {
          if(cur.zero != null){
            cur = cur.zero;
            max += (1<<i);
          }
          else
            cur = cur.one;
        }
      }
      return max;
    }

    private void addNumber (int n) {
      Trie cur = root;

      int i = 32, bit;
      while (--i >= 0) {
        bit = (n>>i) & 1;

        if (bit == 0){
          if (cur.zero == null){
            cur.zero = new Trie();
          }
          cur = cur.zero;
        }else {
          if (cur.one == null){
            cur.one = new Trie();
          }
          cur = cur.one;
        }
      }
    }

    public int findMaximumXOR (int[] nums) {
      int res = Integer.MIN_VALUE;
      for (int x: nums) {
        addNumber(x);
        res = Math.min(res, maxima(x));
      }
      return res;
    }
  }
}
