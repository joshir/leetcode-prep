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
        int digit = 0, number = 0, power = 0;
        while(!dq.isEmpty() && Character.isDigit(dq.peekLast())){
          digit = Character.getNumericValue(dq.removeLast());
          number += (int) Math.pow(10, power++) * digit;
        }

        ss.append(ss.reverse().toString().repeat(number - 1));

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