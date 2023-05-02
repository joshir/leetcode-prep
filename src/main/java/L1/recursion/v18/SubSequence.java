package L1.recursion.v18;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
  public static void main(String[] args) {
    getSubSequence("abc").forEach(str->{
      System.out.println(str.isBlank()? "-":str);
    });
  }

  public static List<String> getSubSequence(String str) {

    if(str.length() == 0) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }

    char first = str.charAt(0);
    List<String> ss = getSubSequence(str.substring(1));
    List<String> newList = new ArrayList<>();
    for(int index = 0; index< ss.size() ; index++){
      newList.add(first + ss.get(index) );
      newList.add("" + ss.get(index));
    }
    return newList;
  }
}
