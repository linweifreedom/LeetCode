package leetcode.graph;

import java.util.Arrays;

public class _261_Graph_Valid_Tree {
	int[] father;

	public boolean validTree(int n, int[][] edges) {
        father = new int[n];
        for (int i = 0; i < n; i++)
        	father[i] = i;
        for (int[] edge : edges) {
        	int u = edge[0];
        	int v = edge[1];
        	boolean isCycle = union(u, v);
        	System.out.println(Arrays.toString(father));
        	if (isCycle)
        		return false;
        }
        for (int i = 0; i < n; i++) {
        	if (find(father[i]) != find(father[0]))
        		return false;
        }
        return true;
    }
	
	boolean union(int u, int v) {
		int fatherU = find(u);
		int fatherV = find(v);
		if (fatherU == fatherV)
			//IS CYCLE
			return true;
		else {
			father[father[u]] = fatherV;
			return false;
		}
	}
	
	int find(int u) {
		if (father[u] == u)
			return u;
		father[u] = find(father[u]);
		return father[u];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_261_Graph_Valid_Tree t = new _261_Graph_Valid_Tree();
		//int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {4, 2}};
		System.out.println(t.validTree(5, edges));

	}

}
