package fb;

import java.util.PriorityQueue;

//给很多个坐标，找距离远点最近的k个。
public class FindKClosestPoint {
	public static int[][] findKClosestPoint (int[][] input, int k) {
		int[][] ans = new int[k][2];
		PriorityQueue<int[]> q = new PriorityQueue<>(k, (o1, o2) -> o1[0]*o1[0] + o1[1]*o1[1] -o2[0]*o2[0] - o2[1]*o2[1]);
		for (int[] i : input)
			q.offer(i);
		for (int i = 0; i < k; i++) {
			ans[i] = q.poll();
			System.out.println(ans[i][0] + ", " + ans[i][1]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] input = {{0,0},{1,0},{0,1},{5,2},{4,3},{5,6},{2,6}};
		findKClosestPoint(input, 5);
	}
}
