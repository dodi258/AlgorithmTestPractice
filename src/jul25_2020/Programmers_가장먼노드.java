/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul25_2020;

/**
 *
 * @author 주세인1
 */
import java.util.PriorityQueue; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Arrays; 
public class Programmers_가장먼노드 {
//    public static void main(String[] args) {;
//        int n = 6; 
//        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}; 
//        
//        System.out.println(solution(6, vertex)); 
//    }
    public static class Node implements Comparable<Node> {
        int index, distance; 
        public Node(int index, int distance) {
            this.index = index; 
            this.distance = distance; 
        }
        
        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance; 
        }
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0; 
        int[] distance = new int[n+1]; 
        Arrays.fill(distance, Integer.MAX_VALUE); 
        List<List<Node>> list = new ArrayList<>(); 
        list.add(new ArrayList<Node>()); 
        
        for(int i = 1; i <= n; i++) {
            list.add(new ArrayList<Node>()); 
        }
        
        for(int i = 0; i < edge.length; i++) {
            int[] e = edge[i]; 
            list.get(e[0]).add(new Node(e[1], 1)); 
            list.get(e[1]).add(new Node(e[0], 1)); 
        }
       
        dijkstra(list, n, distance, 1); 
        distance[0] = 0; 
        System.out.println(Arrays.toString(distance)); 
        Arrays.sort(distance); 
        int max = distance[n]; 
        for(int i = n; i >= 1; i--) {
            if(max == distance[i]) answer++; 
            else break; 
        }
        return answer; 
    }
    
    public static void dijkstra(List<List<Node>> nodes, int n, int[] distance, int start) {
        boolean[] visited = new boolean[n+1]; 
        PriorityQueue<Node> queue = new PriorityQueue<>(); 
        
        distance[start] = 0; 
        queue.add(new Node(start, 0)); 
        
        while(!queue.isEmpty()) {
            int now = queue.poll().index; 
            
            if (visited[now]) continue; 
            visited[now] = true; 
            
            for(Node node: nodes.get(now)) {
                if (distance[node.index] > distance[now] + node.distance) {
                    distance[node.index] = distance[now] + node.distance; 
                    queue.add(new Node(node.index, distance[node.index])); 
                }
            }
        }
    }
}
