package joshir.tree.gen;

import java.util.*;

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
    60, 601, 6001, -1, 6002, -1, -1, -1, -1
  );

  private static final List<Integer> mirror = List.of(
    1,
    2, 22, 2223, -1, 2224, -1, -1, -1,
    3, 33, -1, 34, -1, 35, -1, 36, -1, -1,
    4, 44, -1, 45, -1, -1,
    5, 55, -1, 56, -1, -1, -1
  );

  private static final List<Integer> symmetric = List.of(
    1,
    4, 44, -1, 45, -1, -1,
    3, 33, -1, 34, -1, 35, -1, 36, -1, -1,
    5, 55, -1, 56, -1, -1, -1
  );

  private static class TNode<T extends Comparable<? super T>> {
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

  private static final class TNodeExt<T extends Comparable<? super T>> extends TNode<T> {

    int max = Integer.MAX_VALUE;

    int min = Integer.MIN_VALUE;

    int size = 0;

    int height = 0;
    final List<TNodeExt<T>> children = new ArrayList<>();

    TNodeExt(T data) {
      super(data);
    }
  }

  /*
  * Reusable Tree class where E represents node TNode or any extension of the TNode class
  * K represents a manifestation of Comparable which either implements this interface
  * or doesn't, in which case it's super class must. This narrows down K to a particular type
  * but also relaxes the restriction
  * */
  private static class TNodeTree<E extends TNode<K>, K extends Comparable<? super K>> {
    /* package public by default */
    final E root;
    /* package public by default */
    TNodeTree(E root) {
      this.root = root;
    }
  }

  public static void main(String[] args) {
    TNodeTree<TNode<Integer>, Integer> oTree = generate(tree);
    TNode<Integer> root = oTree.root;
    TNodeTree<TNode<Integer>, Integer> nTree = copy(oTree);
    System.out.println("size " + size(root));
    System.out.println("max " + maximum(root));
    System.out.println("edge height " + edgeLength(root));
    displayTreeBreadth(root);
    displayTreeBreadth(nTree.root);
    System.out.println(isPerfectlyOverlappable(oTree, nTree));
    System.out.println(isMirror(oTree, generate(mirror)));
    System.out.println(isSymmetric(generate(symmetric)));
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
  public static TNodeTree<TNode<Integer>, Integer> generate(List<Integer> tree) {
    TNodeTree<TNode<Integer>, Integer> top = null;
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
  private static int getIndexToLastCommonElement(List<TNode<Integer>> path1, List<TNode<Integer>> path2) {
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
  public static boolean isMirror(TNode<Integer> rootA, TNode<Integer> rootB) {
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
  public static boolean isSymmetric(TNode<Integer> root) {
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
    return isSymmetric(tree);
  }
}