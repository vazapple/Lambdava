/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.lambdava.streams;

import com.opengamma.util.functional.EqualityUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.opengamma.lambdava.streams.Lambdava.functional;
import static org.testng.Assert.assertTrue;

@Test
public class FunctionalStreamTest {


  @Test
  public void sort() {
    final List<String> strings = Arrays.asList("z", "d", "a");
    final List<String> sortedStrings = functional(strings).sort().asList();

    assertTrue(EqualityUtil.equal(sortedStrings, Arrays.asList("a", "d", "z")));
  }

  @Test
  public void sortNonComparable() {
    final List<Object> objects = Arrays.asList(new Object(), new Object(), new Object());
    final List<Object> sortedObjects = functional(objects).sort().asList();

    System.out.println(sortedObjects);
  }


  @Test
  public void sortBy() {
    final List<String> strings = Arrays.asList("z", "d", "a");
    final List<String> sortedStrings = functional(strings).sortBy(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.equals("d") && !o2.equals("d")) {
          return -1;
        } else if (!o1.equals("d") && o2.equals("d")) {
          return 1;
        } else {
          return o1.compareTo(o2);
        }
      }
    }).asList();

    assertTrue(EqualityUtil.equal(sortedStrings, Arrays.asList("d", "a", "z")));
  }
}
