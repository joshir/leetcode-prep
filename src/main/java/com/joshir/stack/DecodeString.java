package com.joshir.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
  public String decodeString(String s) {
    Deque<Character> dq = new ArrayDeque<>();
    StringBuilder ss = null;

    int i = 0;
    do {
      dq.addLast(s.charAt(i));
      if(s.charAt(i) == ']'){
        ss = new StringBuilder();
        dq.removeLast();
        while(dq.peekLast()!='[')
          ss.append(dq.removeLast());

        dq.removeLast();
        ss.append(ss.reverse().toString().repeat(dq.removeLast() - '0' - 1));

        int n = 0;
        while(n < ss.length())
          dq.addLast(ss.charAt(n++));
      }
    } while(++i < s.length());

    ss = new StringBuilder();
    for(char c : dq)
      ss.append(c);

    return ss.toString();
  }
}