package com.joshir.ll;

public class MaxTwinSum {
  private class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }
  public int pairSum(ListNode head) {
    if(head == null)
      return 0;
    int[] m = new int[100000];
    ListNode temp = head;
    int count = 0;
    while(temp != null){
      m[count++] = temp.val;
      temp = temp.next;
    }

    int max = Integer.MIN_VALUE;
    for(int i = 0; i <= (count-1)/2; i++ )
      max = Math.max( (m[i] + m[count - i - 1]), max);

    return max;
  }
}
