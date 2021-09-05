package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string of length n consisting of digits [0-9], count the number of ways the given string
 * can be split into prime numbers, each of which is in the range 2 to 100 inclusive. Since the
 * answer can be large, return the answer modulo 109 + 7. Note: A partition that contains numbers
 * with leading zeroes will be invalid and the initial string does not contain leading zeroes. Take
 * for example the input string to be s = "11373", then this string can be split into 6 different
 * ways as [11, 37, 3), [113, 7, 3), [11, 3, 73), [11, 37, 3), (113, 73) and [11, 373) where each
 * one of them contains only prime numbers.
 * 
 * Input Format For Custom Testing The first and only line contains the string, s. Sample Case 0
 * 
 * Sample Input
 * 
 * For Custom Testing 3175
 * 
 * Sample Output Explanation The 3 ways to split this string into prime numbers are (31, 7,5), (3,
 * 17, 5), (317,5)
 */
public class PrimeNumber {
  private Set<Integer> set = new HashSet<>();
  public boolean isPrimeNumber(int number) {
    if (set.contains(number))
      return true;
    if (number <= 1) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    for (int i = 3; i <= number/2; i = i + 2) {
      if (number % i == 0)
        return false;
    }
    set.add(number);
    return true;
  }
  
  public List<List<Integer>> findPrimeNumber(String input) {
    List<List<Integer>> result = new ArrayList();
    findPrimeNumberHelper(input, new ArrayList<>(), result);
    return result;
  }
  
  public void findPrimeNumberHelper(String s, List<Integer> preList, List<List<Integer>> result) {
    if (s.length() == 0) {
      result.add(new ArrayList<>(preList));
      System.out.println(result.toString());
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      String numberString = s.substring(0, i + 1);
      int num = Integer.valueOf(numberString);
      if (isPrimeNumber(num)) {
        preList.add(num);
        findPrimeNumberHelper(s.substring(i + 1), preList, result);
        preList.remove(preList.size() - 1);
      }
    }
  }
  
  public static void main(String[] args) {
    //String input = "3175";
    String input = "11373";
    PrimeNumber instance = new PrimeNumber();
    System.out.println(instance.findPrimeNumber(input).size());
  }
}
