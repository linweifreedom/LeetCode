package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AscArray {
	public static void main(String[] args) {
	for (int[] arr : new int[][]{
	{1, 2, 3, 4, 5},
	{5, 4, 3, 2, 1},
	{1, 7, 7, 3, 5, 4},
	{1, 2, 7, 3, 3, 7, 3, 3, 7, 4, 5, 4},
	}) {
	System.out.println("getLongestSubarray(" + Arrays.toString(arr) + ") = " + getLongestSubarray(arr));
	}
	  }

	  // Time: Max(O(N), O(subarrays.size()^2)), where subarrays are all non-decreasing subarrays within input array.
	  // Space: O(N)
	  public static int getLongestSubarray(int[] arr) {
	if (arr.length == 0) {
	return 0;
	}

	// Breaks array into a list of non-decreasing subarrays.
	// Time: O(N), Space: O(N).
	List<List<Integer>> subarrays = new ArrayList<List<Integer>>();
	List<Integer> maxValueIndices = new ArrayList<Integer>();
	for (int i = 0; i < arr.length; ++i) {
	if (i == 0 || arr[i-1] > arr[i]) {
	  subarrays.add(new ArrayList<Integer>());
	  maxValueIndices.add(0);
	}
	List<Integer> subarray = subarrays.get(subarrays.size()-1);
	if (i == 0 || arr[i-1] < arr[i]) {
	  maxValueIndices.set(maxValueIndices.size()-1, subarray.size());
	}
	subarray.add(arr[i]);
	}

	// Finds changes to concat adjacent subarrays.
	// Time: O(subarrays.size()), Space: O(subarrays.size()).
	List<List<Change>> changes = new ArrayList<List<Change>>();
	for (int i = 0; i < subarrays.size()-1; ++i) {
	changes.add(new ArrayList<Change>());
	List<Integer> leftSubarray = subarrays.get(i);
	List<Integer> rightSubarray = subarrays.get(i+1);
	if (maxValueIndices.get(i) == 0 || leftSubarray.get(maxValueIndices.get(i)-1) <= rightSubarray.get(0)) {
	  changes.get(i).add(new Change(
	leftSubarray.get(leftSubarray.size()-1),
	maxValueIndices.get(i) == 0 ? Integer.MIN_VALUE : leftSubarray.get(maxValueIndices.get(i)-1),
	rightSubarray.get(0)
	  ));
	}
	if (maxValueIndices.get(i+1) == 0 || leftSubarray.get(leftSubarray.size()-1) < rightSubarray.get(1)) {
	  changes.get(i).add(new Change(
	rightSubarray.get(0),
	leftSubarray.get(leftSubarray.size()-1),
	maxValueIndices.get(i+1) == 0 ? Integer.MAX_VALUE : rightSubarray.get(1)
	  ));
	}
	}

	// Concats adjacent subarrays.
	// Time: O(subarrays.size()^2), Space: O(1).
	int maxLength = subarrays.get(subarrays.size()-1).size();
	for (int i = 0; i < changes.size(); ++i) {
	int concatLength = subarrays.get(i).size();
	Map<Integer, Change> merged = new HashMap<Integer, Change>();
	for (int j = i; j < changes.size(); ++j) {
	  Map<Integer, Change> newMerged = new HashMap<Integer, Change>();
	  for (Change change : changes.get(j)) {
	if (j == i) {
	newMerged.put(change.oldValue, change);
	continue;
	}
	if (!merged.containsKey(change.oldValue)) {
	continue;
	}
	Change mergedChange = merged.get(change.oldValue);
	mergedChange.minNewValue = Math.max(mergedChange.minNewValue, change.minNewValue);
	mergedChange.maxNewValue = Math.min(mergedChange.maxNewValue, change.maxNewValue);
	if (mergedChange.minNewValue > mergedChange.maxNewValue) {
	continue;
	}
	newMerged.put(mergedChange.oldValue, mergedChange);
	  }
	  merged = newMerged;
	  if (merged.isEmpty()) {
	break;
	  }
	  concatLength += subarrays.get(j+1).size();
	}
	if (maxLength < concatLength) {
	  maxLength = concatLength;
	}
	}
	return maxLength;
	  }

	  public static class Change {
	public int oldValue;
	public int minNewValue;
	public int maxNewValue;
	Change(int old, int minNew, int maxNew) {
	oldValue = old;
	minNewValue = minNew;
	maxNewValue = maxNew;
	}
	}
}
