package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *  One news , only A knows. A passes news to other person . input  (PersonA, PersonB, time)
 *  
 *  follow up : every time personA has P rate to pass news to PersonB
 * 
 *
 */
public class PassNews {
  public Set<String> passNews(Node[] nodes, int time ) {
    Set<String> set = new HashSet<>();
    set.add("A");
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
    for (Node node : nodes)
      pq.offer(node);
    while (!pq.isEmpty()) {
      if (pq.peek().time <= time) {
        Node top = pq.poll();
        if (set.contains(top.personA) || set.contains(top.personB)) {
          set.add(top.personA);
          set.add(top.personB);
        }
      } else {
        break;
      }
    }
    return set;
  }
  
  public double rateForTargetPerson(Node[] nodes, int time, double P, String targetPerson) {
    Map<String , Double> map = new HashMap<>();
    map.put("A", 1.0);
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
    for (Node node : nodes)
      pq.offer(node);
    while (!pq.isEmpty()) {
      if (pq.peek().time <= time) {
        Node top = pq.poll();
        if (map.containsKey(top.personA) || map.containsKey(top.personB)) {
          if (map.containsKey(top.personA) && map.containsKey(top.personB)) {
            double newARate = map.get(top.personA) + (1 - map.get(top.personA)) * map.get(top.personB) * P;
            double newBRate = map.get(top.personB) + (1 - map.get(top.personB)) * map.get(top.personA) * P;
            map.put(top.personA, newARate);
            map.put(top.personB, newBRate);
          } else if (map.containsKey(top.personA)) {
            double newBRate = map.get(top.personA) * P;
            map.put(top.personB, newBRate);
          } else if (map.containsKey(top.personB)) {
            double newARate = map.get(top.personB) * P;
            map.put(top.personA, newARate);
          }
        }
      } else
        break;
    }
    return map.get(targetPerson) == null ? 0.0 : map.get(targetPerson);
    
  }
  
  public static void main(String[] args) {
    Node[] nodes = new Node[4];
    PassNews passNews = new PassNews();
    nodes[0] = new Node("A", "B", 100);
    nodes[1] = new Node("A", "C", 200);
    nodes[2] = new Node("B", "C", 300);
    nodes[3] = new Node("B", "E", 500);
    System.out.println(String.valueOf(passNews.passNews(nodes, 200)));
    System.out.println(String.valueOf(passNews.rateForTargetPerson(nodes, 300, 0.5, "C")));
  }
}

class Node {
  String personA;
  String personB;
  int time;
  public Node(String pa, String pb, int t) {
    personA = pa;
    personB = pb;
    time = t;
  }
}
