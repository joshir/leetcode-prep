package joshir.hmap;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<String> cursor;

    for(String s: strs){
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      cursor = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
      cursor.add(s);
      map.put(String.valueOf(chars), cursor);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}).forEach(System.out::println);
  }
}
