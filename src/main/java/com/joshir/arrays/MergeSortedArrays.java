package com.joshir.arrays;

public class MergeSortedArrays {

  // with O(1) space. Using extra space makes this trivial
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-1, j = n-1;
    int k = m + n - 1; // first available space

    // three pointer
    while(j >= 0){
      if( i >= 0 && nums1[i] > nums2[j])
        nums1[k] = nums1[i--];
      else
        nums1[k] = nums2[j--];
      k--;
    }
  }
}
