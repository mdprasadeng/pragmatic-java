package com.flipkart.collections.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CollectionsTest {

  @Test
  public void iteration() {
    Collection<Integer> integers = Arrays.asList(1,2,3,4,5);

    Iterator<Integer> iterator = integers.iterator();

    /*
    iterator.hasNext();
    iterator.next();
    iterator.remove();
    */
    while (iterator.hasNext()) {
      System.out.println("Element value using iterator: " + iterator.next());
    }

    for (Integer integer : integers) {
      System.out.println("Element value using forloop : " + integer);
    }

    assertEquals(true, true);
  }

  @Test
  public void sort() {
    List<Integer> integers = Arrays.asList(4,1,5,3,2);

    Collections.sort(integers);
    assertEquals( Arrays.asList(1,2,3,4,5), integers);

    Collections.sort(integers, Collections.reverseOrder());
    assertEquals( Arrays.asList(5,4,3,2,1), integers);

    Collections.shuffle(integers);

    Collections.sort(integers, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        // 2 4 1 3 5
        return 0;
      }
    });
    assertEquals( Arrays.asList(2,4,1,3,5), integers);

  }






}
