package com.joshir.ll;

public class DeleteNodeInALL {
  class Solution{
    public void deleteNode(ListNode node) {
      ListNode next = node.next;
      node.val = next.val;
      node.next = next.next;
      next.next = null;
    }
  }
}
