package joshir.tree;

import java.util.List;

public class Common {

  /*
   * tree as a list with marker -1 to indicate
   * returning down the stack frame. other numbers mean
   * traverse up the stack until -1 is encountered
   * */

  public static final List<Integer> tree = List.of(
    10,
    30, 300, -1, 301, -1, -1,
    40, 400, -1, 401, -1, -1,
    50, 501, -1, 502, -1, 503, -1, 504, -1, -1,
    60, 601, 6001, -1, 6002, -1, -1, -1, -1
  );

  public static final List<Integer> mirror = List.of(
    1,
    2, 22, 2223, -1, 2224, -1, -1, -1,
    3, 33, -1, 34, -1, 35, -1, 36, -1, -1,
    4, 44, -1, 45, -1, -1,
    5, 55, -1, 56, -1, -1, -1
  );

  public static final List<Integer> symmetric = List.of(
    1,
    4, 44, -1, 45, -1, -1,
    3, 33, -1, 34, -1, 35, -1, 36, -1, -1,
    5, 55, -1, 56, -1, -1, -1
  );

  public static final List<Integer> bTree = List.of(
    10,
    30,
    300,
    3001, -1,
    3002, -1, -1,
    301, -1, -1,
    40,
    400, -1,
    401,
    4001, -1,
    4002, -1, -1, -1,
    -1
  );

  public static final List<Integer> bTree1 = List.of(
    10,-1
  );
}
