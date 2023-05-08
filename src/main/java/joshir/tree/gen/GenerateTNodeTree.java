package joshir.tree.gen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    final TNode<T> root;

    TNodeTree(TNode<T> root) {
      this.root = root;
    }
  }

  public static void main(String[] args) {
    TNode<Integer> root = generate().root;
    displayInDepth(root);
    displayTreeBreadth(root);
    System.out.println("size " + size(root));
    System.out.println("max " + maximum(root));
    System.out.println("edge height " + edgeLength(root));
  }

  /*
  * depth traversal: find leaf and return
  * */
  private static void displayInDepth(TNode<Integer> root) {
    if(root == null) return;

    System.out.println(root.data);
    root.children.forEach(GenerateTNodeTree::displayInDepth);
  }

  /*
  * breadth-first traversal: find siblings and repeat
  * */
  private static void displayTreeBreadth(TNode<Integer> root) {
    if(root == null) return;

    if(!root.children.isEmpty()){
      System.out.print(root.data+ " ~> ");
      root.children.forEach(node -> System.out.print(node.data+" "));
      System.out.println();
    }
    root.children.forEach(GenerateTNodeTree::displayTreeBreadth);
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


  public static int size(TNode<Integer> node){
    if(node == null) return 0;

    return node.children
      .stream()
      .reduce(0,
        (sum,n) -> sum + 1 + size(n),
        Integer::sum
      );
  }

  public static int maximum(TNode<Integer> node) {
    if(node == null) return Integer.MIN_VALUE;

    return node.children
      .stream()
      .reduce(node.data,
        (partialMax, n)-> Math.max(partialMax, maximum(n)),
        Integer::sum
      );
  }

  public static int edgeLength(TNode<Integer> node) {
    if(node == null) return 0;

    return node.children
      .stream()
      .reduce(0,
        (partialHeight, n) -> Math.max( 1 + edgeLength(n), partialHeight),
        Integer::sum
      );
  }
}
