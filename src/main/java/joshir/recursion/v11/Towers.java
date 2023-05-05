package joshir.recursion.v11;

public class Towers {
  public static void main(String[] args) {
    moveDisks(2, 'A','B','C');
  }


  // move disks from tower A to tower B using tower C
  public static void moveDisks(int n, char source, char dest, char aux) {
    if( n <= 0  ) return;
    moveDisks(n-1, source, aux, dest);
    System.out.println("moving disk " + n + " from "+source+" to "+ dest);
    moveDisks(n-1, aux, dest, source);
  }


}
