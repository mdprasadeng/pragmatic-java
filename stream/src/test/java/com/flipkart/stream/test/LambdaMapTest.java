package com.flipkart.stream.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class LambdaMapTest {

  @Test
  public void letterCounter() {
    List<Integer> letterCounts = Stream.of(new String[]{"This", "is", "a", "sample", "sentence"})
        .map(e -> 1)
        .collect(Collectors.toList());

    assertEquals(Arrays.asList(4, 2, 1, 5, 8), letterCounts);
  }

  @Test
  public void decimalList() {
    List<Double> decimalList = Stream.of(new Double[]{2.3, 3.4, 5.23, 6.08})
        .map(e -> e % 1)
        .collect(Collectors.toList());

    assertEquals(Arrays.asList(0.3, 0.4, 0.23, 5, 0.08), decimalList);
  }

}
