package joshir.stack;


import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackViaTwoQueues<T> {

  /*
  * This is kind of sloppy since queues have a natural order (FIFO)
  * whereas stacks have reverse order (LIFO) which means using two queue
  * will require more shuffling of data between the two queues than
  * creating a que with two stacks.
  *
  * everytime we peek or pop data is transferred from one queue to another
  * */
  static class DoubleQStack<T> {

    final LinkedList<T> q1 = new LinkedList<>();

    final LinkedList<T> q2 = new LinkedList<>();

    T peeky = null;

    /*
    * either q1 is empty or q2 is empty
    * push the next element to the queue that is not empty to maintain order.
    * */
    void push(T item){
      if(!q1.isEmpty()){
        if (peeky != null)
          q1.add(peeky);
        q1.add(item);
      }
      else {
        if(peeky != null )
          q2.add(peeky);
        q2.add(item);
      }
      peeky = null;
    }

    /*
    * if peeky has not been set, get value from queues by shuffling
    * if peeky has a value, return the value after setting peeky
    * */
    T pop(){
      if(q1.isEmpty() && q2.isEmpty()) throw new EmptyStackException();
      T item = (peeky == null) ?shuffle(q1.isEmpty()? q1: q2, !q1.isEmpty()? q1: q2) : peeky;
      peeky = null; /* set it back to null for next call to peek() */
      return item;
    }

    /*
    * remove that 1 element from the front even for peek()
    * but do store it in the peeky variable
    * one queue is always empty so that stack order of LIFO can be achieved
    * through shuffling.
    * */
    T peek(){
      if(q1.isEmpty() && q2.isEmpty()) throw new EmptyStackException();
      peeky = (peeky == null)? shuffle(q1.isEmpty()? q1: q2, !q1.isEmpty()? q1: q2) : peeky;
      return peeky;
    }

    /*
    * deque items from q1 to q2.
    * and then deque remaining item,
    * so the whole thing acts as a stack.
    *
    *    pre extraction q1: 1,2,3,4,5 <-------- order of insertion is the order of extraction
    *                   q2: empty
    *
    *    post extraction q1: 5 <------- emptied out all elements except 1
    *                    q2: 1,2,3,4 <------- insertion order is still the same
    * */
    private T shuffle(LinkedList<T> to, LinkedList<T> from) {
      while(from.size()!=1) {
        to.add(from.removeFirst());
      }
      return from.removeFirst();
    }

    int size() {
      return (q1.size() != 0) ? q1.size() : q2.size();
    }
  }
}
