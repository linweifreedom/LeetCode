package google;

import java.util.LinkedList;
import java.util.Queue;


/*Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):
When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.
*/
public class _818_RaceCar {
	public int racecar(int target) {
        Queue<Node> q  = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.pos + top.speed == target) return top.step + 1;
            q.offer(new Node(top.pos + top.speed, top.speed * 2, top.step + 1));
            if (top.speed > 0 && top.pos + top.speed > target) {
                q.offer(new Node(top.pos, -1, top.step + 1));
            }
            if (top.speed < 0 && top.pos + top.speed < target) {
                q.offer(new Node(top.pos, 1, top.step + 1));
            }
        }
        return 0;
    }
	
	class Node {
	    int pos;
	    int speed;
	    int step;
	    public Node(int pos, int speed, int step)  {
	        this.pos = pos;
	        this.speed = speed;
	        this.step = step;
	    }
	}

}



