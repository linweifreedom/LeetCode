package google;

public class _1526_MinimumNumberofIncrementsonSubarraysFormaTargetArray {
	 public int minNumberOperations(int[] target) {
	        int pre = 0; int count = 0;
	        for (int cur : target) {
	            count += Math.max(0, cur - pre);
	            pre = cur;
	        }
	        return count;
	        
	    }
}
