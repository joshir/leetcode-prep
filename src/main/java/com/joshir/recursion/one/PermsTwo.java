package com.joshir.recursion.one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PermsTwo {
  public static void main(String[] args) {
    List<String> arr = new ArrayList<>();
    permute("1234","", arr);
    arr.forEach(System.out::println);
  }

  /* side effect */
  public static void permute(String str, String ssf, List<String> res) {
    if(str.length() == 0) {
      res.add(ssf);
      return;
    }
    StringBuilder sbr = new StringBuilder();
    IntStream.range(0, str.length())
      .forEach(
        index-> {
          permute( sbr.append(str.substring(0,index)).append( str.substring(index+1)).toString(), ssf + str.charAt(index), res);
          sbr.setLength(0);
        }
      );
  }
}
