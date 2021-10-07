package google;


//Find a permutation of numbers 1 through N such that average of any two numbers in the permutation does not occur between them
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation.printSequence(1, 0, 7);
	}
	
	public static void printSequence(int multiple, int decrement, int N) {
		if (2 * multiple - decrement > N) {
			System.out.println(multiple - decrement);
			return ;
		}
		printSequence(2 * multiple, decrement + multiple, N);
		printSequence( 2 * multiple, decrement, N);
	}

}
