package google;



/*
给了两个recipe R1 和 R2，每个recipe有特定的几个步骤，每个步骤是一个tuple，包含步骤名称、用时间、active/passive
对于passive的步骤，可以在做的时候同时去完成另一个recipe上面的任务。求完成两个recipe的最短时间
eg. R1 = [(A, 2, 'ACTIVE'), (B, 3, 'PASSIVE')], R2 = [(C, 2, 'ACTIVE')]
output是5，先做A，然后同时BC。
*/
public class Receipt {
	
	public static void recipe() {
		String[][] r1 = {{"3", "ACTIVE"}, {"10", "PASSIVE"}};
		String[][] r2 = {{"4", "ACTIVE"}, {"15", "PASSIVE"}};

		int[][] record = new int[2][2];//[[a1, p1], [a2, p2]];
		int s1 = 0, s2 = 0;
		int total = 0;
		while (s1 < r1.length && s2 < r2.length || record[0][0] > 0 || record[1][0] > 0) {
			if (record[0][0] == 0 && record[1][0] == 0) {
				while (s1 < r1.length && "ACTIVE".equals(r1[s1][1])) {
					record[0][0] += Integer.parseInt(r1[s1++][0]);
				}
				while (s1 < r1.length && "PASSIVE".equals(r1[s1][1])) {
					record[0][1] += Integer.parseInt(r1[s1++][0]);
				}
		
				while (s2 < r2.length && "ACTIVE".equals(r2[s2][1])) {
					record[1][0] += Integer.parseInt(r2[s2++][0]);
				}
				while (s2 < r2.length && "PASSIVE".equals(r2[s2][1])) {
					record[1][1] += Integer.parseInt(r2[s2++][0]);
				}
			}

			System.out.println(record[0][0]+","+record[0][1]);
			System.out.println(record[1][0]+","+record[1][1]);
	
			boolean switched = false;
			if (record[0][1] > record[1][1]) {
				int[] temp = record[0];
				record[0] = record[1];
				record[1] = temp;
				switched = true;
			}

			//passive2 >= passive1
			total += record[1][0] + record[1][1];
			record[1][0] = 0; //clean active2
			int diff = record[0][0] - record[1][1];
			record[0][0] = Math.max(0, diff);//clean active1
			record[1][1] = Math.max(0, -diff);//clean passive2 with active1
			diff = record[0][1] - record[1][1];
			record[0][1] = Math.max(0, diff);//clean passive1
			record[1][1] = Math.max(0, -diff);//clean passive2 with passive1
			total -= record[1][1];//reduce rest of passive2 which will roll into next round
	
			if (switched) {
				int[] temp = record[0];
				record[0] = record[1];
				record[1] = temp;
			}
			System.out.println("--"+total);
		}
		total += record[0][1] + record[1][1];
		System.out.println("--"+total);
	}
	public static void main(String[] args) {
		Receipt.recipe();

	}

}
