package com.flipkart.stream.test;

import org.junit.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class ReduceTest {

  @Test
  public void reduceMax() {

    BinaryOperator maxOperator = (a, b) -> a;
    assertEquals(maxOperator.apply(3, 5), 5);
    assertEquals(maxOperator.apply(3, -5), 3);

    Optional<Integer> max = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .reduce(maxOperator);

    assertEquals((Integer) 10, max.get());

    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .mapToInt(e -> e)
        .max();

  }


  private Integer getOctalValueOf(String input) {
    BinaryOperator<Integer> octalReduction = (a, b) -> b;

    return Stream.of(input.split(""))
        .map(Integer::valueOf)
        .reduce(octalReduction).get();

  }

  @Test
  public void reduceOctaDecimal() {
    assertEquals((Integer)4, getOctalValueOf("4"));
    assertEquals((Integer)12, getOctalValueOf("14"));
    assertEquals((Integer)132, getOctalValueOf("204"));
  }
}
