package com.joshir.arrays;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int [] prods = new int[nums.length];
    int [] sdrops = new int[nums.length];
    int [] res = new int[nums.length];


    for(int x = 0; x < nums.length; x++){
      prods[x] = 1;
      sdrops[x] = 1;
    }

    int prod = 1;
    for(int i = 0; i < nums.length; i++){
      prod = prod * nums[i];
      prods[i] = prod;
    }

    prod = 1;
    for(int j = nums.length-1; j>=0; j--){
      prod = prod * nums[j];
      sdrops[j] = prod;
    }

    for (int k = 0; k < nums.length; k++){
      if(k == 0)
        res[k] = sdrops[1];
      else if(k == nums.length-1)
        res[k] = prods[k-1];
      else
        res[k] = prods[k-1] * sdrops[k+1];
    }

    return res;
  }
}
