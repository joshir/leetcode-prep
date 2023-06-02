package joshir.tree.binary;

import static joshir.tree.binary.BinaryTreeGen.generate;

public class MaxDepth {

  public <T extends Comparable<? super T>> int maxDepth(BinaryTreeGen.TNode<T> root) {
    if (root == null) return 0; /* depth is zero when node is root */
    return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTreeGen.TNodeTree<BinaryTreeGen.TNode<Integer>,Integer> tree = generate();
    System.out.println(new MaxDepth().maxDepth(tree.root));
  }
}
