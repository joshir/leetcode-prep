package com.joshir.ll;

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    if(head == null || head.next == null)
      return head;
    ListNode smaller = new ListNode(-1), greater = new ListNode(-1);
    ListNode current1 = smaller, current2 = greater;

    ListNode temp = head;
    while(temp != null) {
      if(temp.val < x) {
        current1.next = temp;
        current1 = current1.next;
      }
      else {
        current2.next = temp;
        current2 = current2.next;
      }
      temp = temp.next;
    }

    current2.next = null;
    current1.next = greater.next;
    return smaller.next;
  }
}
