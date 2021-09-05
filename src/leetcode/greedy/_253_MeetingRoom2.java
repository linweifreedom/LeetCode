package leetcode.greedy;

import java.util.Arrays;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.*/
public class _253_MeetingRoom2 {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	 }
	//Time O(nlogn)
	public int minMeetingRooms(Interval[] intervals) {
		int n = intervals.length;
		int[] start = new int[n], end = new int[n];
		int rooms = 0;
		int endIter = 0;
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		for (int i = 0; i < n; i++) {
			if (start[i] < end[endIter])
				rooms++;
			else
				endIter++;
		}
		return rooms;
	}
}
 