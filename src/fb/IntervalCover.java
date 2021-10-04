package fb;

import java.util.Arrays;

//����һ��interval [1, 10]�� ���ڶ���list of interval [[1,2], [2,3] , [5,10]]
//�õڶ���interval ���Ը��ǵ�һ��interval�����ȫ���������ˣ���һ��interval���ж���ģ�����true�� ���ȫ���������˷���false�� ��������� ��Ϊ3-5 û�б�����ס�����Է���true��
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
