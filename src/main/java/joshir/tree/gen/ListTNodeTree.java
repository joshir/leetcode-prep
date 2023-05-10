package joshir.tree.gen;

import java.util.*;
import java.util.stream.IntStream;

/*
* generate tree from a list of numbers
* */
public class ListTNodeTree {

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

    @Override
    public String toString(){
      return data.toString();
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
    System.out.println("size " + size(root));
    System.out.println("max " + maximum(root));
    System.out.println("edge height " + edgeLength(root));
    displayTreeBreadth(root);
    pruneLeaves(root);
    displayTreeBreadth(root);
    System.out.println(search(root,601));
    System.out.println(search(root,301));
    List<TNode<Integer>> path = searchPath(root,301);
  }

  /*
  * depth traversal: find leaf and return
  * */
  private static void displayInDepth(final TNode<Integer> root) {
    if(root == null) return;

    System.out.println(root.data);
    root.children.forEach(ListTNodeTree::displayInDepth);
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
    root.children.forEach(ListTNodeTree::displayTreeBreadth);
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


  /*
  * find the number of vertices in the tree
  * */
  public static int size(final TNode<Integer> node){
    if(node == null) return 0;

    return node.children
      .stream()
      .reduce(0,
        (sum,n) -> sum + 1 + size(n),
        Integer::sum
      );
  }


  /*
  * find max element in current tree
  * */
  public static int maximum(final TNode<Integer> node) {
    if(node == null) return Integer.MIN_VALUE;

    return node.children
      .stream()
      .reduce(node.data,
        (partialMax, n)-> Math.max(partialMax, maximum(n)),
        Integer::sum
      );
  }

  /*
  * count edges between root node and
  * the leaf at maximum depth from the root
  * */
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
  public static TNode<Integer> reflect(final TNode<Integer> root) {
    Objects.requireNonNull(root, "Argument must not be null");
    root.children.forEach(ListTNodeTree::reflect);
    Collections.reverse(root.children);
    return root;
  }

  /*
   * make an exact copy of given node and return the new node
   * */
  private static TNode<Integer> copy (final TNode<Integer> root) {
    Objects.requireNonNull(root, "Argument must not be null");
    TNode<Integer> tnode = new TNode<>(root.data);
    tnode.children.addAll(root.children.stream().map(ListTNodeTree::copy).toList());
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
  * remove leaves where possible
  * */
  public static void pruneLeaves(final TNode<Integer> root){
    Objects.requireNonNull(root, "Argument must not be null");
    root.children.removeIf(node-> node.children.isEmpty());
    root.children.forEach(ListTNodeTree::pruneLeaves);
  }

  /*
  * find an element in the tree that looks like data
  * */
  public static boolean search(final TNode<Integer> root, int data){
    Objects.requireNonNull(root, "Argument must not be null");
    if(root.data == data) return true;
    boolean res = false;
    for(var node: root.children){
      if(res = search(node, data)) break;
    }
    return res;
  }


  /*
  * returns a list of nodes, "path," from root to
  * the node containing the data point passed as a param
  * returns an empty path if node is not found
  * */
  public static List<TNode<Integer>> searchPath(final TNode<Integer> root, int data){
    Objects.requireNonNull(root, "Argument must not be null");
    if (root.data == data) {
      List<TNode<Integer>> list = new LinkedList<>();
      list.add(root);
      return list;
    }

    LinkedList<TNode<Integer>> path = new LinkedList<>();
    for(var node: root.children){
      path.addAll(searchPath(node, data));
      if(!path.isEmpty()){
        path.addFirst(root);
        break;
      }
    }
    return path;
  }

  /*
  * lowest common ancestor of two nodes in the tree
  * */
  public static Optional<TNode<Integer>> lca(final TNode<Integer> root, int val1, int val2) {
    List<TNode<Integer>> path1 = searchPath(root, val1), path2 = searchPath(root, val2);
    int index;
    for(index = 0; index < Math.min(path1.size(), path2.size()) && path1.get(index).equals(path2.get(index)); index++) ;

    return Optional
      .ofNullable(index == 0 ? null : path1.get(index));
  }
}