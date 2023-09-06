package com.joshir.ll;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedLL {
  public ListNode deleteDuplicatesUnsorted(ListNode head) {
    Map<Integer, Integer> repeatedNodes = new HashMap<>();

    ListNode prevHead = new ListNode(-1);
    prevHead.next = head;
    ListNode curr = prevHead.next;
    while(curr != null) {
      repeatedNodes.put(curr.val, repeatedNodes.getOrDefault(curr.val, 0) + 1);
      curr=curr.next;
    }

    ListNode prev = prevHead;
    curr = prevHead.next;
    while(curr != null) {
      if(repeatedNodes.get(curr.val) > 1) {
        prev.next = curr.next;
        curr.next = null;
        curr = prev;
      }
      prev=curr;
      curr = curr.next;
    }

    return prevHead.next;
  }
}
