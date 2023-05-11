package joshir.tree.btree;

import java.util.LinkedList;
import java.util.List;

public class BTreeGen {
  /*
   *
   *              301
   *        30*           3002
   *              300*
   *                      3001
   *    10*
   *
   *
   *        40*           4002
   *              401*
   *                      4001
   *
   *      *- non-leaf vertices
   * */
  private static final List<Integer> tree = List.of(10,
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
}
