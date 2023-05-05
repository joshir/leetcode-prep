package joshir.recursion.v23;

public class Perms {
  public static void main(String[] args) {
    permute("1234","");
  }

  public static void permute(String str, String ssf) {
    if(str.length()==0) {
      System.out.println(ssf);
      return;
    }

    for (int index = 0; index < str.length(); index++) {
      permute( str.substring(0,index) + str.substring(index+1), ssf + str.charAt(index));
    }
  }
}
