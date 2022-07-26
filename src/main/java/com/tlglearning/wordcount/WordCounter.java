package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public final class WordCounter {

  private final Map<String, Integer> counts = new HashMap<>();
  private int totalWords;


  public Set<String> words(){
    return counts.keySet();
  }

  public int get(String word){
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text){
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      countWords(splitWords(trimmedLine));
    }
  }

  public int size (){
    return counts.size();
  }

  public int total(){
    return totalWords;
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");
  }

  void countWords(String[] words) {
    Arrays
        .stream(words)
        .map(String::trim)
        .filter((word) -> !word.isEmpty())
        .filter((word) -> word.length() > 5)
//        .filter(Predicate.not(String::isEmpty))
        .forEach((word) -> counts.put(word, 1 + counts.getOrDefault(word, 0)));

  }

  @Override
  public String toString() {
    return counts.toString();
  }
}
