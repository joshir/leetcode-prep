package com.joshir.ll;

public class RemoveDuplicatesFromSortedLLII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode prevHead = new ListNode(0);
    prevHead.next = head;
    ListNode pred = prevHead;

    while (head != null) {
      if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        pred.next = head.next;
      } else {
        pred = pred.next;
      }

      head = head.next;
    }
    return prevHead.next;
  }

}