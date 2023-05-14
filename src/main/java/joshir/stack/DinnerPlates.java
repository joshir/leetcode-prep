package joshir.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class DinnerPlates {

  /* list of stacks of plates */
  private static final LinkedList<LinkedList<Integer>> listOfStacks = new LinkedList<>();

  /* number of plates in a stack for this stack */
  private final int capacity;

  public DinnerPlates(int capacity) {
    this.capacity = capacity;
  }

  /* push on stack of stacks*/
  public void push(int val) {
    LinkedList<Integer> stack = listOfStacks.getLast();
    if(stack == null || stack.size() > capacity) {
      listOfStacks.add(new LinkedList<>());
    }
    listOfStacks.getLast().add(val);
  }

  /* pop stack of stacks*/
  public int pop() {
    LinkedList<Integer> stack = listOfStacks.getLast();
    if(stack == null) throw new EmptyStackException();
    if(stack.size() == 0) {
      listOfStacks.removeLast();
      stack = listOfStacks.getLast();
    }
    return stack.removeLast();
  }

  /*
   * if the element was removed from the top of a "middle" stack
   * then shift over elements from other stacks to this stack
   * and rinse and repeat maintaining the size constraint
   * */
  public int popAtStack(int index) {
    LinkedList<Integer> stack = listOfStacks.get(index);
    int retVal =  stack.removeLast();

    while (index < listOfStacks.size()) {
      if( stack.size() < capacity )
        stack.push(listOfStacks.get(index + 1).removeFirst());
      else stack = listOfStacks.get(index + 1);
      index++;
    }
    if (listOfStacks.getLast().isEmpty()) listOfStacks.removeLast();
    return retVal;
  }
}
