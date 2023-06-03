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

  public static final List<Integer> megaTree = List.of(
    3,4,5,9,1,8,3,3,5,5,6,0,6,0,7,-1,2,6,1,-1,8,
    5,4,6,7,9,1,0,2,1,5,-1,2,-1,5,2,3,-1,1,4,3,8,5,-1,
    4,2,3,5,6,0,5,7,4,8,4,6,9,1,1,3,9,-1,6,-1,5,1,8,-1,
    0,-1,9,9,3,-1,1,6,0,-1,9,-1,0,8,6,0,5,0,4,-1,0,
    7,0,-1,8,2,1,5,2,1,4,9,9,9,7,2,3,6,2,-1,-1,7,8,-1,
    3,-1,8,-1,1,9,8,-1,2,7,7,8,6,9,6,-1,-1,5,3,5,1,
    -1,2,4,0,5,8,-1,2,-1,8,-1,0,-1,9,1,1,-1,6,1,0,
    5,5,-1,0,-1,0,3,1,-1,-1,4,4,-1,4,9,9,-1,7,4,3,
    -1,7,8,4,-1,3,1,1,7,6,2,8,-1,-1,-1,1,-1,9,-1,
    8,-1,4,-1,1,9,6,-1,1,-1,-1,0,4,-1,-1,-1,8,
    -1,-1,1,3,-1,2,-1,7,9,5,3,9,-1,-1,-1,-1,-1,
    8,-1,-1,-1,6,9,6,-1,-1,-1,6,5,4,-1,0,4,8,6,5,
    -1,3,7,4,5,2,7,9,-1,6,3,0,-1,5,7,6,-1,3,4,8,-1,7,
    0,9,8,5,-1,8,-1,1,2,5,-1,1,-1,4,4,4,-1,3,-1,9,3,
    0,8,7,4,2,4,1,9,3,-1,0,-1,2,-1,4,-1,-1,-1,1,-1,
    -1,0,1,-1,5,-1,-1,-1,6,-1,9,-1,6,4,4,-1,1,8,
    8,-1,0,7,2,4,0,8,9,-1,6,7,9,5,7,4,1,-1,0,-1,-1,-1,
    9,-1,6,-1,0,-1,4,-1,3,1,6,1,3,-1,6,6,2,9,7,3,8,7,6,
    5,3,-1,-1,-1,-1,-1,4,-1,4,-1,-1,9,3,-1,-1,
    -1,4,6,3,-1,2,-1,7,-1,5,7,6,4,4,-1,-1,-1,2,-1,
    9,1,9,3,4,0,6,-1,3,3,9,-1,6,-1,0,-1,9,-1,9,-1,-1,
    5,8,2,2,8,6,-1,7,9,0,1,7,4,4,-1,4,-1,8,-1,0,-1,-1,
    -1,3,-1,7,-1,8,-1,3,-1,7,-1,9,-1,6,6,2,-1,2, -1,
    7,3,2,-1,5,-1,7,6,7,9,5,0,7,-1,0,5,6,-1,2,-1,-1,1,5,
    -1,-1,-1,9,3,0,9,2,-1,6,-1,4,-1,1,1,8,9,7,-1,8,-1,
    5,1,7,-1,-1,6,7,-1,8,-1,9,5,9,-1,9,1,9,-1,0,0,8,-1,
    2,5,8,7,8,9,6,-1,9,-1,3,-1,4,8,2,-1,-1,-1,7,-1,9,
    -1,5,-1,-1,-1,4,-1,1,3,4,1,8,4,5,-1,0,-1,9,-1,3,
    4,6,-1,3,9,9,-1,-1,0,6,2,5,5,1,2,2,-1,6,-1,-1,-1,
    8,9,0,-1,0,9,8,-1,-1,2,0,8,2,1,3,-1,2,-1,9,2,0,-1,
    6,5,9,8,5,8,5,-1,6,-1,0,-1,-1,-1,-1,2,1,-1,-1,
    -1,7,-1,8,-1,-1,-1,0,-1,2,4,3,-1,6,-1,-1,-1,
    -1,6,0,-1,3,-1,4,-1,-1,5,1,-1,-1,-1,2,-1,2,
    4,3,0,8,5,5,9,0,-1,1,-1,-1,-1,6,-1,2,-1,-1,-1,
    0,-1,5,8,4,-1,0,-1,8,-1,8,-1,-1,-1,2,-1,8,6,1,-1,
    5,2,4,-1,0,9,0,-1,-1,-1,5,-1,1,-1,5,-1,8,7,5,
    -1,-1,-1,-1,-1,4,-1,4,-1,7,6,5,-1,-1,-1,
    8,3,5,-1,1,3,5,-1,5,2,1,-1,3,-1,-1,-1,1,-1,3,7,4,
    -1,-1,-1,0,-1,-1,3,5,-1,7,-1,4,9,4,-1,-1,2,
    4,2,2,8,3,-1,4,-1,-1,-1,0,-1,-1,5,6,-1,-1,-1,
    -1,-1,8,-1,4,7,6,-1,-1,-1,5,-1,-1,-1,7,-1,
    0,2,2,-1,4,-1,4,-1,6,0,4,-1,4,-1,1,-1,7,-1,3,-1,
    7,1,9,-1,4,6,5,9,0,-1,7,-1,1,-1,2,9,4,2,4,-1,2,7,7,
    -1,3,3,0,9,4,6,5,-1,-1,-1,-1,-1,9,2,5,-1,5,-1,
    -1,-1,1,-1,-1,-1,2,1,5,-1,-1,-1,4,3,7,-1,4,
    -1,8,-1,7,9,4,-1,8,-1,3,-1,5,2,0,-1,0,7,6,-1,6,8,
    4,9,1,9,2,-1,-1,-1,6,-1,3,-1,4,-1,1,-1,3,2,7,-1,0,
    -1,2,-1,-1,-1,0,-1,0,-1,7,2,3,-1,3,-1,-1,-1,9,
    -1,0,-1,-1,3,4,-1,7,-1,-1,-1,4,-1,0,9,1,0,7,6,2,
    -1,-1,-1,2,-1,6,9,6,-1,1,-1,3,-1,6,-1,6,-1,6,
    -1,2,3,8,6,9,8,8,-1,3,-1,7,6,5,-1,8,2,3,6,8,-1,3,1,7,
    -1,0,-1,4,-1,0,5,4,-1,2,4,1,-1,7,9,8,8,5,5,6,-1,-1,
    -1,-1,-1,6,-1,9,-1,8,-1,-1,-1,3,-1,9,1,4,-1,1,
    -1,-1,2,5,9,0,-1,2,-1,-1,-1,9,-1,4,6,5,-1,-1,
    -1,0,-1,8,-1,-1,9,4,-1,-1,-1,2,4,4,-1,9,2,6,2,4,
    2,9,-1,0,-1,7,-1,1,-1,-1,6,2,-1,-1,7,5,0,3,0,2,6,1,
    -1,8,-1,-1,1,9,-1,9,6,8,6,1,2,2,-1,-1,-1,-1,-1,
    3,-1,4,-1,-1,-1,7,-1,1,-1,6,-1,3,-1,7,3,8,-1,4,
    -1,6,-1,0,-1,0,9,6,-1,2,-1,3,-1,-1,-1,4,3,0,-1,
    -1,2,2,2,8,-1,0,-1,2,8,8,-1,0,5,3,8,9,2,5,-1,7,3,5,-1,
    2,-1,2,-1,-1,-1,7,0,5,-1,4,-1,0,-1,0,-1,5,-1,6,
    -1,4,5,1,-1,-1,-1,2,-1,1,-1,-1,6,5,-1,3,-1,7,
    -1,1,-1,-1,-1,9,-1,1,7,6,-1,-1,-1,3,-1,9,-1,
    2,-1,7,-1,2,-1,0,-1,5,6,7,-1,9,-1,1,0,9,-1,-1,-1,
    0,-1,2,7,0,-1,1,0,3,-1,-1,-1,-1,-1,-1,-1,0,-1,
    2,-1,-1,2,1,-1,-1,-1,1,-1,5,-1,-1,0,5,-1,8,-1,
    9,-1,4,-1,0,-1,1,-1,6,-1,0,7,9,-1,-1,-1,4,7,2,-1,
    3,7,3,-1,0,5,9,-1,-1,-1,7,-1,4,-1,2,9,7,-1,-1,4,4,
    -1,4,-1,-1,-1,1,-1,-1,0,6,-1,-1,-1,1,-1,1,-1,
    -1,-1,8,-1,2,2,2,-1,2,3,1,-1,0,-1,6,0,7,-1,7,-1,0,
    5,8,-1,1,9,0,0,2,3,5,-1,3,-1,6,-1,6,-1,9,5,6,-1,-1,
    0,6,-1,-1,-1,0,-1,3,-1,3,0,6,5,2,-1,6,2,3,1,6,-1,1,
    -1,6,-1,2,3,8,0,8,1,6,0,4,-1,5,-1,-1,-1,-1,-1,-1,
    3,9,-1,-1,-1,-1,-1,-1,3,3,-1,0,-1,2,-1,2,-1,-1,
    -1,3,9,4,-1,6,-1,8,-1,2,-1,5,2,8,-1,-1,-1,0,-1,
    3,7,6,-1,-1,-1,1,-1,1,0,0,-1,5,-1,4,6,9,6,4,7,8,1,9,7,3,
    -1,9,-1,-1,-1,9,-1,8,-1,3,-1,8,-1,7,1,7,-1,4,-1,
    -1,-1,-1,-1,9,-1,0,-1,-1,-1,7,-1,8,-1,9,-1,1,
    -1,5,-1,9,-1,6,-1,8,-1,-1,-1,8,-1,4,-1,2,8,5,-1,
    9,-1,7,-1,6,-1,5,7,8,-1,3,-1,-1,-1,2,5,7,-1,1,-1,4,
    -1,0,0,3,3,0,-1,-1,-1,-1,6,3,-1,6,-1,1,3,4,-1,2,-1,
    -1,-1,-1,8,3,-1,0,-1,-1,-1,7,9,6,-1,8,-1,-1,-1,
    -1,-1,9,6,0,-1,-1,-1,5,-1,6,8,1,-1,-1,-1,7,9,0,-1,
    4,-1,2,4,7,4,3,-1,7,6,8,-1,7,-1,2,-1,-1,-1,0,1,5,-1,
    -1,-1,1,-1,7,-1,7,-1,6,6,8,-1,-1,-1,1,8,1,-1,4,-1,
    1,0,0,-1,-1,-1,2,3,7,-1,1,-1,0,-1,8,-1,3,-1,-1,-1,
    4,-1,-1,1,8,-1,8,-1,0,-1,1,-1,8,9,2,4,8,9,6,-1,-1,-1,
    -1,-1,2,-1,4,-1,3,0,3,-1,-1,-1,7,9,0,-1,5,-1,7,5,0,4,
    8,7,8,7,7,-1,5,-1,-1,-1,5,-1,8,9,2,2,2,-1,9,9,0,-1,0,6,2,
    7,9,-1,9,-1,1,5,7,0,5,7,8,-1,7,-1,4,-1,2,-1,-1,4,3,-1,7,
    -1,-1,-1,5,-1,9,-1,3,-1,2,-1,2,-1,-1,-1,5,-1,6,-1,
    -1,8,2,-1,4,-1,5,1,1,-1,5,-1,0,-1,0,-1,8,7,8,-1,-1,-1,
    3,-1,8,5,5,-1,-1,-1,1,-1,3,-1,8,3,4,9,3,7,6,8,4,-1,4,-1,2,
    -1,0,-1,-1,-1,1,-1,-1,-1,-1,6,9,-1,-1,-1,0,-1,1,
    -1,-1,2,9,-1,2,-1,3,-1,3,3,2,-1,6,-1,8,-1,8,-1,6,-1,
    4,-1,8,1,2,-1,6,-1,-1,-1,0,-1,1,-1,3,-1,0,-1,-1,-1,
    -1,-1,-1,3,4,-1,1,-1,0,-1,-1,-1,5,7,6,-1,-1,-1,1,-1,
    4,7,9,2,5,-1,2,6,0,1,5,-1,7,-1,-1,1,0,-1,0,-1,6,-1,9,0,4,-1,
    7,-1,2,-1,2,-1,5,-1,9,-1,7,-1,4,7,4,-1,9,-1,-1,-1,3,-1,
    -1,-1,7,-1,5,5,0,-1,-1,4,1,7,8,9,3,1,0,-1,5,-1,1,-1,-1,-1,
    -1,-1,9,6,5,-1,8,-1,0,-1,7,-1,6,9,4,-1,-1,-1,-1,3,6,-1,
    1,-1,9,-1,0,0,4,-1,1,-1,5,-1,8,-1,3,0,5,-1,8,-1,3,-1,0,-1,
    -1,6,0,-1,1,-1,2,8,8,-1,1,-1,6,4,0,-1,8,1,8,6,8,6,9,-1,-1,-1,
    7,-1,-1,-1,-1,7,9,-1,0,-1,7,-1,4,-1,-1,1,4,-1,-1,6,8,-1,
    7,5,8,-1,1,6,6,7,4,2,0,-1,2,-1,7,9,2,-1,2,-1,6,-1,-1,-1,7,-1,
    7,-1,-1,2,4,-1,2,-1,2,6,4,-1,5,7,9,1,6,-1,6,4,3,9,1,-1,0,7,9,
    6,1,9,3,-1,6,-1,-1,9,9,-1,-1,3,0,-1,5,-1,-1,-1,-1,-1,
    -1,2,3,-1,3,-1,2,-1,5,-1,0,6,2,-1,2,-1,-1,-1,-1,-1,8,
    1,8,-1,5,-1,3,-1,3,-1,8,5,0,-1,-1,-1,6,-1,1,2,0,-1,2,-1,
    0,3,9,-1,-1,-1,2,-1,2,3,8,-1,8,4,4,-1,6,5,5,-1,-1,-1,2,
    -1,3,-1,-1,-1,5,0,8,-1,-1,-1,-1,-1,3,-1,9,-1,-1,
    -1,-1,-1,-1,-1,-1,3,9,-1,2,-1,5,-1,6,-1,4,-1,-1,
    -1,-1,-1,0,8,7,-1,5,-1,5,-1,9,-1,2,-1,1,-1,-1,2,9,-1,
    -1,-1,-1,-1,-1,-1,-1,7,1,-1,0,-1,0,-1,7,3,9,-1,6,8,1,
    -1,6,-1,6,5,5,6,8,7,6,-1,-1,-1,3,-1,6,-1,8,-1,1,-1,-1,
    -1,-1,-1,2,-1,2,-1,9,-1,-1,9,0,-1,3,0,3,-1,4,-1,6,7,2,
    -1,-1,-1,1,-1,3,-1,-1,-1,4,9,7,-1,5,3,3,-1,4,0,3,-1,9,
    4,8,-1,5,4,1,-1,7,-1,8,4,0,-1,-1,-1,0,-1,-1,-1,9,-1,-1,
    -1,9,-1,-1,9,7,-1,-1,8,7,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,
    -1,3,-1,-1,6,3,-1,0,-1,-1,-1,8,-1,0,4,5,-1,-1,-1,4,-1,2,
    -1,7,-1,-1,-1,6,4,3,-1,-1,-1,8,-1,4,5,3,-1,-1,-1,2,3,1,-1,
    7,-1,2,-1,8,7,9,-1,-1,-1,-1,-1,7,-1,1,-1,6,8,3,-1,-1,-1,
    6,-1,-1,-1,5,-1,3,-1,8,5,5,-1,9,8,8,1,6,-1,6,9,9,3,0,0,9,-1,4,-1,
    9,-1,-1,-1,9,4,6,4,2,-1,6,-1,-1,6,4,0,6,-1,1,-1,-1,-1,2,5,4,
    -1,2,-1,8,0,6,-1,0,7,5,-1,8,-1,-1,1,6,-1,9,2,8,-1,0,1,6,5,9,-1,
    8,-1,3,2,1,5,9,1,1,-1,-1,-1,8,-1,-1,-1,0,-1,-1,-1,-1,6,5,-1,
    2,-1,-1,-1,-1,-1,-1,-1,0,4,6,-1,2,-1,0,-1,-1,-1,4,-1,-1,
    -1,7,-1,0,-1,-1,3,0,4,5,-1,0,-1,6,-1,6,0,7,-1,4,-1,0,-1,3,7,2,
    -1,5,-1,5,-1,4,3,6,-1,7,-1,1,7,2,0,0,4,4,6,9,-1,1,-1,4,-1,5,-1,4,
    -1,9,-1,7,4,2,-1,1,4,5,-1,-1,-1,7,-1,0,-1,-1,-1,9,-1,1,5,3,
    -1,8,-1,7,-1,-1,-1,7,8,1,-1,-1,9,6,-1,9,4,6,-1,4,-1,5,-1,-1,
    -1,7,0,0,-1,7,-1,4,-1,8,6,4,-1,8,-1,7,4,1,-1,0,4,9,-1,8,8,5,-1,5,
    -1,3,-1,1,-1,6,7,7,-1,2,-1,-1,-1,-1,3,4,-1,-1,-1,-1,-1,6,
    -1,7,-1,-1,-1,8,2,7,4,7,-1,8,-1,3,-1,0,3,1,-1,-1,-1,6,-1,7,
    -1,-1,-1,0,-1,2,-1,9,-1,5,8,5,-1,1,2,5,1,9,-1,3,-1,9,-1,-1,
    -1,0,-1,8,-1,6,-1,8,-1,5,1,7,-1,-1,0,3,-1,8,-1,3,-1,8,0,9,
    -1,8,-1,8,-1,8,-1,3,4,7,-1,-1,1,7,-1,1,-1,-1,-1,-1,0,0,-1,
    -1,-1,7,-1,-1,9,2,-1,8,-1,0,4,5,-1,1,4,0,-1,0,8,5,0,6,-1,1,-1,
    0,-1,7,-1,-1,9,5,0,7,4,6,-1,5,-1,9,-1,0,3,6,-1,4,-1,-1,-1,6,
    -1,1,9,7,-1,2,-1,-1,0,4,-1,4,8,1,0,9,1,4,-1,5,-1,3,-1,3,-1,-1,
    -1,9,-1,1,3,4,-1,1,-1,-1,-1,0,-1,8,7,0,-1,-1,-1,-1,-1,-1,
    -1,6,-1,-1,-1,-1,-1,9,-1,6,8,5,-1,1,8,6,-1,3,-1,-1,-1,1,-1,
    0,-1,9,1,1,-1,1,-1,8,4,3,6,4,4,6,-1,-1,-1,2,9,3,8,4,5,8,5,5,-1,-1,
    -1,3,-1,5,-1,1,-1,-1,-1,3,-1,0,-1,5,-1,-1,5,5,-1,3,-1,0,2,5,
    -1,-1,-1,5,-1,-1,-1,6,-1,9,9,4,-1,-1,-1,1,-1,1,-1,3,5,7,-1,
    7,-1,1,-1,-1,-1,7,-1,9,-1,5,-1,-1,-1,-1,-1,3,9,9,-1,3,-1,1,
    -1,2,5,7,-1,2,1,9,-1,-1,4,0,0,7,1,3,-1,7,-1,0,-1,3,-1,-1,7,2,-1,
    -1,-1,7,-1,9,-1,-1,-1,-1,-1,2,-1,-1,-1,5,-1,9,-1,9,-1,0,
    4,7,-1,-1,-1,-1,-1,7,-1,-1,0,3,-1,-1,6,7,-1,7,-1,4,5,9,-1,9,
    -1,4,-1,6,-1,3,-1,7,-1,8,-1,-1,-1,0,-1,-1,-1,1,-1,7,-1,8,
    -1,7,8,6,7,6,-1,4,6,7,-1,1,1,1,2,5,-1,-1,5,3,-1,8,-1,1,-1,-1,2,9,
    -1,4,-1,2,7,6,-1,9,-1,2,-1,-1,-1,-1,-1,2,-1,-1,-1,6,-1,2,
    -1,-1,-1,-1,-1,2,7,4,-1,1,7,7,-1,7,7,7,-1,5,-1,0,-1,6,-1,8,-1,
    2,-1,-1,1,2,3,1,6,2,-1,1,-1,-1,-1,5,-1,1,-1,-1,-1,1,7,8,-1,8,0,
    5,-1,-1,-1,3,7,1,-1,-1,-1,-1,-1,9,9,1,-1,-1,-1,8,-1,-1,-1,
    4,-1,-1,-1,0,-1,-1,-1,3,-1,4,-1,-1,3,3,-1,-1,-1,-1,0,5,-1,
    6,-1,6,-1,5,0,2,-1,0,-1,8,-1,3,-1,-1,-1,5,8,5,-1,5,-1,0,2,2,-1,
    3,-1,-1,-1,-1,8,3,-1,9,-1,2,-1,-1,-1,6,-1,6,-1,3,-1,-1,-1,
    3,7,7,-1,9,-1,2,-1,6,-1,6,5,0,-1,3,-1,8,-1,8,-1,3,-1,3,7,8,-1,-1,
    4,9,7,9,9,4,-1,-1,-1,8,-1,8,-1,9,-1,9,-1,6,4,8,-1,1,8,7,-1,7,-1,
    1,2,0,-1,8,-1,-1,4,0,-1,-1,-1,8,-1,7,-1,6,6,4,-1,1,-1,6,-1,4,
    7,8,0,9,6,1,7,5,-1,-1,-1,2,8,5,-1,0,2,0,-1,8,3,8,5,9,-1,-1,-1,2,6,5,
    2,5,0,7,7,6,6,2,1,1,-1,3,-1,0,-1,3,0,3,-1,-1,-1,-1,-1,9,-1,9,-1,
    7,-1,4,-1,1,8,1,-1,1,8,4,-1,7,-1,-1,9,6,-1,-1,-1,1,-1,0,-1,4,
    5,2,-1,7,-1,-1,-1,8,2,0,-1,3,-1,1,-1,6,7,5,-1,7,-1,-1,-1,3,
    -1,4,1,0,-1,0,-1,5,8,2,-1,8,3,0,-1,0,1,5,0,0,0,7,-1,-1,-1,-1,-1,
    -1,-1,5,6,5,-1,-1,-1,0,-1,7,-1,-1,-1,2,-1,5,-1,-1,-1,-1,
    2,9,-1,-1,-1,-1,-1,4,-1,-1,-1,3,-1,-1,-1,-1,-1,8,-1,4,
    -1,4,-1,5,-1,-1,-1,-1,4,9,-1,-1,-1,9,-1,6,-1,-1,-1,6,-1,
    6,-1,-1,1,9,-1,-1,-1,3,-1,9,-1,-1,5,9,-1,2,-1,-1,2,9,5,1,4,4,
    -1,1,5,9,-1,0,-1,4,-1,5,2,0,-1,-1,-1,1,-1,4,5,8,-1,2,-1,-1,0,1,
    -1,6,-1,-1,-1,5,-1,1,8,3,-1,-1,-1,2,8,7,-1,-1,-1,-1,-1,1,
    -1,-1,-1,5,-1,6,-1,1,-1,6,-1,-1,5,2,-1,-1,4,6,-1,8,0,6,-1,6,
    -1,1,-1,5,-1,-1,-1,-1,-1,9,-1,9,-1,1,-1,3,-1,2,-1,3,3,6,-1,
    -1,-1,-1,3,7,-1,2,-1,8,2,4,8,1,-1,7,-1,-1,-1,9,-1,-1,-1,8,-1,
    -1,-1,3,-1,9,-1,-1,-1,3,-1,-1,-1,-1,-1,9,-1,8,-1,-1,-1,7,
    -1,4,3,3,-1,-1,-1,3,-1,2,-1,-1,2,9,-1,-1,9,8,-1,3,-1,8,-1,6,
    -1,3,-1,9,1,4,-1,7,-1,7,-1,4,-1,9,-1,3,2,0,-1,1,-1,4,4,5,-1,0,
    -1,8,-1,2,3,5,-1,-1,7,4,-1,4,-1,9,-1,8,9,7,-1,0,-1,4,-1,0,-1,
    -1,-1,1,-1,-1,8,3,-1,8,-1,-1,-1,9,-1,0,-1,-1,-1,9,2,4,
    -1,3,-1,1,1,3,-1,4,-1,1,-1,4,1,5,1,6,-1,4,-1,7,2,1,-1,-1,-1,2,
    -1,-1,-1,9,-1,8,-1,2,-1,-1,-1,7,-1,-1,-1,3,3,3,-1,7,-1,
    2,0,3,-1,2,1,6,0,5,-1,-1,-1,9,5,8,-1,-1,4,2,0,5,7,2,-1,-1,9,4,
    2,5,7,9,-1,0,0,8,7,2,2,3,-1,3,-1,9,-1,-1,-1,-1,9,0,-1,4,5,2,-1,
    -1,-1,0,-1,2,-1,0,4,5,-1,-1,-1,-1,-1,3,-1,4,-1,0,-1,3,-1,
    5,-1,3,-1,3,-1,0,4,6,-1,-1,-1,6,-1,5,-1,1,-1,2,-1,1,-1,7,
    -1,-1,-1,0,-1,8,-1,5,2,8,-1,9,8,0,-1,9,2,8,0,3,9,2,-1,9,-1,-1,
    -1,7,-1,-1,-1,-1,0,9,-1,5,-1,1,-1,5,9,4,-1,9,-1,4,1,0,-1,7,3,
    2,-1,3,-1,-1,-1,-1,9,2,-1,5,-1,1,-1,8,-1,0,-1,3,-1,-1,-1,
    9,-1,1,8,7,-1,2,-1,-1,-1,-1,-1,-1,-1,7,-1,5,-1,9,-1,-1,
    8,0,-1,3,-1,-1,1,0,-1,1,-1,0,6,5,5,8,-1,-1,-1,2,-1,0,-1,-1,-1,
    -1,-1,8,-1,5,4,5,-1,4,-1,8,-1,-1,-1,7,-1,5,-1,9,7,1,7,5,-1,4,
    -1,0,-1,3,9,3,-1,-1,-1,-1,2,2,-1,3,-1,-1,-1,0,8,0,-1,8,-1,9,
    2,0,-1,-1,2,7,-1,6,9,1,9,8,-1,-1,-1,5,-1,-1,-1,1,-1,2,-1,9,2,0,
    -1,3,-1,-1,-1,-1,-1,2,-1,3,7,9,-1,-1,-1,-1,-1,2,-1,1,-1,
    -1,-1,6,-1,-1,8,5,-1,0,-1,1,-1,-1,0,1,-1,9,-1,-1,-1,1,-1,-1,
    -1,3,3,7,-1,6,-1,5,-1,-1,-1,4,-1,-1,-1,5,-1,4,-1,8,-1,-1,-1,
    2,-1,5,-1,8,2,6,-1,5,-1,-1,-1,-1,-1,6,-1,0,-1,2,9,2,-1,2,-1,
    -1,-1,0,0,4,-1,1,-1,2,-1,-1,-1,8,7,9,-1,2,3,4,-1,-1,-1,2,9,3,-1,
    3,0,0,-1,-1,-1,0,-1,3,-1,4,-1,-1,5,2,-1,7,-1,1,-1,2,-1,1,-1,4,
    1,4,-1,7,-1,-1,-1,-1,-1,5,-1,1,-1,7,-1,0,-1,2,-1,0,-1,5,8,0,-1,
    4,-1,7,-1,0,-1,2,-1,4,7,2,-1,8,-1,3,-1,7,-1,6,-1,3,0,4,-1,0,-1,9,
    -1,3,0,7,-1,3,-1,8,-1,4,-1,9,0,9,1,6,-1,7,7,2,-1,7,0,1,-1,-1,-1,2,
    1,1,5,2,-1,-1,-1,8,-1,-1,6,7,-1,9,0,6,-1,4,-1,1,1,5,-1,0,0,5,2,2,8,2,
    -1,8,-1,9,-1,-1,0,1,-1,-1,-1,8,9,4,-1,4,-1,-1,-1,6,-1,-1,1,2,
    -1,1,-1,1,1,3,4,9,-1,0,-1,-1,-1,-1,-1,-1,-1,0,1,2,-1,4,-1,7,7,5,
    -1,-1,-1,8,-1,8,0,6,-1,-1,-1,-1,-1,-1,-1,3,-1,9,-1,-1,-1,0,
    -1,-1,-1,-1,5,4,-1,-1,-1,1,-1,-1,1,0,-1,8,5,0,-1,-1,-1,4,-1,
    -1,8,5,-1,4,-1,0,7,0,-1,-1,-1,0,-1,-1,3,5,-1,3,-1,-1,-1,2,-1,
    -1,-1,6,-1,2,-1,2,-1,8,-1,-1,-1,1,-1,4,-1,-1,4,2,-1,-1,-1,3,
    5,3,5,8,-1,6,-1,6,-1,9,0,0,-1,8,-1,7,3,2,-1,3,5,5,-1,6,-1,9,4,1,8,3,-1,
    -1,-1,8,-1,-1,-1,2,-1,5,-1,8,-1,-1,-1,-1,-1,2,-1,-1,-1,1,
    -1,-1,5,2,-1,-1,-1,7,-1,0,-1,3,-1,2,-1,-1,-1,2,-1,-1,-1,3,
    -1,2,-1,-1,-1,-1,8,4,-1,5,-1,-1,-1,-1,8,8,-1,-1,3,0,2,9,-1,
    -1,-1,6,-1,1,8,2,-1,-1,-1,2,-1,7,-1,2,-1,1,1,1,-1,2,7,7,-1,-1,
    -1,-1,9,2,-1,7,0,7,-1,5,-1,8,-1,3,-1,9,-1,-1,-1,-1,4,8,-1,1,
    8,3,-1,3,-1,9,6,8,-1,3,-1,-1,-1,7,-1,1,-1,-1,-1,-1,-1,0,-1,
    1,-1,9,-1,-1,5,4,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,1,2,-1,1,-1,
    -1,-1,8,3,4,-1,5,-1,8,-1,2,-1,-1,5,8,-1,-1,-1,-1,-1,7,-1,5,
    -1,4,-1,7,-1,3,3,3,-1,0,-1,2,-1,-1,-1,3,-1,3,-1,7,-1,-1,-1,
    8,-1,-1,-1,9,-1,-1,-1,0,-1,0,-1,0,-1,7,-1,4,-1,-1,-1,1,-1,
    -1,-1,2,-1,8,-1,3,0,9,-1,-1,-1,-1,-1,-1,9,7,-1,8,-1,9,-1,4,
    -1,3,5,6,-1,0,-1,3,-1,2,-1,-1,1,0,-1,6,-1,3,-1,1,-1,1,-1,0,-1,
    3,-1,2,-1,7,-1,-1,0,0,4,7,-1,-1,-1,8,-1,1,-1,7,2,4,-1,-1,-1,
    -1,-1,8,-1,7,-1,4,0,3,-1,7,8,6,-1,3,-1,-1,6,3,-1,8,-1,8,2,0,-1,
    8,4,9,-1,8,0,4,-1,5,-1,9,4,6,-1,5,9,8,6,7,3,2,-1,7,-1,0,-1,-1,-1,5,
    -1,-1,-1,-1,3,3,-1,-1,-1,4,-1,-1,3,1,-1,6,-1,8,-1,-1,4,2,
    -1,8,1,0,-1,6,-1,-1,-1,-1,6,8,-1,5,-1,9,-1,1,3,6,-1,-1,-1,
    -1,-1,7,2,6,-1,1,-1,4,2,6,-1,-1,-1,1,-1,7,-1,9,5,9,-1,1,-1,3,
    0,3,1,7,-1,-1,4,8,-1,5,6,8,-1,7,6,9,-1,-1,-1,6,2,4,-1,0,-1,7,-1,
    2,7,7,8,9,-1,6,6,7,-1,-1,-1,-1,-1,7,-1,4,-1,-1,-1,5,-1,-1,-1,
    6,-1,0,-1,3,-1,1,-1,4,-1,0,-1,8,-1,-1,-1,-1,5,4,-1,2,-1,5,-1,
    2,-1,-1,3,4,-1,2,2,1,-1,2,7,8,9,2,-1,-1,-1,-1,3,7,-1,4,-1,-1,-1,
    0,9,3,2,2,-1,-1,-1,5,-1,-1,4,8,-1,9,-1,0,-1,7,0,2,-1,-1,-1,-1,
    -1,7,-1,-1,-1,1,-1,-1,3,1,-1,2,9,5,-1,7,6,5,-1,-1,-1,-1,-1,
    5,-1,6,-1,1,4,3,-1,-1,-1,-1,-1,3,-1,-1,-1,0,-1,-1,-1,7,4,0,
    -1,3,-1,5,0,1,-1,0,-1,-1,-1,2,4,2,-1,7,-1,1,-1,0,-1,8,-1,4,3,7,
    -1,7,-1,1,-1,2,-1,8,-1,-1,-1,-1,-1,0,-1,5,-1,-1,-1,-1,-1,7,
    -1,-1,-1,7,-1,-1,7,3,-1,6,-1,0,-1,8,-1,7,9,5,6,5,-1,1,-1,-1,7,7,-1,
    8,-1,-1,-1,6,8,5,-1,-1,-1,9,-1,0,3,4,-1,9,-1,2,-1,2,2,9,-1,1,-1,2,
    -1,7,-1,-1,-1,7,-1,7,-1,3,-1,4,1,1,-1,-1,4,5,-1,9,-1,-1,-1,0,-1,
    1,0,7,5,2,-1,-1,-1,1,-1,4,-1,1,3,2,-1,9,-1,2,-1,-1,-1,0,5,2,-1,3,-1,
    9,6,7,-1,8,2,2,4,8,-1,2,-1,4,-1,-1,-1,-1,-1,-1,-1,8,-1,6,-1,3,-1,0,
    -1,6,-1,0,-1,8,2,0,5,4,-1,7,-1,9,2,0,-1,-1,-1,1,-1,1,7,6,-1,-1,-1,7,
    -1,0,-1,1,5,4,8,2,-1,2,-1,4,-1,8,1,5,3,1,-1,6,5,4,3,9,7,6,7,5,2,2,-1,-1,-1,
    4,-1,1,-1,-1,-1,3,-1,5,-1,7,6,8,-1,-1,-1,5,-1,-1,-1,9,-1,3,-1,4,
    -1,1,-1,1,-1,9,2,8,-1,7,-1,2,-1,6,-1,0,2,2,-1,-1,-1,7,-1,2,-1,5,-1,
    8,-1,-1,0,8,-1,4,-1,7,-1,8,-1,1,-1,9,-1,7,-1,8,-1,9,3,7,-1,-1,-1,4,
    -1,-1,-1,6,9,2,-1,2,4,7,7,9,-1,3,9,3,-1,-1,-1,7,-1,2,-1,2,-1,9,-1,-1,
    -1,0,-1,8,-1,-1,-1,5,-1,3,-1,-1,8,2,-1,4,-1,5,-1,5,-1,9,-1,3,-1,1,
    -1,9,-1,3,-1,8,-1,-1,-1,-1,8,6,-1,-1,-1,-1,1,4,-1,-1,-1,7,-1,-1,
    -1,4,2,7,6,1,-1,6,3,4,-1,-1,-1,2,-1,-1,-1,3,9,4,-1,6,-1,4,4,3,-1,-1,3,5,
    -1,-1,-1,-1,9,3,-1,5,-1,3,-1,-1,-1,-1,2,4,-1,8,-1,3,-1,-1,-1,3,
    -1,8,-1,-1,0,6,-1,4,-1,8,1,5,-1,8,-1,-1,-1,5,-1,2,-1,2,-1,9,-1,9,-1,
    1,-1,-1,-1,7,-1,3,-1,-1,-1,-1,6,4,-1,7,9,3,-1,-1,-1,9,-1,-1,4,2,8,5,
    5,2,1,7,-1,-1,1,7,-1,1,-1,0,-1,2,-1,2,-1,9,5,4,-1,3,-1,-1,-1,-1,-1,6,
    -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,2,4,-1,4,-1,-1,0,6,-1,
    -1,3,1,-1,6,5,4,-1,-1,-1,-1,-1,9,0,8,-1,-1,-1,-1,-1,-1,-1,-1,0,8,
    -1,1,-1,5,-1,-1,5,5,-1,-1,-1,-1,-1,2,-1,0,8,1,-1,-1,-1,5,-1,8,0,2,
    -1,0,-1,-1,-1,0,-1,6,3,0,-1,-1,-1,9,-1,-1,-1,7,-1,7,-1,0,-1,2,-1,2,
    -1,-1,5,0,-1,-1,-1,7,-1,2,0,4,-1,7,-1,-1,9,0,-1,-1,-1,5,0,8,-1,7,6,4,5,
    1,-1,7,-1,-1,-1,-1,-1,5,-1,1,-1,-1,4,1,5,7,9,1,-1,6,-1,4,-1,-1,4,2,-1,
    4,2,0,-1,7,4,9,-1,7,4,8,-1,3,-1,-1,-1,0,-1,1,-1,0,-1,5,-1,9,-1,-1,0,0,3,5,
    -1,-1,-1,3,-1,-1,-1,0,2,6,-1,-1,-1,1,0,5,6,5,-1,8,8,3,9,7,3,3,-1,-1,-1,
    1,0,0,-1,-1,-1,-1,-1,4,3,9,-1,-1,-1,5,-1,4,-1,2,7,7,-1,-1,-1,1,-1,
    -1,7,3,-1,-1,-1,-1,-1,4,-1,4,-1,-1,4,1,-1,-1,-1,9,-1,-1,-1,3,-1,
    9,7,1,-1,4,-1,3,-1,1,-1,4,6,3,-1,-1,-1,5,-1,-1,-1,-1,8,0,-1,1,-1,9,-1,
    -1,-1,0,-1,-1,-1,-1,-1,6,-1,-1,-1,7,3,5,-1,6,1,9,-1,-1,-1,7,-1,6,
    -1,6,-1,-1,-1,6,-1,9,-1,0,-1,9,1,6,-1,8,-1,5,-1,3,-1,2,-1,9,-1,-1,
    -1,-1,-1,-1,2,7,-1,-1,-1,7,-1,0,2,9,-1,9,-1,5,-1,-1,-1,9,-1,1,-1,
    1,7,1,5,2,9,7,-1,6,-1,0,-1,3,-1,4,-1,2,-1,-1,-1,-1,-1,1,-1,-1,-1,9,-1,
    -1,4,0,-1,8,-1,2,-1,-1,-1,3,-1,0,-1,6,-1,7,-1,-1,-1,-1,7,0,-1,1,-1,
    -1,8,4,9,7,-1,9,-1,1,-1,4,-1,1,-1,8,-1,3,-1,-1,-1,1,-1,9,-1,-1,-1,7,
    -1,-1,-1,-1,0,5,-1,7,-1,-1,-1,5,-1,-1,2,5,-1,-1,3,4,-1,-1,4,3,7,9,8,
    3,-1,-1,-1,2,-1,1,-1,-1,-1,1,-1,0,9,7,-1,9,-1,1,8,8,-1,-1,3,2,-1,0,-1,
    -1,-1,4,-1,0,5,6,-1,1,-1,0,2,7,-1,-1,-1,-1,4,1,-1,-1,4,6,-1,0,-1,1,-1,
    -1,-1,2,-1,3,-1,0,-1,-1,2,2,-1,1,-1,8,-1,-1,-1,6,-1,7,-1,7,-1,2,-1,2
    ,2,9,-1,0,-1,-1,0,0,-1,-1,-1,5,-1,2,-1,6,5,2,-1,-1,-1,-1,-1,-1,-1,8,
    -1,2,-1,-1,5,9,8,1,-1,6,4,4,-1,-1,-1,0,0,3,-1,-1,-1,8,-1,2,-1,4,-1,-1,
    -1,-1,3,0,-1,0,5,0,-1,2,0,0,-1,3,-1,-1,-1,-1,-1,6,-1,6,-1,-1,5,5,9,9,
    -1,3,5,4,-1,-1,-1,-1,1,0,-1,7,-1,8,8,9,6,6,-1,-1,-1,5,-1,8,9,7,8,4,8,6,-1,
    6,-1,8,4,2,-1,7,-1,7,-1,-1,-1,8,7,9,8,8,-1,1,-1,9,2,6,-1,2,0,9,8,5,4,9,-1,3,
    -1,-1,-1,9,-1,2,-1,5,8,4,-1,3,-1,1,-1,2,-1,2,-1,1,-1,-1,-1,1,0,1,-1,
    -1,-1,0,-1,8,3,1,5,3,-1,-1,-1,8,-1,1,1,4,-1,-1,-1,-1,-1,-1,-1,-1,
    -1,0,8,9,-1,3,-1,-1,6,4,-1,2,-1,4,-1,7,-1,5,-1,5,-1,2,-1,8,-1,4,-1,-1,
    3,6,-1,4,-1,3,-1,2,-1,8,3,2,-1,-1,-1,-1,-1,-1,5,6,-1,8,-1,3,-1,3,-1,9,
    -1,-1,-1,7,2,6,-1,8,-1,-1,-1,-1,4,4,1,5,-1,-1,8,8,-1,-1,2,6,-1,9,-1,6,
    -1,-1,0,8,0,8,3,4,-1,7,-1,1,-1,-1,-1,6,-1,-1,0,9,-1,3,-1,-1,-1,0,-1,3,
    -1,5,-1,6,-1,6,-1,2,-1,6,-1,-1,1,0,-1,4,-1,-1,-1,2,-1,-1,-1,6,-1,
    -1,-1,6,-1,7,4,9,-1,-1,-1,5,-1,2,-1,-1,-1,0,-1,-1,-1,3,-1,3,-1,3,-1,
    -1,-1,7,-1,-1,-1,7,-1,-1,-1,4,-1,-1,-1,2,-1,4,3,7,-1,6,-1,1,-1,-1,
    -1,6,-1,5,-1,5,-1,0,-1,9,-1,-1,-1,6,-1,-1,-1,7,-1,8,-1,6,-1,3,-1,9,-1,
    6,-1,5,-1,2,-1,2,1,3,-1,-1,8,0,-1,-1,1,8,-1,6,-1,6,-1,2,-1,-1,-1,-1,-1,
    9,2,8,-1,0,-1,7,-1,7,-1,3,-1,4,-1,-1,-1,0,-1,-1,0,9,-1,5,-1,-1,5,1,-1,
    -1,-1,-1,-1,3,-1,-1,9,5,7,6,-1,-1,-1,-1,7,9,-1,-1,9,7,-1,5,-1,9,5,5,-1,
    -1,-1,-1,-1,7,-1,3,-1,3,-1,7,-1,-1,-1,1,-1,-1,-1,-1,-1,0,-1,5,6,5,-1,
    6,-1,0,5,4,-1,8,-1,1,3,3,-1,-1,-1,9,9,4,0,0,4,3,-1,-1,6,3,-1,7,-1,5,-1,-1,5,
    4,3,6,6,3,-1,0,-1,-1,-1,1,-1,4,-1,7,2,2,0,7,0,0,-1,1,-1,3,-1,-1,-1,6,3,1,7,8,4,
    9,-1,-1,8,9,-1,1,5,1,-1,1,-1,4,-1,7,8,9,-1,7,3,6,2,9,7,0,3,3,5,4,2,0,-1,9,-1,9,-1,
    -1,-1,-1,-1,-1,9,4,-1,-1,-1,-1,-1,8,-1,-1,8,8,-1,3,-1,-1,6,5,-1,-1,
    -1,-1,-1,-1,6,7,-1,0,7,9,-1,4,-1,-1,-1,7,-1,8,-1,-1,-1,6,1,4,-1,-1,-1,
    4,0,3,-1,8,-1,0,-1,4,-1,1,-1,6,-1,-1,-1,7,3,1,-1,4,9,3,-1,7,-1,-1,-1,4,-1,
    7,-1,-1,2,8,-1,-1,-1,4,-1,2,-1,6,-1,-1,-1,0,-1,0,-1,7,4,4,-1,5,-1,-1,2,
    2,-1,-1,-1,0,-1,-1,-1,7,-1,-1,7,7,-1,-1,2,6,-1,-1,6,3,-1,-1,-1,9,8,8,-1,
    9,-1,3,-1,9,9,2,-1,-1,-1,4,-1,8,0,2,-1,-1,-1,5,1,9,-1,7,-1,-1,-1,2,-1,-1,
    -1,1,-1,8,-1,4,6,9,-1,8,-1,-1,-1,-1,4,8,-1,1,6,1,-1,9,-1,8,-1,7,-1,1,-1,4,
    -1,5,-1,7,5,5,-1,-1,-1,1,3,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,8,-1,3,8,1,
    -1,0,-1,-1,-1,8,-1,-1,-1,-1,-1,8,-1,4,-1,8,-1,1,-1,9,7,9,-1,-1,-1,1,-1,
    6,5,5,-1,-1,-1,-1,-1,6,-1,2,-1,7,9,1,-1,3,-1,-1,-1,8,-1,-1,-1,-1,-1,9,
    -1,7,1,2,-1,-1,-1,9,6,8,-1,-1,-1,-1,9,6,-1,-1,-1,4,-1,1,-1,3,-1,4,4,0,2,2,
    -1,6,-1,7,9,9,-1,8,-1,8,-1,-1,-1,5,3,2,-1,5,-1,-1,-1,-1,4,6,6,3,-1,-1,-1,
    -1,-1,6,-1,-1,-1,-1,-1,6,-1,9,-1,3,-1,-1,-1,0,-1,-1,-1,7,-1,1,4,9,-1,
    -1,8,0,1,3,-1,1,-1,-1,-1,0,-1,-1,7,5,-1,9,6,7,-1,7,-1,-1,8,2,-1,-1,-1,-1,
    3,8,-1,-1,-1,8,-1,1,8,8,-1,0,-1,7,-1,4,7,0,3,7,-1,-1,3,8,-1,-1,6,2,-1,-1,-1,
    7,3,5,-1,1,4,4,-1,8,-1,-1,-1,6,3,4,8,1,8,8,-1,-1,8,3,-1,6,8,9,-1,-1,-1,3,-1,-1,
    -1,9,-1,0,9,9,4,1,0,0,-1,-1,-1,3,-1,-1,-1,8,-1,-1,-1,7,0,0,-1,6,-1,-1,7,2,
    -1,-1,1,4,-1,-1,-1,-1,-1,7,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,6,-1,-1,
    -1,-1,7,3,-1,0,-1,-1,-1,3,-1,0,-1,4,0,8,-1,-1,7,7,8,3,2,3,3,1,-1,6,-1,7,7,1,-1,
    -1,-1,0,-1,8,-1,0,-1,9,-1,8,-1,-1,-1,-1,-1,5,8,0,-1,4,-1,6,1,3,1,9,6,9,-1,
    -1,2,5,-1,-1,-1,6,-1,-1,-1,2,-1,8,-1,-1,-1,1,8,0,-1,2,-1,5,-1,-1,-1,2,
    -1,7,-1,-1,-1,-1,-1,2,-1,2,-1,-1,-1,7,-1,2,-1,9,-1,2,-1,3,-1,4,-1,2,2,3,
    -1,-1,-1,-1,7,9,-1,1,-1,-1,-1,5,-1,9,-1,8,-1,2,7,0,-1,3,-1,8,-1,0,-1,-1,
    -1,4,-1,1,-1,9,6,1,-1,8,-1,1,-1,6,-1,-1,-1,3,-1,1,-1,9,5,8,-1,0,-1,5,-1,1,-1,
    5,-1,0,0,3,-1,5,-1,-1,-1,-1,-1,2,-1,-1,-1,0,-1,-1,-1,5,-1,7,-1,-1,-1,
    -1,-1,2,-1,2,-1,7,0,9,-1,7,-1,9,2,2,-1,-1,2,0,8,6,-1,6,1,0,-1,-1,-1,9,-1,3,-1,
    -1,-1,6,-1,0,-1,-1,-1,6,2,1,-1,1,-1,-1,-1,0,-1,-1,1,9,-1,0,-1,-1,4,3,-1,9,
    8,1,6,5,-1,-1,6,2,-1,2,5,6,-1,4,-1,8,-1,-1,-1,7,-1,-1,-1,8,-1,-1,-1,9,-1,4,
    -1,8,-1,6,4,9,-1,7,-1,6,3,7,-1,9,-1,-1,5,3,-1,-1,7,5,-1,1,-1,6,-1,4,3,9,-1,7,
    -1,2,-1,4,-1,-1,-1,1,-1,5,-1,8,-1,-1,-1,2,-1,-1,-1,8,6,1,-1,-1,-1,0,-1,
    8,-1,3,-1,1,-1,-1,6,5,-1,-1,-1,2,-1,-1,4,1,-1,-1,-1,7,-1,-1,7,3,-1,-1,-1,
    3,9,6,-1,5,2,1,-1,-1,-1,-1,-1,4,6,6,1,7,1,0,9,3,-1,4,-1,4,-1,6,-1,-1,-1,6,-1,
    -1,-1,5,6,7,-1,-1,7,2,-1,7,3,3,4,9,-1,-1,-1,0,-1,-1,-1,6,-1,2,-1,0,-1,-1,
    -1,6,-1,-1,0,6,-1,-1,2,3,-1,-1,9,4,-1,8,4,6,-1,8,-1,9,-1,-1,-1,0,4,5,-1,3,
    -1,7,-1,1,-1,-1,-1,-1,-1,-1,-1,3,2,0,-1,-1,-1,5,-1,6,-1,-1,-1,7,-1,-1,
    8,9,-1,-1,-1,5,-1,1,-1,3,-1,1,-1,6,-1,-1,7,9,-1,9,-1,0,-1,5,-1,7,-1,8,-1,
    -1,-1,2,-1,6,-1,9,-1,4,-1,-1,-1,0,-1,5,-1,0,3,7,-1,-1,-1,4,-1,0,2,0,-1,6,
    -1,3,-1,3,-1,-1,-1,9,-1,7,3,9,-1,9,-1,5,-1,5,-1,5,-1,-1,7,1,-1,2,-1,0,-1,4,
    -1,5,6,1,-1,-1,-1,-1,2,9,-1,-1,-1,5,-1,5,-1,1,-1,5,-1,7,2,4,-1,3,9,5,-1,-1,
    -1,4,0,6,-1,9,-1,-1,-1,2,-1,2,8,3,-1,-1,-1,3,-1,0,5,0,-1,-1,-1,2,-1,-1,-1,
    1,-1,-1,-1,-1,6,2,-1,-1,-1,7,-1,0,-1,1,-1,-1,8,0,0,1,-1,2,-1,5,-1,-1,-1,7,
    8,4,-1,-1,-1,3,1,7,-1,0,0,2,-1,-1,-1,7,-1,-1,3,8,-1,3,-1,-1,-1,0,-1,4,-1,5,
    1,6,-1,4,0,5,-1,2,-1,1,-1,-1,-1,-1,3,1,7,0,-1,5,-1,3,1,4,-1,-1,-1,-1,-1,5,-1,
    -1,-1,0,0,4,-1,3,-1,3,-1,2,0,3,-1,8,-1,4,-1,8,-1,8,-1,7,-1,7,-1,4,-1,9,-1,-1,
    -1,5,-1,6,-1,1,7,0,1,3,-1,-1,-1,6,-1,8,-1,2,5,5,-1,8,-1,-1,-1,7,-1,5,-1,4,-1,
    4,-1,1,-1,2,7,2,-1,5,-1,-1,1,5,-1,5,7,4,-1,7,7,4,3,8,8,3,-1,-1,-1,5,-1,-1,6,0,-1,
    -1,-1,6,6,1,-1,-1,-1,0,-1,5,-1,-1,-1,2,-1,-1,-1,8,-1,1,-1,-1,-1,-1,-1,1,
    -1,1,-1,-1,5,2,-1,-1,-1,6,-1,-1,-1,3,-1,3,-1,-1,2,7,-1,7,-1,-1,-1,1,-1,
    -1,-1,9,-1,3,-1,5,-1,-1,1,3,-1,-1,-1,2,-1,-1,-1,3,-1,0,-1,-1,-1,7,-1,6,
    -1,6,6,4,-1,0,-1,0,-1,8,2,2,-1,-1,-1,2,-1,7,-1,7,-1,8,-1,8,-1,-1,-1,-1,-1,9,
    -1,0,-1,3,-1,5,-1,4,-1,9,5,4,-1,4,-1,-1,-1,9,-1,7,-1,4,-1,-1,-1,0,-1,2,-1,
    -1,-1,5,-1,-1,-1,3,-1,7,-1,0,-1,6,-1,3,-1,4,-1,6,-1,0,-1,2,-1,-1,-1,7,-1,
    -1,-1,1,-1,0,-1,6,-1,5,-1,2,1,7,-1,6,1,4,-1,7,-1,-1,-1,8,-1,6,-1,-1,4,9,-1,
    -1,-1,-1,-1,0,-1,7,0,6,-1,-1,-1,-1,-1,-1,4,6,-1,3,8,8,-1,-1,-1,9,-1,6,-1,1,
    -1,7,-1,-1,4,6,-1,1,-1,5,-1,2,-1,9,-1,8,-1,-1,-1,9,-1,9,-1,-1,-1,5,-1,2,-1,
    5,2,3,-1,1,-1,-1,4,0,-1,9,-1,6,-1,9,-1,9,-1,6,8,7,0,6,-1,-1,4,3,-1,-1,-1,4,-1,-1,
    1,8,-1,-1,-1,9,-1,7,-1,7,-1,3,4,6,-1,5,-1,8,-1,-1,-1,5,-1,6,-1,3,-1,5,-1,6,9,3,
    -1,7,-1,-1,-1,2,-1,7,-1,1,5,6,-1,7,-1,8,-1,3,-1,5,-1,-1,-1,-1,-1,6,-1,5,8,2,
    -1,9,-1,0,-1,1,-1,-1,6,7,-1,2,-1,2,-1,1,-1,-1,1,4,-1,2,-1,4,-1,3,9,3,-1,9,-1,
    -1,-1,1,-1,-1,-1,-1,-1,0,-1,9,-1,-1,-1,5,-1,8,6,8,6,1,8,9,-1,8,-1,-1,3,1,-1,
    -1,-1,-1,8,1,-1,5,-1,1,-1,2,-1,9,-1,6,-1,-1,-1,9,-1,-1,-1,1,-1,8,-1,9,-1,
    8,-1,0,2,0,-1,-1,-1,1,1,2,-1,-1,-1,4,-1,-1,7,8,-1,5,7,8,-1,6,5,9,-1,9,-1,1,-1,
    -1,-1,3,-1,6,-1,4,-1,7,-1,5,6,8,-1,-1,-1,3,-1,7,-1,3,-1,-1,-1,-1,-1,1,
    -1,5,-1,0,-1,5,9,3,-1,-1,-1,8,-1,-1,-1,9,-1,1,-1,4,-1,3,-1,7,-1,5,-1,8,
    -1,5,-1,6,-1,7,7,4,-1,0,-1,-1,-1,1,-1,4,-1,0,-1,9,-1,7,-1,-1,-1,7,-1,4,-1,-1,4,6,-1,
    -1,-1,3,7,5,-1,3,-1,5,-1,-1,-1,9,3,1,-1,-1,-1,-1,-1,-1,-1,1,-1,3,5,3,4,6,-1,-1,-1,
    7,7,4,-1,5,-1,1,-1,0,-1,-1,0,2,-1,8,7,1,-1,-1,-1,6,-1,3,-1,8,-1,3,-1,6,-1,0,-1,4,-1,
    1,-1,6,-1,1,-1,-1,-1,2,-1,4,-1,5,-1,-1,-1,-1,5,0,-1,6,4,3,-1,-1,
    -1,6,-1,-1,-1,3,-1,1,-1,-1,7,7,-1,6,-1,6,-1,8,-1,3,1,8,9,0,-1,4,-1,
    9,-1,7,-1,7,1,8,-1,9,-1,9,-1,0,-1,4,-1,-1,-1,4,-1,0,-1,5,-1,7,3,4,
    -1,0,-1,1,-1,8,-1,8,-1,6,-1,0,-1,-1,5,2,-1,4,-1,8,-1,-1,-1,
    6,3,5,-1,2,-1,7,-1,4,-1,8,7,4,-1,7,-1,0,-1,9, -1,6,4,5,-1,6,-1,3,-1,
    8,-1,-1,6,4,-1,-1,-1,4,-1,8,-1,8,5,0,-1,2,0,0,-1,4,-1,-1,-1,6,-1,
    -1,6,7,-1,3,-1,2,-1,1,-1,7,0,0,-1,6,-1,6,-1,1, -1,1,-1,-1,-1,7,-1,
    -1,9,9,-1,6,-1,-1,-1,7,-1,-1,-1,-1,-1,0,-1,1,-1,-1,1,6,-1,3,-1,
    -1,-1,1,-1,1,-1,8,-1,7,-1,0,-1,-1,-1,4, -1,-1,-1,9,1,7,-1,-1,-1,
    2,-1,3,-1,-1,-1,4,-1,-1,-1,7,-1,1,-1,6,2,5,-1,9,-1,8,-1,-1,-1,
    9,-1,-1,-1,6, -1,-1,-1,4,-1,-1,-1,3,-1,2,2,4,-1,1,-1,1,-1,3,-1,
    3,-1,9,-1,2,-1,6,-1,9,-1,-1,-1,9,-1,8,-1,4,5,8,-1,0,-1,8,-1,-1,-1,
    1,-1,0,1,9,-1,-1,-1,-1,4,5,-1,-1,7,7,2,2,-1,-1,9,1,6,1,-1,4,-1,8,-1,
    -1,-1,9,9,3,-1,6,1,9,-1,-1,-1,7,-1,4,-1,0,-1,4,-1, 2,-1,8,-1,0,-1,6,
    -1,0,-1,8,-1,-1,-1,2,-1,-1,-1,5,-1,0,-1,4,1,9,-1,2,-1,4,-1,0,-1,
    -1,-1,4,7,7,-1,5,-1,5,-1,9,-1,-1,-1,9,-1,-1,9,4,-1,0,-1,4,-1,8,-1,
    -1,-1,-1,-1,1,-1,8,-1,4,-1,-1,6,1,-1,-1,-1,7,-1,4,-1,0,-1,1,7,0,
    -1,1,-1,4,7,1,-1,1, -1,1,-1,-1,-1,2,1,0,-1,5,-1,7,-1,5,-1,
    5,4,6,-1,7,-1,8,-1,7,-1,-1,-1,1,7,9,-1,-1,-1,-1,-1,-1,-1,4,
    -1,3,2,2,-1,3,-1,1,1,3,-1,2,-1,4,-1,-1,1,0,-1,0,-1,5,4,0,-1,2,0,5,
    0,6,-1,6,-1,6,-1,-1,-1,8,-1,9,-1,-1,-1,9,-1,7,-1,-1,8,9,-1,-1,-1,1,
    -1,4,-1,3,-1,8,-1,6,5,9,-1,-1,-1,0,-1,9,-1,7,-1,-1, 6,1,-1,9,-1,0,
    -1,-1,-1,8,-1,4,-1,5,-1,8,-1,2,-1,-1,2,6,-1,0,-1,-1,-1,4,-1,6,-1,
    -1,2,1,-1,-1,-1,1,-1,-1,-1,7,-1,-1,-1,6,-1,-1,-1,2,-1,4,-1,-1,5,
    8,-1,8,-1,6,-1,-1,-1,8,-1,4,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,6,
    -1,1,8,4,-1,-1, -1,-1,-1,-1,3,9,-1,-1,4,0,-1,-1,-1,7,-1,-1,-1,
    0,-1,-1,-1,3,-1,-1,4,0,-1,-1,-1,4,-1,2,-1,8,2,4,-1,-1,-1,1,8,9,
    -1,4,0,5,-1,3,-1,-1,-1,-1,-1,8,-1,6,-1,8,-1,-1,6,1,-1,4,-1,3,-1,9,
    -1,6,-1,-1,-1,1,-1,2,-1,6,-1,2,-1,0,-1,-1,-1,7, -1,-1,-1,5,-1,
    -1,-1,0,-1,4,-1,3,-1,-1,4,3,-1,2,-1,5,-1,0,-1,6,-1,4,-1,7,-1,8,7,4,
    -1,8,-1,-1,-1,-1,-1,8,-1,3,6,8,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,
    0,-1,4,-1,-1,1,6,-1,0,-1,-1,-1,7,-1,8,-1,8,0,1,-1,9,-1,-1,-1,-1,5,1,
    -1,2,-1,1, -1,-1,-1,6,-1,-1,9,6,-1,0,-1,1,0,9,6,7,-1,9,4,5,-1,-1,8,6,-1,
    0,-1,-1,-1,-1,8,1,3,1,-1,-1,-1,5,7,2,6,5,-1,-1,-1,1,-1,3,-1,-1,-1,1,-1,9,
    -1,-1,-1,6,-1,3,-1,2,-1,-1,-1,0,-1,0,-1,9,7,7,-1,6,-1,1,-1,-1,
    -1,-1,-1,4,-1,6,-1,3,-1,0,-1,5,-1,1,-1,0,-1,-1,-1,4,9,5,-1,4,-1,
    -1,-1,-1,-1,-1,-1,0,-1,2,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,2,8,-1,2,
    -1,-1,-1,-1,-1,4,-1,7,-1,3,-1, 3,-1,4,9,7,-1,-1,6,1,-1,-1,-1,3,-1,2,
    -1,8,-1,4,-1,-1,-1,2,-1,1,1,7,-1,1,-1,-1,-1,4,-1,4,-1,-1,-1,7,4,7,
    -1,7,-1,8,-1,9,-1,3,-1,4,-1,-1,-1,-1,-1,0,-1,7,-1,4,-1,-1,-1,5,-1,
    -1,-1,1,9,9,-1,2,-1,5,-1,3,-1,6,-1,6,-1,-1,-1,2,-1,-1,8, 5,-1,5,-1,3,
    -1,4,-1,1,-1,7,-1,-1,-1,6,-1,-1,1,3,-1,-1,-1,0,-1,-1,-1,3,8,9,-1,5,
    -1,-1,-1,8,-1,4,-1,6,-1,6,-1,3,-1,-1,-1,8,-1,3,7,7,-1,-1,-1,-1,-1,4,
    -1,7,9,6,-1,8,-1,2,0,6,-1,-1,-1,6,-1,-1,-1,7,-1,7,3,2,-1,6,-1,5,0,4,-1,
    -1,8,7, -1,1,-1,9,4,1,-1,8,5,5,5,9,-1,5,6,9,-1,6,8,7,-1,6,-1,3,-1,8,-1,7,-1,
    9,-1,-1,-1,-1,-1,0,-1,4,-1,6,-1,6,-1,1,-1,9,-1,-1,-1,9,-1,0,-1,1,
    -1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,4,9,-1,-1,2,7,-1,4,-1,1,-1,3,
    -1,3,-1,9,-1,-1,-1,0,-1,7, -1,-1,-1,3,-1,6,-1,7,-1,4,4,8,-1,3,-1,8,
    -1,1,-1,3,-1,8,-1,8,-1,-1,-1,2,-1,-1,-1,6,-1,4,-1,6,-1,-1,-1,2,
    -1,2,9,6,-1,9,-1,-1,-1,-1,0,7,-1, 3,-1,-1,-1,9,-1,2,-1,8,-1,3,-1,
    -1,-1,0,-1,9,-1,6,-1,2,-1,-1,-1,7,9,1,-1,-1,-1,5,-1,6,-1,1,-1,-1,
    -1,3,-1,-1,-1,8,-1,-1,-1,-1,-1,0,-1, 4,-1,2,-1,3,-1,6,0,4,-1,-1,
    -1,-1,-1,-1,-1,-1,-1,-1,4,4,-1,5,-1,5,-1,8,8,6,-1,1,-1,6,-1,-1,
    8,5,-1,8,-1,3,-1,8,-1,7,6,6,-1,-1,-1,4,-1,-1,-1, 8,-1,7,5,5,-1,-1,
    -1,8,-1,-1,2,5,-1,2,-1,0,-1,9,-1,-1,-1,0,-1,8,-1,-1,3,7,-1,0,2,5,
    0,4,-1,1,-1,4,-1,8,-1,-1,-1,3,-1,3,-1,-1,-1,3,-1,4,3,5,-1, -1,-1,
    7,-1,0,-1,3,-1,-1,-1,-1,8,8,-1,5,6,6,-1,4,-1,-1,-1,-1,-1,9,-1,
    -1,-1,-1,-1,2,-1,6,-1,3,-1,2,-1,-1,-1,-1,3,8,-1,9,-1,8,-1,7,-1,3,
    -1,0,-1,0,-1,0,-1,7,-1,9,-1,9,-1,9,-1,7,-1,7,0,7,-1,-1,-1,2,0,5,-1,0,
    -1,-1,-1,8,-1,3,3,4,-1,-1,-1,0,-1,8,-1,0,-1,7,-1,8,9,8,-1,-1,-1,-1,
    -1,-1,-1,-1,4,5,-1,-1,-1,9,-1,-1,-1,9,-1,9,-1,-1,6,7,-1,-1,3,9,-1,
    1,-1,4,-1,-1,-1,6,0,3,-1,-1,-1,-1,-1,-1,0,7,-1,-1,-1,2, -1,-1,
    -1,-1,-1,4,6,2,-1,-1,-1,5,-1,-1,-1,-1,7,2,-1,-1,-1,4,-1,5,-1,
    7,-1,-1,2,3,6,6,-1,-1,-1,-1,9,6,-1,-1,-1,7,8,5,-1,2,1,1, -1,0,-1,1,-1,
    2,-1,7,-1,-1,-1,-1,-1,7,-1,8,4,3,-1,-1,-1,-1,-1,-1,-1,-1,1,8,-1,
    -1,-1,2,-1,7,-1,8,3,6, -1,-1,-1,-1,-1,4,0,5,-1,-1,-1,2,-1,8,-1,4,
    -1,-1,-1,5,-1,1,-1,-1,-1,4,-1,5,-1,-1,-1,5,-1,9,-1,-1, -1,2,
    -1,1,8,3,-1,-1,-1,8,5,6,-1,5,-1,-1,-1,-1,-1,9,-1,4,-1,-1,-1,-1,
    -1,1,-1,5,-1,-1,-1,5,2,1,-1, 2,7,1,3,7,-1,0,-1,-1,-1,-1,6,7,-1,-1,
    -1,8,-1,-1,-1,-1,-1,4,-1,-1,7,1,-1,-1,5,6,-1,1,-1,0,-1,8,0,8, -1,
    9,-1,2,7,7,-1,-1,-1,8,-1,-1,-1,-1,-1,6,-1,-1,7,4,-1,5,0,8,-1,-1,
    -1,-1,0,6,7,4,-1,-1,1,3,-1,9, -1,-1,-1,-1,-1,-1,-1,-1,-1,9,-1,
    4,0,1,-1,-1,9,6,-1,-1,-1,0,-1,8,-1,-1,0,5,-1,-1,-1,4,4,7,
    -1,6,-1,1,-1,7,-1,4,-1,0,-1,-1,-1,-1,-1,1,-1,2,-1,6,-1,-1,
    -1,6,3,8,-1,-1,-1,-1,-1,0,-1,6, -1,9,3,7,-1,-1,-1,-1,-1,8,-1,
    -1,-1,9,-1,-1,-1,-1,-1,1,-1,-1,9,0,-1,9,-1,-1,6,9,-1,9,-1,3,
    -1,-1,8,1,-1,-1,-1,5,-1,6,-1,0,-1,-1,-1,9,4,5,9,9,-1,-1,-1,-1,
    2,8,-1,3,1,2,-1,5,1,0,-1,-1,-1, -1,9,8,-1,-1,8,7,-1,-1,-1,1,-1,3,
    -1,6,-1,9,-1,-1,-1,0,-1,-1,-1,4,-1,-1,7,0,7,9,-1,8,-1,-1, -1,0,
    -1,-1,-1,2,4,0,-1,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,
    -1,-1,8,-1,-1,5,9,-1,1,-1,-1,-1,-1,-1,-1, 5,3,-1,-1,1,2,-1,0,
    -1,-1,-1,8,-1,-1,-1,-1,5,4,-1,1,-1,-1,-1,0,2,5,1,9,-1,-1,-1,
    2,-1,-1, -1,-1,4,1,-1,5,7,9,-1,-1,-1,6,-1,8,-1,5,2,9,-1,-1,-1,
    -1,9,9,-1,0,7,3,-1,-1,-1,1,-1,1,3,6,9,6, -1,-1,-1,-1,-1,9,-1,-1,
    2,9,-1,-1,-1,7,-1,-1,-1,1,-1,7,-1,-1,-1,3,-1,7,-1,2,-1,7,-1,3,
    -1,2,-1,2,-1,-1,-1,4,-1,-1,1,3,5,6,-1,4,-1,7,3,3,-1,6,-1,-1,-1,4,
    -1,4,-1,-1,-1,8,-1,-1, -1,-1,-1,4,-1,-1,-1,-1,-1,3,-1,3,-1,
    0,-1,-1,-1,-1,-1,8,-1,-1,5,6,-1,-1,-1,-1,2,7, -1,1,-1,2,-1,-1,
    6,8,-1,-1,4,5,3,0,-1,-1,-1,6,-1,3,-1,6,-1,-1,4,8,-1,-1,-1,-1,-1,-1,
    -1,3,-1,0,-1,3,2,5,-1,-1,-1,1,-1,-1,-1,3,-1,4,-1,-1,-1,3,9,3,-1,
    9,-1,-1,-1,1,-1,9,0,0, -1,9,-1,6,-1,2,6,6,-1,-1,-1,0,-1,-1,-1,7,
    -1,9,-1,-1,-1,-1,-1,3,-1,1,2,3,-1,-1,-1,7, -1,5,-1,0,-1,8,-1,
    -1,-1,0,-1,-1,-1,4,-1,9,-1,-1,-1,3,7,5,-1,1,-1,5,-1,-1,-1,-1,4,0,
    -1,-1,8,5,-1,2,-1,-1,0,9,4,5,-1,9,-1,5,-1,-1,-1,5,-1,9,-1,8,-1,7,-1,
    2,4,2,-1,-1,4,1,9,1, -1,3,3,7,-1,8,-1,7,1,9,-1,2,-1,9,-1,7,-1,0,-1,2,
    -1,3,-1,-1,6,8,-1,-1,6,3,-1,6,-1,-1,-1,8,-1,-1,-1,4, -1,2,-1,
    2,-1,3,-1,4,-1,7,-1,-1,-1,4,-1,-1,4,1,-1,4,-1,6,-1,-1,0,1,-1,-1,
    -1,-1,-1, 6,-1,-1,-1,7,-1,-1,-1,7,-1,-1,-1,4,-1,-1,-1,8,-1,
    5,-1,9,-1,-1,-1,7,-1,-1,-1,9, -1,-1,-1,3,-1,1,-1,-1,-1,2,-1,8,
    -1,7,-1,7,-1,2,-1,-1,-1,5,-1,0,4,0,-1,-1,-1,2, -1,3,-1,4,4,0,-1,8,
    -1,8,-1,-1,-1,-1,-1,0,-1,1,-1,9,-1,8,-1,0,-1,-1,-1,4,-1,-1,
    -1,-1,-1,7,-1,6,-1,2,2,5,-1,8,-1,9,-1,8,-1,-1,-1,8,-1,3,-1,6,-1,
    6,-1,3,-1,2,-1, -1,-1,6,-1,-1,-1,3,-1,7,-1,9,-1,0,-1,7,-1,0,-1,
    3,-1,4,-1,9,-1,2,-1,7,-1,2,-1, -1,-1,8,-1,-1,-1,9,-1,4,-1,-1,-1,
    -1,2,8,-1,1,-1,-1,-1,3,-1,2,-1,-1,-1,0,-1, 0,-1,1,-1,2,-1,8,-1,8,
    8,6,-1,-1,-1,1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,
    6,-1,8,1,2,-1,-1,-1,-1,-1,-1,-1,4,-1,6,0,5,-1,0,-1,2,-1,2,-1,0,
    -1,8,-1,3,-1,7,-1, 6,-1,-1,-1,-1,-1,-1,-1,4,-1,5,3,0,-1,-1,3,8,
    -1,-1,-1,7,-1,8,-1,0,-1,2,-1,0,-1,0,-1,4,-1,7,-1,2);
}
