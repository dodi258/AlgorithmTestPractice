/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug01_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_섬연결하기 {
//    public static void main(String[] args) {
//        int n = 4; 
//        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}; 
//        solution(n, costs); 
//    }
    static int[] parent; 
    public static int solution(int n, int[][] costs) {
        int answer = 0; 
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < costs.length; i++) {
            System.out.println(Arrays.toString(costs[i])); 
        }

        parent = new int[n]; 
        for(int i = 0; i < n; i++) {
            parent[i] = i; 
        }
        for(int i = 0; i < costs.length; i++) {
            int[] info = costs[i]; 
            int start = findParent(info[0]); 
            int end = findParent(info[1]); 
            int cost = info[2]; 
            
            if (start != end) {
                answer += cost; 
                parent[end] = start; 
            }
        }
        
        return answer; 
    }
    
    public static int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        else return parent[node] = findParent(parent[node]); 
    }
}
