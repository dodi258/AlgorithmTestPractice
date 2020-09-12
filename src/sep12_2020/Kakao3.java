/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep12_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 

public class Kakao3 {
//    public static void main(String[] args) {
////        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}; 
////        int n = 7; 
////        int s = 3; 
////        int a = 4; 
////        int b = 1; 
//        
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}; 
//        int n = 6; 
//        int s = 4; 
//        int a = 6; 
//        int b = 2; 
//        System.out.println(solution(n, s, a, b, fares)); 
//    }
    static long[][] distanceTo; 

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> list = new ArrayList<>(); 
        distanceTo = new long[3][n+1]; 
        Arrays.fill(distanceTo[0], Integer.MAX_VALUE); 
        Arrays.fill(distanceTo[1], Integer.MAX_VALUE); 
        Arrays.fill(distanceTo[2], Integer.MAX_VALUE); 
        
        for(int i = 0; i < n+1; i++) {
            list.add(new ArrayList<Node>()); 
        }
        
        for(int i = 0; i < fares.length; i++) {
            int[] fare = fares[i]; 
            list.get(fare[0]).add(new Node(fare[1], fare[2])); 
            list.get(fare[1]).add(new Node(fare[0], fare[2])); 
        }
        
        dijkstra(list, n, a, s, s, 0); 
        dijkstra(list, n, b, s, s, 1);
        dijkstra(list, n, s, a, b, 2); 
        long answer = Long.MAX_VALUE; 
        for(int i = 1; i <= n; i++) {
            long curr_fare = distanceTo[0][i] + distanceTo[1][i] + distanceTo[2][i]; 
            if (answer > curr_fare)
                answer = curr_fare; 
        }

        
        return (int)answer; 
    }
    
    static void dijkstra(List<List<Node>> nodes, int n, int start, int exception1 ,int exception2, int type) {
        boolean[] visited = new boolean[n+1]; 
        visited[exception1] = true; 
        visited[exception2] = true; 
        PriorityQueue<Node> queue = new PriorityQueue<>(); 
        distanceTo[type][start] = 0; 
        queue.add(new Node(start, 0)); 
        
        while(!queue.isEmpty()) {
            int now = queue.poll().index; 
            
            if (visited[now]) continue; 
            visited[now] = true; 
            
            for(Node node: nodes.get(now)) {
                if (distanceTo[type][node.index] > distanceTo[type][now] + node.distance) {
                    distanceTo[type][node.index] = distanceTo[type][now] + node.distance; 
                    queue.add(new Node(node.index, distanceTo[type][node.index])); 
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int index; 
        long distance; 

        Node(int index, long distance) {
            this.index = index; 
            this.distance = distance; 
        }
        
        @Override
        public int compareTo(Node n) {
            if (this.distance < n.distance)
                return -1; 
            return 1; 

        }
    }
    
}
