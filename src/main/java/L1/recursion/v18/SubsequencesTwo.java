package L1.recursion.v18;


import java.util.ArrayList;
import java.util.List;

public class SubsequencesTwo {
  public static void main(String[] args) {
    getSubSequence("abc", "");
  }

  public static void getSubSequence(String str, String ssf) {
    if(str.length() == 0){
      System.out.println(ssf);
      return;
    }
    char first = str.charAt(0);
    getSubSequence(str.substring(1), ssf + first);
    getSubSequence(str.substring(1), ssf + "");

    /*
    *                                   abc
    *                                /       \
    *                               /         \
    *                           bc,a          bc,""
    *                           /\            / \
    *                          /  \          /   \
    *                      c,ab     c,a      c,b    c,""
    *                     / \       /\      / \      /\
    *                    /   \     /  \    /   \    /  \
    *                  ,abc  ,ab  ,ac  ,a ,bc  ,b   ,c  ""
    * */



  }
}
