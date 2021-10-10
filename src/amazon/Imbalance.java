package amazon;

import java.util.Stack;

/*In one such delivery center, parcels are placed in a sequence where the ith parcel has a weight of weight[i]. A shipment is consituted of a contiguous segment of parcels. The shupment imbalance of a shipment is defined as the difference between the max and min weights within a shipment.

Given the arrangement of parcels, find the sum of shipment imbalance of all the shipments that can be formed from the given sequence of parcels.

Example
weights = [1,3,2]

The shipment imbalance calculations for each possible shipment are shown below.*

Shipments	MaxWeight	MinWeight	Imbalance
1 	    	1	            1	    1-1=0
3			3				3		3-3=0
2			2				2		2-2=0
1, 3		3				1		3-1=2
3, 2		3				2		3-2=1
1, 3, 2		3				1		3-1=2
The total imbalance is 0+0+0+2+1+2 = 5*/
public class Imbalance {
	//sum of Imbalance is equal to sum of MaxWeight - Sum of Min Weight. So we can calculate these two sum through mono Stack.
	//For every new number we need to remove all previous values from our stack that are lower / higher multiplied with the number of subarrays that they were the minimum / maximum for.
	//Then we add our new number to the stack and increase the accumulated sum in the same fashion by the covered length.
	public static int findImbalance(int[] weights){
	    int n = weights.length;
	    long maxSum = 0, minSum = 0;
	    
	    Stack<Integer> monoStack = new Stack<>();
	    
	    // Finding sum of minimum elements in each subarray
	    for(int i=0;i<=n;i++){
	        while(!monoStack.isEmpty() && (i==n || weights[monoStack.peek()]>weights[i])){
	            int idx = monoStack.pop();
	            int leftCount =  idx - (!monoStack.isEmpty() ? monoStack.peek() : -1) - 1;
	            int rightCount = i - idx - 1;
	            minSum += (1L*leftCount + rightCount + leftCount*rightCount + 1)*weights[idx];
	        }
	        if(i<n) monoStack.push(i);
	    }
	    
	    // Finding sum of maximum elements in each subarray
	    for(int i=0;i<=n;i++){
	        while(!monoStack.isEmpty() && (i==n || weights[monoStack.peek()]<weights[i])){
	            int idx = monoStack.pop();
	            int leftCount =  idx - (!monoStack.isEmpty() ? monoStack.peek() : -1) - 1;
	            int rightCount = i - idx - 1;
	            maxSum += (1L*leftCount + rightCount + leftCount*rightCount + 1)*weights[idx];
	        }
	        if(i<n) monoStack.push(i);
	    }
	    
	    return (int)(maxSum - minSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,3,2};
		System.out.println(Imbalance.findImbalance(test));
	}

}
