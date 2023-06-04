package com.joshir.tree.binary;

import com.joshir.tree.Common;

public class MaxDepth {

  public int maxDepth(BinaryTreeGen.TNode<Integer> root) {
    if (root == null) return 0; /* depth is zero when root is null*/
    return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTreeGen.TNodeTree<BinaryTreeGen.TNode<Integer>,Integer> tree = BinaryTreeGen.generate(Common.megaTree());
    System.out.println(new MaxDepth().maxDepth(tree.root));
  }
}
