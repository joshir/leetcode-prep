package L1.recursion.v19;

public class KeyPadCodesTwo {
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
    getKeyPadCode("678", "");
  }

  public static void getKeyPadCode(String str, String result) {
    if (str.length() == 0) {
      System.out.println(result);
      return;
    }

    String start = phoneCodes[str.charAt(0)-'0'];
    for (int index = 0; index < start.length(); index++) {
      char codeStart = start.charAt(index);
      getKeyPadCode(str.substring(1),result +  codeStart);
    }

    /**
     *                                      678
     *                       p|         q|         r|        s|
     *                      78          78         78        78
     *                   t|    u|    t|    u|   t|    u|   t|   u|
     *                   8     8     8     8    8     8    8    8
     *                  |||   |||  |||    |||  |||     ...
     *                                      ...
     *
     */
  }
}
