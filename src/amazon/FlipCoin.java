package amazon;

//Flip coin , use minimized times to make all H in front and T in end
public class FlipCoin {
	// for the input string, scan it from left to right, when the character is T, continue move. 
	//if the character is H, we can 1. flip all the T before this character to be H. or 2. flip this character to be T
	//countT will be used to store the count of T before this character.
	// For example "HHTHTT" , set i as the index of the character. i = 0, countT = 0, flip = 1. So for the first character "H", don't flip it.
	// i = 3 , countT = 1, flip = 1, so the min(countT, flip) = 1; All of the characters after i = 3 are "T", so the final result will be 1.
	
	public static int minFlipsMonoIncr(String s) {
        int countT = 0;
        int flip = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T') {
            	countT++;
            } else
                flip++;
            flip = Math.min(countT, flip);
        }
        return flip;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FlipCoin.minFlipsMonoIncr("HHTHTT"));
		System.out.println(FlipCoin.minFlipsMonoIncr("HHHHTT"));
		System.out.println(FlipCoin.minFlipsMonoIncr("HTTHTT"));
		System.out.println(FlipCoin.minFlipsMonoIncr("HHTHTTHHHHT"));
	}

}
