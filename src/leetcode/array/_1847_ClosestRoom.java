package leetcode.array;

import java.util.Arrays;
import java.util.TreeSet;

public class _1847_ClosestRoom {
public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        Arrays.sort(rooms, (a,b) -> b[1] - a[1]);
        int m = queries.length;
        int n = rooms.length;
        int [][]query = new int[m][3];
        for(int i=0;i<m;i++){
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = i;
        }
        int []ans = new int[m];
        Arrays.sort(query, (a,b) -> b[1] - a[1]);
        TreeSet<Integer> ts = new TreeSet();
        int j = 0;
        for(int i=0;i<m;i++){
            while(j < n && rooms[j][1] >= query[i][1]){
                ts.add(rooms[j++][0]);
            }
            Integer floor = ts.floor(query[i][0]);
            Integer ceil = ts.ceiling(query[i][0]);
            if(floor == null && ceil == null){
                ans[query[i][2]] = -1;
            }else if(floor == null){
                ans[query[i][2]] = ceil;
            }else if(ceil == null){
                ans[query[i][2]] = floor;
            }else{
                ans[query[i][2]] = ((ceil - query[i][0]) < (query[i][0] - floor) ? ceil : floor);
            }
        }
        return ans;
    }
}
