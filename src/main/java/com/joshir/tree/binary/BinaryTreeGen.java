package com.joshir.tree.binary;

import com.joshir.tree.Common;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.joshir.tree.Common.bTree;

public class BinaryTreeGen {

  /*
   * Reusable Tree class where E represents node TNode or any extension of the TNode class
   * K represents a manifestation of Comparable which either implements this interface
   * or doesn't, in which case it's super class must. This narrows down K to a particular type
   * but also relaxes the restriction
   * */
  static class TNodeTree<E extends TNode<T> , T extends Comparable<? super T>>{

    /* package public by default */
    final E root;
    TNodeTree (E root) {
      this.root = root;
    }
  }

  static class TNode<T extends Comparable<? super T>> {

    /* package public by default */
    T data;

    /* package public by default */
    TNode<T> left;

    /* package public by default */
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
    TNodeTree<TNode<Integer>,Integer> tree = generate(Common.bTree);
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
  public static TNodeTree<TNode<Integer>,Integer> generate(List<Integer> tree) {
    TNodeTree<TNode<Integer>,Integer> top = null;
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
          /* in order */
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
   * make a copy of given node and return the new node
   * */
  private static TNode<Integer> copy (final TNode<Integer> root) {
    if (root == null) return null;
    TNode<Integer> tnode = new TNode<>(root.data);
    tnode.left = copy(root.left);
    tnode.right = copy(root.right);
    return tnode;
  }

  /*
   * make q copy of given tree and return the new tree
   * */
  public static TNodeTree<TNode<Integer>, Integer> copy (final TNodeTree<TNode<Integer>, Integer> tree) {
    Objects.requireNonNull(tree, "Argument must not be null");
    return new TNodeTree<>(copy(tree.root));
  }

  /*
   * depth traversal
   * */
  static void displayInDepth(final TNode<Integer> root) {
    if(root == null) return;
    System.out.println(root.data);
    displayInDepth(root.left);
    displayInDepth(root.right);
  }

  /*
   * breadth-first traversal
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
   * mutation - use copy to create a different tree
   * */
  public static TNode<Integer>  pruneLeaves(TNode<Integer> root){
    if(root == null) return null;
    if(root.left == null && root.right == null) return null;

    root.left = pruneLeaves(root.left);
    root.right = pruneLeaves(root.right);
    return root;
  }
}
