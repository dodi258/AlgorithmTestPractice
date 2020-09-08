/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep07_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

/*
메모리 초과 코드.. 
*/
public class BOJ_Tree_트리의지름_1167번 {
    public static boolean[] visited; 
    public static int[][] lengths; 
    public static ArrayList<Integer>[] connections; 
    public static int tempMax; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(in.readLine()); 
        lengths = new int[N+1][N+1]; 
        connections = new ArrayList[N+1]; 
        
        for(int i = 0; i < N; i++) {
            connections[i + 1]  = new ArrayList<>(); 
            String[] nodes = in.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]); 
            for(int j = 1; j < nodes.length -1; j+=2) {
                int node2 = Integer.parseInt(nodes[j]);
                lengths[node1][node2] = Integer.parseInt(nodes[j+1]); 
                connections[node1].add(node2); 
            }
        }
        
        int max = 0; 
        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                Arrays.fill(visited, false); 
                tempMax = 0; 
                findLength(i, j, 0); 
                max = Math.max(tempMax, max); 
            }
        }

        System.out.println(max); 
    }
    
    public static void findLength(int start, int target, int sum) {
        if (target == start) {
            tempMax = Math.max(sum, tempMax); 
        } 

        visited[start] = true; 
        for(int node: connections[start]) {
            if (visited[node]) continue; 
            findLength(node, target, sum + lengths[start][node]); 
        }
    }
    
    public static class Node {
        int index; 
        int dist; 
        Node(int index, int dist) {
            this.index = index; 
            this.dist = dist; 
        }
    }
    
}
