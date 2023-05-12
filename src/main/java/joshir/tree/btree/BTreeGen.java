package joshir.tree.btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BTreeGen {
  /*
   *                      3001
   *              300*
   *        30*           3002
   *              301
   *
   *    10*
   *
   *
   *        40*           4001
   *              401*
   *                      4002
   *
   *      *- non-leaf vertices for in-order tree generation
   * */
  private static final List<Integer> tree = List.of(
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
  private static final List<Integer> tree1 = List.of(
          10,-1
  );
  private static class TNode<T extends Comparable<? super T>> {
    /* package public by default*/
    T data;

    /* package public by default*/
    TNode<T> left;

    /* package public by default*/
    TNode<T> right;

    TNode() {
    }

    TNode(T data){
      this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
      }
  }

  private static class  TNodeTree<T extends Comparable<? super T>>{
    final TNode<T> root;
    TNodeTree (TNode<T> root) {
      this.root = root;
    }
  }

  public static void main(String[] args) {
    TNodeTree<Integer> tree = generate();
    TNode<Integer> root = tree.root;
    TNodeTree<Integer> nTree= copy(tree);

    displayTreeBreadthUsingQueue(nTree.root);
    pruneLeaves(nTree.root);
    displayInDepth(nTree.root);

  }

  /*
  * in-order tree generation from in-order
  * list of tree nodes
  * */
  public static TNodeTree<Integer> generate() {
    TNodeTree<Integer> top = null;
    LinkedList<TNode<Integer>> stack = new LinkedList<>();
    TNode<Integer> parent, node;
    for(int data : tree){
      parent = stack.peekLast();
      if(data != -1) {
        node = new TNode<>(data);

        if(parent == null) {
          parent = node;
          top = new TNodeTree<>(parent);
        }else {
          if(parent.left == null)
            parent.left = node;
          else
            parent.right = node;
        }
        stack.add(node);
      }
      else
        stack.removeLast();
    }
    return top;
  }

  /*
   * make an exact copy of given node and return the new node
   * */
  private static TNode<Integer> copy (final TNode<Integer> root) {
    if (root == null) return null;
    TNode<Integer> tnode = new TNode<>(root.data);
    tnode.left = copy(root.left);
    tnode.right = copy(root.right);
    return tnode;
  }

  /*
   * make an exact copy of given tree and return the new tree
   * */
  public static TNodeTree<Integer> copy (final TNodeTree<Integer> tree) {
    Objects.requireNonNull(tree, "Argument must not be null");
    return new TNodeTree<>(copy(tree.root));
  }

  /*
   * depth traversal: find leaf and return
   * */
  private static void displayInDepth(final TNode<Integer> root) {
    if(root == null) return;
    System.out.println(root.data);
    displayInDepth(root.left);
    displayInDepth(root.right);
  }

  /*
   * breadth-first traversal: find siblings and repeat
   * */
  private static void displayTreeBreadthUsingQueue(final TNode<Integer> root) {
    Objects.requireNonNull(tree, "Argument must not be null");
    LinkedList<TNode<Integer>> queue = new LinkedList<>();

    queue.add(root);
    while(queue.size()>0) {
      TNode<Integer> node = queue.removeFirst();
      System.out.println(node.data);
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
  }

  /*
   * prune leaves - takes in the tree and mutates it
   * */
  public static TNode<Integer>  pruneLeaves(TNode<Integer> root){
    if(root == null) return null;
    if(root.left == null && root.right == null) return null;

    root.left = pruneLeaves(root.left);
    root.right = pruneLeaves(root.right);
    return root;
  }
}
