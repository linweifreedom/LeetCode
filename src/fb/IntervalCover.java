package fb;

import java.util.Arrays;

//给第一个interval [1, 10]， 给第二个list of interval [[1,2], [2,3] , [5,10]]
//用第二个interval 尝试覆盖第一个interval。如果全部覆盖完了，第一个interval还有多余的，返回true。 如果全都被覆盖了返回false。 上面的例子 因为3-5 没有被覆盖住，所以返回true。
public class IntervalCover {
	public static boolean intervalCover(int[] interval1, int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		int n = intervals.length;
		if (intervals[0][0] < interval1[0]) return false;
		int i = 0; int j = 1; boolean findGap = false;
		while (j < n) {
			if (intervals[i][1] < intervals[j][0] - 1) {
				//find gap
				findGap = true;
			}
			if (intervals[i][1] >= intervals[j][1]) {
				j++;
			} else {
				i = j;
				j++;
			}
		}
		if (intervals[0][0] >= interval1[0] && intervals[i][1] <= interval1[1] && findGap)
			return true;
		else if ((intervals[0][0] > interval1[0] && intervals[i][1] <= interval1[1]) || intervals[i][1] < interval1[1])
			return true;
		return false;
		
	}
	
	public static void main(String[] args) {
		int[] interval = {1, 10};
		int[][] intervals = {{2, 2},{2, 3},{5, 10},{2, 5}};
		System.out.println(intervalCover(interval, intervals));
	}
}
