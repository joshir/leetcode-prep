package joshir.stacks;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Brackets {
  static final LinkedList<Character> stack = new LinkedList<>();

  static final List<String> testSet = List.of(
    "()",
    "(w+x)+(y+z+)",
    "({[d]})",
    "a[{(s*s)+2^(1.5)]}");

  static final Map<Character, Character> reverse
    = Map.of('}','{',')','(', ']','[');

  static final Map<Character, Character> forward
    = Map.of('{', '}','(', ')', '[',']');

  public static boolean isBalanced(String str) {
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if(forward.containsKey(c))
        stack.add(c);
      else if(reverse.containsKey(c)){
        if(reverse.get(c) == stack.peekLast())
          stack.removeLast();
        else
          break;
      }
    }
    boolean res = stack.size()==0;
    stack.clear();
    return res;
  }

  public static boolean hasSuperfluous(String str) {
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if(reverse.containsKey(c)){
        if(stack.peekLast() == reverse.get(c)) {
          stack.clear();
          return true;
        }
        while(stack.size()>0 && stack.removeLast() != reverse.get(c)) ;
      }
      else
        stack.add(c);
    }
    stack.clear();
    return false;
  }

  public static void main(String[] args) {
    testSet.forEach(st->{
      System.out.println("balanced: "+ isBalanced(st));
      System.out.println("superfluous: "+ hasSuperfluous(st));
    });
  }
}
