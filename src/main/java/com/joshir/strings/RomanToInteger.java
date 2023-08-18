package com.joshir.strings;

import java.util.Map;

public class RomanToInteger {
  public int romanToInt(String s) {
    if (s == null || s == "") return 0;
    Map<Character, Integer> m = Map.of('I', 1,'V',5,'X',10,'L',50,'C',100,'D',500, 'M',1000);

    int i = 0, len = s.length(),sum = 0, value = 0, prev = 0;
    while(i < len){
      value = m.get(s.charAt(i));
      if(i > 0 && value > (prev =  m.get(s.charAt(i-1))))
        value = value - prev - prev ;
      sum += value;
      i++;
    }
    return sum;
  }
}
// MCMXCIV
// 1000 + 100 - 100 + 1000 - 100 + 10 - 10 + 100 - 10 + 1 - 1 + 5 - 1 1994