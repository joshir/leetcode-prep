package com.joshir.backtrack;

import java.util.*;

public class WordSearchII {
  static class Solution {
    private final List<String> res = new ArrayList<>();

    static class Trie {
      Map<Character, Trie> map = new HashMap<>();
      String word;

      private void addWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++){
          char x = word.charAt(i);
          if(!node.map.containsKey(x))
            node.map.put(x, new Trie());
          node = node.map.get(x);
        }
        node.word = word;
      }

      public void addWords(String[] words){
        for (String word: words)
          addWord(word);
      }
    }

    public List<String> findWords(char[][] board, String[] words) {
      Trie trie = new Trie();
      trie.addWords(words);

      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          if (trie.map.containsKey(board[i][j])) {
            backtrack(board, i, j, trie);
          }
        }
      }
      return res;
    }

    private void backtrack(char[][] board, int i, int j, Trie trie) {
      if (i < 0 || j < 0 || i == board.length || j == board[i].length)
        return;

      if(!trie.map.containsKey(board[i][j]))
        return;

      Trie node = trie.map.get(board[i][j]);

      if(node.word != null){
        this.res.add(node.word);
        node.word = null;
      }

      char x = board[i][j];
      board[i][j] = '.';
      backtrack(board,i + 1, j, node);
      backtrack(board,i - 1, j, node);
      backtrack(board, i,j + 1, node);
      backtrack(board, i,j - 1, node);
      board[i][j] = x;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(
      new Solution().findWords(new char[][]{
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}},
        new String [] {"oath","pea","eat","rain"})
      .toArray()));
  }
}
