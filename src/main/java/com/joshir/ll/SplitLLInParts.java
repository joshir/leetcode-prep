package com.joshir.ll;

public class SplitLLInParts {
  class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
      ListNode cur = head;
      int count = 0;
      for(; cur != null; count++)
        cur = cur.next;

      ListNode[] result = new ListNode[k];
      cur = head;
      for (int row = 0; row < k; ++row) {
        ListNode newhead = cur;
        for (int col = 0; col < count / k + (row <  count % k ? 1 : 0) - 1; ++col)
          if (cur != null)
            cur = cur.next;
        if (cur != null) {
          ListNode prev = cur;
          cur = cur.next;
          prev.next = null;
        }
        result[row] = newhead;
      }
      return result;
    }
  }
}
