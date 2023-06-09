package com.joshir.tree.generic.tree;

import com.joshir.tree.Common;

import java.util.*;

public class ListTNodeTree {

  /*
   * Reusable Tree class where E represents node TNode or any extension of the TNode class
   * K represents a manifestation of Comparable which either implements this interface
   * or doesn't, in which case it's super class must. This narrows down K to a particular type
   * but also relaxes the restriction
   * */
  static class TNodeTree<E extends TNode<K>, K extends Comparable<? super K>> {

    /* package public by default */
    final E root;

    /* package public by default */
    TNodeTree(E root) {
      this.root = root;
    }
  }

  static class TNode<T extends Comparable<? super T>> {

    /* package public by default */
    final T data;

    /* val determined at runtime post object-creation cannot be final*/
    T max;

    /* val determined at runtime post object-creation cannot be final*/
    T min;

    int size = 0;

    int height = 0;

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

  public static void main(String[] args) {
    TNodeTree<TNode<Integer>, Integer> oTree = generate(Common.tree);
    TNode<Integer> root = oTree.root;
    TNodeTree<TNode<Integer>, Integer> nTree = copy(oTree);
    System.out.println("size " + size(root));
    System.out.println("max " + maximum(root));
    System.out.println("edge height " + edgeLength(root));
    displayTreeBreadth(root);
    displayTreeBreadth(nTree.root);
    System.out.println(isPerfectlyOverlappable(oTree, nTree));
    System.out.println(isMirror(oTree, generate(Common.mirror)));
    System.out.println(isSymmetric(generate(Common.symmetric)));
  }

  /*
  * depth traversal
  * */
  private static void displayInDepth(final TNode<Integer> root) {
    if(root == null) return;

    System.out.println(root.data);
    root.children.forEach(ListTNodeTree::displayInDepth);
  }

  /*
  * breadth-first traversal
  * */
  private static void displayTreeBreadth(final TNode<Integer> root) {
    if(root == null) return;

    if(!root.children.isEmpty()){
      System.out.print(root.data+ " ~> ");
      root.children.forEach(node -> System.out.print(node.data+" "));
      System.out.println();
    }
    root.children.forEach(ListTNodeTree::displayTreeBreadth);
  }

  /*
   * breadth-first traversal
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
  public static TNodeTree<TNode<Integer>, Integer> generate(final List<Integer> tree) {
    TNodeTree<TNode<Integer>, Integer> top = null;
    LinkedList<TNode<Integer>> stack = new LinkedList<>();
    TNode<Integer> node;

    for(int data : tree){
      if(data != -1){
        node = new TNode<>(data);
        if(stack.peekLast() == null)
          top = new TNodeTree<>(node);
        else
          stack.peekLast().children.add(node);
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
   * make a copy of given node and return the new node
   * */
  private static TNode<Integer> copy (final TNode<Integer> root) {
    Objects.requireNonNull(root, "Argument must not be null");
    TNode<Integer> tnode = new TNode<>(root.data);
    tnode.children.addAll(root.children.stream().map(ListTNodeTree::copy).toList());
    return tnode;
  }

