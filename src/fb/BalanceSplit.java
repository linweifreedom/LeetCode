package fb;

import java.util.Arrays;

public class BalanceSplit {

	  boolean balancedSplitExists(int[] arr) {
	    // Write your code here
	    Arrays.sort(arr);
	    if (arr.length < 2) return false;
	    int left = 0; int right = arr.length - 1;
	    int leftSum = arr[0], rightSum = arr[right];
	    while (left < right - 1) {
	      while (left < right - 1 && (leftSum < rightSum || arr[left] == arr[left + 1])) {
	        left++;
	        leftSum += arr[left];
	      }
	      while (right > left + 1 && (rightSum <= leftSum || arr[right] == arr[right - 1])) {
	        right--;
	        rightSum += arr[right];
	      }
	    }
	    return leftSum == rightSum ? true : false;
	  }











	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom.
	  int test_case_number = 1;
	  void check(boolean expected, boolean output) {
	    boolean result = (expected == output);
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      System.out.print(expected); 
	      System.out.print(" Your output: ");
	      System.out.print(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printString(String str) {
	    System.out.print("[" + str + "]");
	  }
	  
	  public void run() {
	    int arr_1[] = {2, 1, 2, 5};
	    boolean expected_1 = true;
	    boolean output_1 = balancedSplitExists(arr_1); 
	    check(expected_1, output_1); 

	    int arr_2[] = {3, 6, 3, 4, 4};
	    boolean expected_2 = false;
	    boolean output_2 = balancedSplitExists(arr_2); 
	    check(expected_2, output_2); 
	    
	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) {
	    new BalanceSplit().run();
	  }
}
