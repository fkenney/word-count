package com.tlglearning.wordcount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void splitWords() {
    WordCounter counter = new WordCounter();
    String input  = "The dog jumped high as hell and bumped his head. Then he cried! ";
    String [] expected = {"the", "dog", "jumped", "high", "as", "hell", "and", "bumped", "his", "head", "then", "he", "cried"};
    String[] actual = counter.splitWords(input);

    assertArrayEquals(expected, actual);

  }

}