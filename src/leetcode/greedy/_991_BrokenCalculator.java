package leetcode.greedy;

public class _991_BrokenCalculator {

	public static void main(String[] args) {
		System.out.println(brokenCalc(1, 1000000000));
	}

	public static int brokenCalc(int X, int Y) {
		int count = 0;
        if (X >= Y) return X- Y;
        while (Y > X) {
            if (Y % 2 == 1) {
                Y = Y + 1;
                count++;
            }
            Y = Y / 2;
            count++;
        }
        if (Y < X) count += X - Y;
        return count;
    }
}
