package com.example.kata;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfDigits {

  public static int[] distinct(int[] numbers) {
    List<Integer> sumOfDigits = sumOfDigits(numbers);

    List<Integer> result = IntStream.range(0, numbers.length)
        .filter(i -> isFirstOccurrenceForSumOfDigit(sumOfDigits, i))
        .mapToObj(number(numbers))
        .collect(Collectors.toList());

    return toArray(result);
  }

  private static List<Integer> sumOfDigits(int[] numbers) {
    return Arrays.stream(numbers)
        .map(SumOfDigits::calculate)
        .boxed()
        .collect(Collectors.toList());
  }

  private static IntFunction<Integer> number(int[] numbers) {
    return i -> numbers[i];
  }

  private static boolean isFirstOccurrenceForSumOfDigit(List<Integer> sumOfDigits, int index) {
    int sumOfDigit = sumOfDigits.get(index);
    return index == sumOfDigits.indexOf(sumOfDigit);
  }

  private static int[] toArray(List<Integer> result) {
    return result.stream().mapToInt(x -> x).toArray();
  }

  static int calculate(int number) {
    int result = Arrays.stream(digits(number))
        .mapToInt(Integer::parseInt)
        .sum();

    if (result < 10) {
      return result;
    }
    return calculate(result);
  }

  private static String[] digits(int number) {
    return Integer.toString(number).split("");
  }
}
