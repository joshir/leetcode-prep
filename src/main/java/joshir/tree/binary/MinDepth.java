package joshir.tree.binary;

import static joshir.tree.binary.BinaryTreeGen.displayInDepth;
import static joshir.tree.binary.BinaryTreeGen.generate;

public class MinDepth {
  public int minDepth(BinaryTreeGen.TNode<Integer> root) {
    if (root == null) return 0; /* depth is zero when root is null*/
    return Math.min(minDepth(root.left) , minDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    BinaryTreeGen.TNodeTree<BinaryTreeGen.TNode<Integer>,Integer> tree = generate();
    System.out.println(new MaxDepth().maxDepth(tree.root));
  }
}
