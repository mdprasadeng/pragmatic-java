package com.flipkart.stream.test;

import org.junit.Test;

import java.util.stream.Stream;

public class CollectorsTest {

  @Test
  public void test() {

    Stream.of(new String[]{"This", "is", "a", "sample", "sentence"});
        //.collect(Collectors.joining(" "))
        //.collect(Collectors.toList())
        //.collect(Collectors.toMap(e -> e, e -> e.length()));


  }
}
