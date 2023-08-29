package com.joshir.ll;

public class PolynomialAddition {
  private static class PolyNode {
    int coefficient, power;
    PolyNode next = null;

    PolyNode() {}
    PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
    PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
  }

  // 2x2+ 4x + 3
  // 3x2 -4x - 1
  public PolyNode addPoly(PolyNode p1, PolyNode p2) {
    if(p1 == null) return p2;
    if(p2 == null) return p1;

    PolyNode head = new PolyNode(), temp = head, newNode = null;
    int sum, power;
    while(p1 != null && p2 != null) {
      if(p1.power > p2.power){
        temp.next = p1;
        temp = temp.next;
        p1 = p1.next;
      }
      else if (p1.power < p2.power){
        temp.next = p2;
        temp = temp.next;
        p2 = p2.next;
      }
      else {
        sum = p1.coefficient + p2.coefficient;
        power =  p1.power;
        p1 = p1.next;
        p2 = p2.next;
        if (sum != 0) {
          temp.next = new PolyNode(sum, power);
          temp = temp.next;
        }
      }
    }

    temp.next = p1 == null ? p2: p1;
    return head.next;
  }

  public static void main(String[] args) {
    // [[2,2],[4,1],[3,0]]
    //PolyNode p1 = new PolyNode(2,2, new PolyNode(4,1, new PolyNode(3,0)));

    // [[3,2],[-4,1],[-1,0]]
    //PolyNode p2 = new PolyNode(3,2, new PolyNode(-4,1, new PolyNode(-1,0)));

    PolyNode p1 = new PolyNode(1,1);
    PolyNode p2 = new PolyNode(1,0);

    PolyNode p3 =new PolynomialAddition().addPoly( p1, p2);

    while(p3!=null) {
      System.out.println(p3.coefficient+"x"+p3.power);
      p3 = p3.next;
    }
  }
}
