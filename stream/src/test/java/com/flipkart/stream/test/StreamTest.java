package com.flipkart.stream.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class StreamTest {

  @Test
  public void basics() {
    List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    integers.stream().forEach(e -> System.out.println(e));

    List<Integer> doubleIntegers = integers.stream().map(e -> e * 2).collect(Collectors.toList());
    assertEquals(doubleIntegers, Arrays.asList(2,4,6,8,10,12,14,16,18,20));

    List<Integer> evenNumbers = integers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
    assertEquals(evenNumbers, Arrays.asList(2,4,6,8,10));

    Optional<Integer> reduce = integers.stream().reduce((a, b) -> a + b);
    assertEquals(reduce.get(), (Integer)55);

  }

}
