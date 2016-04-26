package com.flipkart.lambda.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FunctionTest {

  static List<String> SUBJECT = Arrays.asList(
      "{{Name}}",
      "Welcome",
      "to",
      "Flipkart"
  );

  static String MSG_SEPERATOR = " ";

  /* Convert the below method to a pure function

  A Pure Function - has no side effects
  #No external variables
  #Doesn't manipulate arguments
  #Output is always deterministic and thereby reproducable
  #Doesn't nothing extra - no write to log etc


  */
  public static String getSubject(String name) {
    SUBJECT.set(0, name);
    return String.join(MSG_SEPERATOR, SUBJECT);
  }

  @Test
  public void subjectTest() {
    assertEquals("UserA Welcome to Flipkart", getSubject("UserA"));
    assertEquals("UserB Welcome to Flipkart", getSubject("UserB"));
  }

}
