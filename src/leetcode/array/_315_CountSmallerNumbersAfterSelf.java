package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class _315_CountSmallerNumbersAfterSelf {
  int[] counts;
  Pair[] numIndexs;

  public List<Integer> countSmaller(int[] nums) {
    numIndexs = new Pair[nums.length];
    counts = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numIndexs[i] = new Pair(nums[i], i);
      counts[i] = 0;
    }
    mergeSort(0, nums.length - 1);
    List<Integer> result = new ArrayList<>();
    for (int i : counts)
      result.add(i);
    return result;
  }

  public void mergeSort(int start, int end) {
    if (start >= end)
      return;
    int mid = (start + end) / 2;
    mergeSort(start, mid);
    mergeSort(mid + 1, end);
    merge(start, mid, end);
  }

  public void merge(int start, int mid, int end) {
    int i = start, j = mid + 1, k = 0;
    Pair[] tmpArr = new Pair[end - start + 1];
    while (i <= mid && j <= end) {
      if (numIndexs[i].value <= numIndexs[j].value) {
        tmpArr[k++] = numIndexs[j++];
      } else {
        counts[numIndexs[i].index] += end - j + 1;
        tmpArr[k++] = numIndexs[i++];
      }
    }
    while (i <= mid) {
      tmpArr[k++] = numIndexs[i++];
    }
    while (j <= end) {
      tmpArr[k++] = numIndexs[j++];
    }
    for (int x = start; x <= end; x++) {
      numIndexs[x] = tmpArr[x - start];
    }
  }

  class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
