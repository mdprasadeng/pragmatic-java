package com.flipkart.lambda.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LambdaTest {

  @Test
  public void innerClass() {
    String str = "flipkart";
    StringManipulator dotCom = new StringManipulator() {
      @Override
      public String manipulate(String input) {
        return input + ".com";
      }
    };

    assertEquals("flipkart.com", Manipulator.apply(str, dotCom));

  }

  @Test
  public void lambdaTest() {
    String str = "flipkart";
    StringManipulator dotCom = e -> e + ".com";

    assertEquals("flipkart.com", Manipulator.apply(str, dotCom) );

  }

  @Test
  public void comparatorLambda() {
    List<Integer> integers = Arrays.asList(2,3,4,5,1);
    Collections.sort(integers, (a,b) -> a-b);
    assertEquals(integers, Arrays.asList(5,4,3,2,1));
  }

}
