package joshir.recursion.v19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class KeyPadCodes {
  private static final String[] phoneCodes = {
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

    String start = phoneCodes[str.charAt(0)-'0'];

    List<String> codes = getKeyPadCode(str.substring(1));
    //    Option 1
    //    List<String> newArr = new ArrayList<>();
    //
    //    for (int index =0; index < start.length(); index++) {
    //      char c = start.charAt(index);
    //      for (String code: codes) {
    //        newArr.add(c+code);
    //      }
    //    }

    // less readable but compact
    return start.chars()
      .mapToObj(c-> codes.stream().map(code -> (char)c + code))
        .flatMap(Stream::distinct)
        .toList();
  }
}
