package amazon;

public class ContniouslyDecreasing {

	public static int countSequences(int[] ratings) {
        int count = 0;
        int current = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0 || ratings[i - 1] - ratings[i] == 1) {
                current++;
            }
            else {
                count += getTriangleNumber(current);
                current = 1;
            }
        }
        
        count += getTriangleNumber(current);
        return count;
    }
    
	static int getTriangleNumber(int n) {
        return n * (n + 1)/2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(ContniouslyDecreasing.countSequences(new int[] { 4,3,5,4,3 }));
	}

}
