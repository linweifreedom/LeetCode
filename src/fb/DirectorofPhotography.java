package fb;

import java.util.ArrayList;
import java.util.List;

/*A photography set consists of NN cells in a row, numbered from 11 to NN in order, and can be represented by a string CC of length NN. Each cell ii is one of the following types (indicated by C_iC 
i, the iith character of CC):
If C = ¡°P¡±, it is allowed to contain a photographer
If C = ¡°A¡±, it is allowed to contain an actor
If C= ¡°B¡±, it is allowed to contain a backdrop
If C= ¡°.¡±, it must be left empty
A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between XX and YY cells (inclusive), and the distance between the actor and the backdrop is also between XX and YY cells (inclusive). The distance between cells ii and jj is |i - j|¨Oi-j¨O (the absolute value of the difference between their indices).
Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.
Constraints
1 <= N <=200
1 \<= X <= Y <= N
Sample Test Case #1
N = 5
C = APABA
X = 1
Y = 2
Expected Return Value = 1
Sample Test Case #2
N = 5
C = APABA
X = 2
Y = 3
Expected Return Value = 0
Sample Test Case #3
N = 8
C = .PBAAP.B
X = 1
Y = 3
Expected Return Value = 3
Sample Explanation
In the first case, the absolute distances between photographer/actor and actor/backdrop must be between 11 and 22. The only possible photograph that can be taken is with the 33 middle cells, and it happens to be artistic.
In the second case, the only possible photograph is again taken with the 33 middle cells. However, as the distance requirement is between 22 and 33, it is not possible to take an artistic photograph.
In the third case, there are 44 possible photographs, illustrated as follows:
.P.A...B
.P..A..B
..BA.P..
..B.AP..
All are artistic except the first, where the artist and backdrop exceed the maximum distance of 33.*/
public class DirectorofPhotography {
	public int getArtisticPhotographCount(int N, String C, int X, int Y) {
		// Write your code here
		List<Integer> pList = new ArrayList<>();
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			switch (C.charAt(i)) {
			case 'P':
				pList.add(i);
				break;
			case 'A':
				aList.add(i);
				break;
			case 'B':
				bList.add(i);
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < pList.size(); i++) {
			for (int j = 0; j < aList.size(); j++) {
				int diffPA = pList.get(i) - aList.get(j);
				if (Math.abs(diffPA) <= Y && Math.abs(diffPA) >= X) {
					for (int k = 0; k < bList.size(); k++) {
						int diffAB = aList.get(j) - bList.get(k);
						if ((diffPA < 0 && diffAB > 0) || (diffPA > 0 && diffAB < 0))
							continue;
						else if (Math.abs(diffAB) >= X && Math.abs(diffAB) <= Y)
							count++;
					}
				}

			}
		}

		return count;
	}
}
