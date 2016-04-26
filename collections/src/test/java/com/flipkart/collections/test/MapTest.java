package com.flipkart.collections.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;


public class MapTest {

  @Test
  public void simple() {
    Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
    String msg = "one two one one two two three";


    for (String str : msg.split(" ")) {
      int count = wordCountMap.getOrDefault(str, 0);
      wordCountMap.put(str, count +1);
    }


    Map<String, Integer> expected = new HashMap<String, Integer>();
    expected.put("one", 3);
    expected.put("two", 3);
    expected.put("three", 1);

    assertEquals(expected, wordCountMap);

  }

  @Test
  public void treeMap() {
    TreeMap<String, Integer> wordCountMap = new TreeMap<String, Integer>();
    String msg = "candy apple donut banana banana donut";


    for (String str : msg.split(" ")) {
      int count = wordCountMap.getOrDefault(str, 0);
      wordCountMap.put(str, count +1);
    }


    assertEquals("donut", wordCountMap.lastKey());
    assertEquals("apple", wordCountMap.firstKey());

    Map<String, Integer> expected = new HashMap<String, Integer>();
    expected.put("apple", 1);
    expected.put("banana", 2);

    assertEquals(expected, wordCountMap.headMap("candy"));

  }
}
