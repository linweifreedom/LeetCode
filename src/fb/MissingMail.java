package fb;

/*You are the manager of a mail room which is frequently subject to theft. A period of NN days is about to occur, such that on the iith day, the following sequence of events will occur in order:
A package with a value of V_dollars will get delivered to the mail room (unless V= 0, in which case no package will get delivered).
You can choose to pay CC dollars to enter the mail room and collect all of the packages there (removing them from the room), and then leave the room
With probability SS, all packages currently in the mail room will get stolen (and therefore removed from the room).
Note that you're aware of the delivery schedule V_{1..N}, but can only observe the state of the mail room when you choose to enter it, meaning that you won't immediately be aware of whether or not packages were stolen at the end of any given day.
Your profit after the NNth day will be equal to the total value of all packages which you collected up to that point, minus the total amount of money you spent on entering the mail room.
Please determine the maximum expected profit you can achieve (in dollars).
Note: Your return value must have an absolute or relative error of at most 10^{-6}
  to be considered correct.*/
public class MissingMail {
	public double helper(int N, int[] V, int start, int C, double S, double pre) {
	    double current = pre + V[start];
	    if (start == N - 1) {
	      return Math.max(current - C, 0.0);
	    } else {
	      if (current <= C) {
	         return helper(N, V, start+1, C, S, current*(1 - S));
	      } else 
	        return Math.max(current - C + helper(N, V, start+1, C, S, 0.0), helper(N, V, start+1, C, S, current*(1 - S)));
	    }
	  }
}
