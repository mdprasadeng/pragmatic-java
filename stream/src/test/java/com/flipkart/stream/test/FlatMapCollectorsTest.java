package com.flipkart.stream.test;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class FlatMapCollectorsTest {

  @Test
  public void wordCount() throws URISyntaxException, IOException {

    //use flatMap
    int wordsCount = 0;
    Files.lines(Paths.get(getClass().getResource("/sample.txt").toURI()));

    assertEquals(26, wordsCount);
  }

  @Test
  public void capitalCount() throws URISyntaxException, IOException {

    //use mapToInt
    int captials = 0;
    Files.lines(Paths.get(getClass().getResource("/sample.txt").toURI()));

    assertEquals(9, captials);
  }

  @Test
  public void firstWordMap() throws URISyntaxException, IOException {

    //use Collectors.toMap or Collectors.groupingBy

    Map<String, String> firstWordMap =
        Files.lines(Paths.get(getClass().getResource("/sample.txt").toURI()))
            .collect(Collectors.toMap(e -> e.split(" ")[0], e -> e));

    Map<String, String> expectedFirstWordMap = new HashMap<>();
    expectedFirstWordMap.put("This","This is a SAMPLE file");
    expectedFirstWordMap.put("In", "In which SOME words ARE captilized for NO particular reason.");
    expectedFirstWordMap.put("THIS","THIS will be USED as SAMPLE for learning STREAMS AND collectors");

    assertEquals(expectedFirstWordMap, firstWordMap);
  }

  @Test
  public void capitalDetailCount() throws URISyntaxException, IOException {

    //Using Collectors.groupingBy
    Map<String, Long> capitalDetailCount = new HashMap<>();
     Files.lines(Paths.get(getClass().getResource("/sample.txt").toURI()));


    Map<String, Long> expectedCounts = new HashMap<>();
    expectedCounts.put("THIS", 1L);
    expectedCounts.put("USED", 1L);
    expectedCounts.put("ARE", 1L);
    expectedCounts.put("AND", 1L);
    expectedCounts.put("STREAMS", 1L);
    expectedCounts.put("SOME", 1L);
    expectedCounts.put("NO", 1L);
    expectedCounts.put("SAMPLE", 2L);

    assertEquals(expectedCounts, capitalDetailCount);
  }

  @Test
  public void firstLongLine() throws URISyntaxException, IOException {
    //Long line means length more than 30 characters

     String firstLongLine = Files.lines(Paths.get(getClass().getResource("/sample.txt").toURI()))
        .filter(e -> {
          System.out.println("Processing: " + e);
          return e.length() > 30;
        })
        .findFirst().get();


    assertEquals("In which SOME words ARE captilized for NO particular reason.", firstLongLine);

  }
}
