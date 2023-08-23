package com.joshir.twoptr;

public class ValidPalindromeII {
  public boolean validPalindrome(char arr[] ,int start, int end){
    while(start < end){
      if(arr[start]!=arr[end])
        return false;
      start++;
      end--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    int n = s.length();
    int i = 0, j = n - 1;
    char arr[] = s.toCharArray();
    while(i < j) {
      if (!Character.isLetterOrDigit(arr[i])) i++;
      else if (!Character.isLetterOrDigit(arr[j])) j--;
      else {
        if( arr[i] == arr[j]) {
          i++;
          j--;
        }
        else
          return validPalindrome(arr,i+1,j) || validPalindrome(arr,i,j-1);
      }
    }
    return true;
  }
}
