package joshir.tree.binary;

import joshir.tree.Common;

import static joshir.tree.binary.BinaryTreeGen.generate;

public class MaxDepth {

  public int maxDepth(BinaryTreeGen.TNode<Integer> root) {
    if (root == null) return 0; /* depth is zero when root is null*/
    return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTreeGen.TNodeTree<BinaryTreeGen.TNode<Integer>,Integer> tree = generate(Common.megaTree());
    System.out.println(new MaxDepth().maxDepth(tree.root));
  }
}
