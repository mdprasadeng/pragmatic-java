package com.flipkart.lambda.test;

public class Manipulator {

  public static String apply(String input, StringManipulator stringManipulator) {
    return stringManipulator.manipulate(input);
  }
}
