package com.joshir.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Brackets {

  /* package public by default */
  static final LinkedList<Character> stack = new LinkedList<>();  /* TODO replace with an indexed stack at some point*/

  /* test sets */
  static final List<String> testSet = List.of(
    "()",
    "(w+x)+(y+z+)",
    "({[d]})",
    "a[{(s*s)+2^(1.5)]}");

  /* reverse lookup */
  static final Map<Character, Character> reverse
    = Map.of('}','{',')','(', ']','[');

  /* forward lookup */
  static final Map<Character, Character> forward
    = Map.of('{', '}','(', ')', '[',']');

  /*
  * push forward brackets and remove reverse ones
  * remove so long as there is a matching forward
  * bracket on the stack.
  * */
  public static boolean isBalanced(String str) {
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if(forward.containsKey(c))
        stack.add(c);
      else if(reverse.containsKey(c)){   /* ignore numbers and such; we are only concerned with checking "bracket balance" */
        if(reverse.get(c) == stack.peekLast())
          stack.removeLast(); /* pop matching opening bracket, if it matches the corresponding forward bracket for current reverse bracket */
        else
          break;
      }
    }
    boolean res = stack.size()==0;
    stack.clear();
    return res;
  }

  /*
  * basic test for superfluous brackets is (), {}, or []
  * anything that occurs in between is either on the stack or
  * removed at some point
  * */
  public static boolean hasSuperfluous(String str) {
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if(reverse.containsKey(c)){
        if(stack.peekLast() == reverse.get(c)) {    /* if c == } and what's on top of the stack is {, you have extra brackets. */
          stack.clear();
          return true;
        }
        /* if c == } is not matched by { on tos, keep popping until a1. it's empty or a2. has a match for c */
        while(stack.size()>0 && stack.peekLast() != reverse.get(c))
          stack.removeLast();
      }
      else
        stack.add(c);
    }
    stack.clear();
    return false;
  }

  public static void main(String[] args) {
    testSet.forEach(st-> System.out.println(isBalanced(st)));
    testSet.forEach(st-> System.out.println(hasSuperfluous(st)));
  }
}
