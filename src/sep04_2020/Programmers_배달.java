/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep04_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_배달 {

    public static void main(String[] args) {
        int N1 = 5;
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K1 = 3;

        int N2 = 6;
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K2 = 4;

        System.out.println(solution(N1, road1, K1));
        System.out.println(solution(N2, road2, K2));

    }

    public static int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] nodes = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int first = r[0];
            int second = r[1];
            int dist = r[2];

            nodes[first].add(new Node(second, dist));
            nodes[second].add(new Node(first, dist));
        }

        return dijkstra(nodes, K);
    }

    static int dijkstra(ArrayList<Node>[] nodes, int K) {
        int answer = 0;
        boolean[] visited = new boolean[nodes.length];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.dist > K) break;
            if (visited[now.index]) continue;
       
            visited[now.index] = true;
            answer++;
            
            for (Node next : nodes[now.index]) {
                queue.add(new Node(next.index, next.dist + now.dist));
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node> {

        int index;
        int dist;

        Node(int index, int dist) {

            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }
}
