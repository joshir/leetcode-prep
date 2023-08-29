package com.joshir.ll;

public class MergeTwoLists {

  class Solution {

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode pre = new ListNode(-1);
      ListNode temp = pre;

      while(list1 != null && list2 != null ) {
        if(list1.val <= list2.val) {
          temp.next = list1;
          list1 = list1.next;
        }else {
          temp.next = list2;
          list2 = list2.next;
        }
        temp = temp.next;
      }
      temp.next = (list1 == null)? list2: list1;

      return pre.next;
    }
  }
}
