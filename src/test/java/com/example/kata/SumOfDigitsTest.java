package com.example.kata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SumOfDigitsTest {

  @Test
  public void givenEmptyInput_returnsEmptyOutput() {
    assertArrayEquals(new int[]{}, SumOfDigits.distinct(new int[]{}));
  }

  @Test
  public void givenOneNumber_returnsNumber() {
    assertArrayEquals(new int[]{3}, SumOfDigits.distinct(new int[]{3}));
  }

  @Test
  public void givenDistinctSumOfDigits_returnsInput() {
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
        SumOfDigits.distinct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
  }

  @Test
  public void givenMultipleNumbersWithSameNumberOfDigits_returnsFirstNumber() {
    assertArrayEquals(new int[]{1},
        SumOfDigits.distinct(new int[]{1, 10}));

    assertArrayEquals(new int[]{20},
        SumOfDigits.distinct(new int[]{20, 2, 200, 2000}));
  }

  @Test
  public void givenBigInput_reusltContains10Elements() {
    assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        SumOfDigits.distinct(ascendingNumbers(0, 99999)));
  }

  private int[] ascendingNumbers(int from, int to) {
    List<Integer> result = new ArrayList<>();
    for (int i = from; i < to; i++) {
      result.add(i);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }


  @Test
  public void sumOfDigits() {
    assertEquals(0, SumOfDigits.calculate(0));
    assertEquals(1, SumOfDigits.calculate(1));
    assertEquals(2, SumOfDigits.calculate(11));
    assertEquals(8, SumOfDigits.calculate(224));
    assertEquals(3, SumOfDigits.calculate(123456));
  }


}
