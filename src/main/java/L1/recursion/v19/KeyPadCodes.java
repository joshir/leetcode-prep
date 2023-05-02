package L1.recursion.v19;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCodes {
  private static String[] phoneCodes = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vqx",
    "yz"
  };
  public static void main(String[] args) {
    getKeyPadCode("678").forEach(System.out::println);
  }

  public static List<String> getKeyPadCode(String str) {
    if (str.length() == 0) {
      List<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }

    String start = phoneCodes[(int)(str.charAt(0)-'0')];

    List<String> codes = getKeyPadCode(str.substring(1));
    List<String> newArr = new ArrayList<>();

    for (int index =0; index < start.length(); index++) {
      char c = start.charAt(index);
      for (String code: codes) {
        newArr.add(c+code);
      }
    }
    return newArr;
  }
}
