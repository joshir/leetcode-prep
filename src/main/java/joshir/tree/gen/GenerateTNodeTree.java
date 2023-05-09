package joshir.tree.gen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
* generate tree from a list of numbers
* */
public class GenerateTNodeTree {

  /*
   * tree as a list with marker -1 to indicate
   * returning down the stack frame. other numbers mean
   * traverse up the stack until -1 is encountered
   * */
  private static final List<Integer> tree = List.of(
    10,
    30, 300, -1, 301, -1, -1,
    40, 400, -1, 401, -1, -1,
    50, 501, -1, 502, -1, 503, -1, 504, -1, -1,
    60, 601, 6001, -1, 6002, -1, -1, -1
  );

  private static final class TNode<T extends Number> {

    /* package public by default */
    final T data;

    /* package public by default */
    final List<TNode<T>> children = new ArrayList<>();

    TNode(T data) {
      this.data = data;
    }
  }

  private static final class TNodeTree<T extends Number> {
    /* package public by default */
    final TNode<T> root;

    /* package public by default */
    TNodeTree(TNode<T> root) {
      this.root = root;
    }
  }

  public static void main(String[] args) {
    TNodeTree<Integer> tree = generate();
    TNode<Integer> root = tree.root;
    TNode<Integer> copy = reflect(copy(tree).root);
    System.out.println("size " + size(root));
    System.out.println("max " + maximum(root));
    System.out.println("edge height " + edgeLength(root));
    displayTreeBreadth(copy);
    displayTreeBreadth(tree.root);
  }

  /*
  * depth traversal: find leaf and return
  * */
  private static void displayInDepth(final TNode<Integer> root) {
    if(root == null) return;

    System.out.println(root.data);
    root.children.forEach(GenerateTNodeTree::displayInDepth);
  }

  /*
  * breadth-first traversal: find siblings and repeat
  * */
  private static void displayTreeBreadth(final TNode<Integer> root) {
    if(root == null) return;

    if(!root.children.isEmpty()){
      System.out.print(root.data+ " ~> ");
      root.children.forEach(node -> System.out.print(node.data+" "));
      System.out.println();
    }
    root.children.forEach(GenerateTNodeTree::displayTreeBreadth);
  }

  /*
   * breadth-first traversal: find siblings and repeat
   * */
  private static void displayTreeBreadthUsingQueue(final TNode<Integer> root) {
    LinkedList<TNode<Integer>> queue = new LinkedList<>();
    TNode<Integer> node;

    queue.add(root);
    while (queue.size()>0){
      node = queue.removeFirst();
      System.out.print(node.data+" ");
      queue.addAll(node.children);
    }
  }

  /*
  * keep items on the stack as TNodes, linking the children of the
  * prev peek() to the current TNode to be added to the tos.
  * pop() when marker is encountered in tree. (-1 is used as a marker
  * to indicate returning back from node to parent node)
  * */
  public static TNodeTree<Integer> generate() {
    TNodeTree<Integer> top = null;
    LinkedList<TNode<Integer>> stack = new LinkedList<>();

    for(int data : tree){
      if(data != -1){
        TNode<Integer> node = new TNode<>(data);
        TNode<Integer> parent = stack.peekLast();
        if(parent == null)
          top = new TNodeTree<>(node);
        else
          parent.children.add(node);
        stack.add(node);
      }
      else
        stack.removeLast();
    }
    return top;
  }


  public static int size(final TNode<Integer> node){
    if(node == null) return 0;

    return node.children
      .stream()
      .reduce(0,
        (sum,n) -> sum + 1 + size(n),
        Integer::sum
      );
  }

  public static int maximum(final TNode<Integer> node) {
    if(node == null) return Integer.MIN_VALUE;

    return node.children
      .stream()
      .reduce(node.data,
        (partialMax, n)-> Math.max(partialMax, maximum(n)),
        Integer::sum
      );
  }

  public static int edgeLength(final TNode<Integer> node) {
    if(node == null) return 0;

    return node.children
      .stream()
      .reduce(0,
        (partialHeight, n) -> Math.max( 1 + edgeLength(n), partialHeight),
        Integer::sum
      );
  }

  /*
  * mirror the tree at each level by reversing the children
  * */
  public static TNode<Integer>  reflect(final TNode<Integer> root) {
    root.children.forEach(GenerateTNodeTree::reflect);
    Collections.reverse(root.children);
    return root;
  }

  /*
   * make an exact copy of given node and return the new node
   * */
  public static TNode<Integer> copy (final TNode<Integer> root) {
    TNode<Integer> tnode = new TNode<>(root.data);
    if(root.children.isEmpty()) return root;
    tnode.children.addAll(root.children.stream().map(x->copy(x)).toList());
    return tnode;
  }

  /*
  * make an exact copy of given tree and return the new tree
  * */
  public static TNodeTree<Integer> copy (final TNodeTree<Integer> tree) {
    return new TNodeTree<>(copy(tree.root));
  }
}
