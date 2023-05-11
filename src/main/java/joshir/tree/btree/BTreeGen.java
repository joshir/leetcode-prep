package joshir.tree.btree;

public class BTreeGen {
  private record TNode<T extends Number>(T data, BTreeGen.TNode<T> left, BTreeGen.TNode<T> right) {
    @Override
      public String toString() {
        return data.toString();
      }
    }

  private record TNodeTree<T extends Number>(TNode<T> root) {
  }

  public static void main(String[] args) {
  }
}
