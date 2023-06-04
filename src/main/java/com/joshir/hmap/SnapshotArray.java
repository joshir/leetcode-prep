package com.joshir.hmap;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
  private static Snappy snappy;

  public SnapshotArray (int length) {
    snappy = new Snappy(length);
  }

  public int snap() {
    return snappy.snap();
  }

  public void set(int index, int val) {
    snappy.set(index, val);
  }

  public int get (int index, int snap_id) {
    return snappy.get(index, snap_id);
  }

  private static class Snappy {
    private static int snap = 0;
    private static Map<Integer, Integer>[] snapMap;

    @SuppressWarnings("unchecked")
    public Snappy (int len) {
      /*
      *  Arrays are reified in Java and arrays of generic classes
      *  will need to be type-cast in situ to their intended type when creating
      *  the object to make the compiler happy. It's an "unsafe" cast.
      * */
      snapMap = (Map<Integer, Integer>[]) new HashMap<?, ?>[len];
      for (int index = 0; index < len; index++){
        snapMap[index] = new HashMap<>();
      }
    }

    public void set(int index, int val) {
      snapMap[index].put(snap, val);
    }

    public int snap() {
      return ++snap;
    }

    public int get(int index, int snapId) {
      while(!snapMap[index].containsKey(snapId)) {
        snap--;
        if(snap == -1) return 0;
      }
      return snapMap[index].get(snap);
    }
  }
}
