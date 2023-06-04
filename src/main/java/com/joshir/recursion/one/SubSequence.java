package com.joshir.recursion.one;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
  public static void main(String[] args) {
    getSubSequence("abc").forEach(str-> System.out.println(str.isBlank()? "-":str));
  }

  @SuppressWarnings("all")
  public static List<String> getSubSequence(String str) {

    if(str.length() == 0) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }

    char first = str.charAt(0);
    List<String> newList = new ArrayList<>();

    getSubSequence(str.substring(1)).forEach( s -> {
      newList.add(first + s);
      newList.add("" + s);
    });

    return newList;
  }
}
