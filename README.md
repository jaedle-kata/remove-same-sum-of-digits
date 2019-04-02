# TDD Kata: Remove elements with duplicate sum of digits

## Sum of digits (Deutsch: _Quersumme_)

Sum up each individual digit of a number until it has only one digit

```
- 0 --> 0
- 1 --> 1 = 1
- 11 --> 1+1 = 2
- 55 --> 5+5 = 10 --> 1 + 0 = 1
- 5678 --> 5+6+7+8 = 26 ---> 2 + 6 = 8
```

## Task

Write a function that accepts an array of numbers and removes each multiple of numbers which have the same sum of digits 

`int[] DuplicateSumOfDigitsRemove.remove(int[] numbers)`

1. Order has to remain the same
2. Retain the first element, remove the 2nd (3rd, ...) occurrence with same sum of digits
3. Obviously there can't be more than 10 elements in the list after processing ;)

## Examples

```
input --> output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0] --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
[1, 2, 10, 11] --> [1, 2]
[10, 11, 1 , 2] --> [10, 11]
[1, 10, 100, 1000] --> [1]
 ```