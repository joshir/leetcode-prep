package joshir.tree.btree;

import java.util.LinkedList;
import java.util.Objects;

import static joshir.tree.Common.bTree;

public class BTreeGen {

  /*
  * TODO
  *  move node classes inside tree classes once everything else is done
  *  this will simplify type decls that look like this NodeTree<TNode<Integer>,Integer> to
  *  NodeTree<T>
  * */
  private static class TNodeTree<E extends TNode<T> , T extends Comparable<? super T>>{
    final E root;
    TNodeTree (E root) {
      this.root = root;
    }
  }

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

  public static void main(String[] args) {
    TNodeTree<TNode<Integer>,Integer> tree = generate();
    TNode<Integer> root = tree.root;
    TNodeTree<TNode<Integer>,Integer> nTree= copy(tree);

    displayTreeBreadthUsingQueue(nTree.root);
    pruneLeaves(nTree.root);
    displayInDepth(nTree.root);

  }

  /*
  * in-order tree generation from in-order
  * list of tree nodes
  * */
  public static TNodeTree<TNode<Integer>,Integer> generate() {
    TNodeTree<TNode<Integer>,Integer> top = null;
    LinkedList<TNode<Integer>> stack = new LinkedList<>();
    TNode<Integer> parent, node;
    for(int data : bTree){
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
  public static TNodeTree<TNode<Integer>, Integer> copy (final TNodeTree<TNode<Integer>, Integer> tree) {
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
    Objects.requireNonNull(bTree, "Argument must not be null");
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