  /*
  * make a copy of given tree and return the new tree
  * */
  public static TNodeTree<TNode<Integer>, Integer> copy (final TNodeTree<TNode<Integer>, Integer>tree) {
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
    for(var node: root.children)
      if(res = search(node, data))
        break;
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
  * returns the index of the LCA
  * */
  private static int getIndexToLastCommonElement(final List<TNode<Integer>> path1, final List<TNode<Integer>> path2) {
    int index;
    for(index = 0; index < Math.min(path1.size(), path2.size()) && path1.get(index).equals(path2.get(index)); index++) ;
    return index;
  }

  /*
  * lowest common ancestor of two nodes in the tree
  * */
  public static Optional<TNode<Integer>> lca(final TNode<Integer> root, int val1, int val2) {
    List<TNode<Integer>> path1 = searchPath(root, val1), path2 = searchPath(root, val2);
    int index = getIndexToLastCommonElement(path1, path2);

    return
      Optional.ofNullable(index == 0 ? null : path1.get(index));
  }

  /*
  * sub vertices of a list is equals to the num of edges between them
  * dist(A,B) = dist(A, LCA(A,B)) + dist(B,LCA(A,B))
  * where dist(x,y) = position(y) - position(x) = #no of edges between x and y
  * */
  public static int edgesBetweenNodes(final TNode<Integer> root, int val1, int val2) {
    List<TNode<Integer>> path1 = searchPath(root, val1), path2 = searchPath(root, val2);
    int index = getIndexToLastCommonElement(path1, path2);
    return index != 0 ? path1.size()-index + path2.size()-index: -1;
  }

  /*
  * verify that shapes line up exactly using the root
  * nodes of each subtree by testing the size of the left nodes
  * of each of children of the tree A and B
  * */
  public static boolean isPerfectlyOverlappable(TNode<Integer> rootA, TNode<Integer> rootB) {
    if(rootA == null && rootB == null) return true;
    else if(rootA == null || rootB == null) return false;
    else if(rootA.children.size() != rootB.children.size()) return false;

    for(int index = 0; index < rootA.children.size(); index++)
      if (!(isPerfectlyOverlappable(rootA.children.get(index), rootB.children.get(index))))
        return false;
    return true;
  }

  /*
   * verify that shapes of the trees line up exactly
   * */
  public static boolean isPerfectlyOverlappable(final TNodeTree<TNode<Integer>, Integer> treeA,
                                                final TNodeTree<TNode<Integer>, Integer> treeB) {
    Objects.requireNonNull(treeA, "Argument must not be null");
    Objects.requireNonNull(treeB, "Argument must not be null");
    return isPerfectlyOverlappable(treeA.root, treeB.root);
  }

  /*
   * check if two trees are mirrors of each other
   * */
  public static boolean isMirror(final TNodeTree<TNode<Integer>, Integer> treeA,
                                 final TNodeTree<TNode<Integer>, Integer> treeB) {
    Objects.requireNonNull(treeA, "Argument must not be null");
    Objects.requireNonNull(treeB, "Argument must not be null");
    return isMirror(treeA.root, treeB.root);
  }

  /*
  * check if two subtrees are mirrors of each other by
  * testing the size at left and right extremities of treeA and treeB
  * respectively
  * */
  public static boolean isMirror(final TNode<Integer> rootA, final TNode<Integer> rootB) {
    if(rootA == null && rootB == null) return true;
    else if(rootA == null || rootB == null) return false;
    else if(rootA.children.size() != rootB.children.size()) return false;

    for(int index = 0, last = rootA.children.size() -1; index < rootA.children.size(); index++)
      if (!(isPerfectlyOverlappable(rootA.children.get(index), rootB.children.get(last-index))))
        return false;
    return true;
  }

  /*
  * check if a subtree is symmetric
  * by checking the extremities outside in for children in this root
  * each check comprises testing if this child $node has the same # of children as
  * its mirror child $nodeMirror
  * */
  public static boolean isSymmetric(final TNode<Integer> root) {
    if(root == null) return true;

    TNode<Integer> node, nodeMirror;
    for(int index = 0, size = root.children.size(); index <= size/2; index++){
      node = root.children.get(index);
      nodeMirror = root.children.get(size - 1 - index);
      if(node == nodeMirror)
        return true;
      else if(node.children.size() != nodeMirror.children.size())
        return false;
    }

    for(int index = 0, size = root.children.size(); index <= size/2; index++) {
      if(!isSymmetric(root.children.get(index))) return false;
    }
    return true;
  }

  /*
  * check if a subtree is symmetric
  * */
  public static boolean isSymmetric(final TNodeTree<TNode<Integer>, Integer> tree) {
    Objects.requireNonNull(tree, "Argument must not be null");
    return isSymmetric(tree.root);
  }


  /*
  * fill in extension fields at each level of the tree
  * w/ data relevant to that level
  * */
  private static void generateExtensionFields(final TNode<Integer> root, int depth) {
    if(root == null) return;
    for (TNode<Integer> node : root.children){
      root.min = root.min == null ? node.data : Math.min(root.min, node.data);
      root.max = root.max == null ? node.data : Math.max(root.max, node.data);
      root.height = Math.max(root.height, depth);
      root.size++;
      generateExtensionFields(node, depth+1);
    }
  }
}