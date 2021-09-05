package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Turnstile {
  public int[] turnstile(int[] time, int[] direction) {
    Queue<Integer> enterQ = new LinkedList<>();
    Queue<Integer> exitQ = new LinkedList<>();
    for (int i = 0; i < direction.length; i++) {
      if (direction[i] == 0) {
        exitQ.offer(i);
      } else
        enterQ.offer(i);
    }
    int[] output = new int[direction.length];
    int lastTime = -2;
    Queue<Integer> lastQ = exitQ;
    while (!enterQ.isEmpty() && !exitQ.isEmpty()) {
      int enterIndex = enterQ.peek(), exitIndex = exitQ.peek();
      int enterTime = time[enterIndex], exitTime = time[exitIndex];
      int currentTime = lastTime + 1;
      Queue<Integer> currentQ;
      if (currentTime < enterTime && currentTime < exitTime) {
        // The turnstile was not used in previous second
        currentQ = (exitTime <= currentTime) ? exitQ : enterQ;
        int currentIndex = currentQ.poll();
        output[currentIndex] = time[currentIndex];
        lastTime = time[currentIndex];
        lastQ = currentQ;
      } else {
        // turnstile was used last second
        if (currentTime >= enterTime && currentTime >= exitTime) {
          currentQ = lastQ;
        } else {
          currentQ = currentTime >= enterTime ? enterQ : exitQ;
        }
        int currentIndex = currentQ.poll();
        output[currentIndex] = currentTime;
        lastTime = currentTime;
        lastQ = currentQ;
      }
    }
    Queue<Integer> pendingQ = enterQ.isEmpty() ? exitQ : enterQ;
    while (!pendingQ.isEmpty()) {
      int currentTime = lastTime + 1;
      int currentIndex = pendingQ.poll();
      if (currentTime < time[currentIndex]) {
        currentTime = time[currentIndex];
      }
      output[currentIndex] = currentTime;
      lastTime = currentTime;
    }
    return output;
  }

  public static void test(int[] time, int[] direction, int[] expected) {
    Turnstile instance = new Turnstile();
    int[] result = instance.turnstile(time, direction);
    System.out.println("ACTUAL: " + Arrays.toString(result));
    System.out.println("EXPECTED: " + Arrays.toString(expected));
  }

  public static void main(String[] args) {
    System.out.println("Turnstile");
    test(new int[] {0, 0, 1, 5}, new int[] {0, 1, 1, 0}, new int[] {2, 0, 1, 5});
    test(new int[] {0, 0, 5, 5}, new int[] {0, 1, 1, 0}, new int[] {1, 0, 5, 6});
    test(new int[] {0, 0, 1, 1}, new int[] {0, 1, 1, 0}, new int[] {2, 0, 1, 3});
    test(new int[] {0, 0, 0, 0}, new int[] {0, 1, 1, 0}, new int[] {2, 0, 1, 3});
    test(new int[] {0, 0, 0, 0}, new int[] {0, 0, 0, 0}, new int[] {0, 1, 2, 3});
    test(new int[] {0, 0, 1, 3, 10}, new int[] {0, 1, 1, 1, 0}, new int[] {2, 0, 1, 3, 10});
    test(new int[] {0, 1, 1, 3, 3}, new int[] {0, 1, 0, 0, 1}, new int[] {0, 2, 1, 4, 3});
  }
}
