package joshir.slidingwindow;

public class SubstringsOfSizeThreeWithDistinctCharacters {

  public int countGoodSubstrings(String s) {
    int ans = 0;
    StringBuilder str = new StringBuilder(s);
    int len = str.length() - 3;
    for (int i = 0; i <= len; i++)
      if (str.charAt(i) != str.charAt(1+i) && str.charAt(1+i) != str.charAt(2+i) && str.charAt(2+i) != str.charAt(i))
        ans++;

    return ans;
  }
  public static void main(String[] args) {
    System.out.println(new SubstringsOfSizeThreeWithDistinctCharacters().countGoodSubstrings("aababcabc"));
  }
}
