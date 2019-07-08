package leetCode.Kth.Largest.Element.in.a.Stream;

public class TestMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		KthLargest kLarge = new KthLargest(2, nums);
		System.out.println(kLarge.add(-1));
		System.out.println(kLarge.add(1));
		System.out.println(kLarge.add(-2));
		System.out.println(kLarge.add(-4));
		System.out.println(kLarge.add(3));
	}

}
