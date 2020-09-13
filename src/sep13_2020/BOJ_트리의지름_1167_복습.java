/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep13_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 
public class BOJ_트리의지름_1167_복습 {
    static boolean[] visited; 
    static int max; 
    static Node maxNode; 
    static ArrayList<Node>[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(in.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1]; 
        for(int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<>(); 
        }
        for(int i = 1; i < N+1; i++) {
            String[] input = in.readLine().split(" "); 
            int index = Integer.parseInt(input[0]); 
            for(int j = 1; j < input.length-1; j+=2) {
                tree[index].add(new Node(Integer.parseInt(input[j]), Integer.parseInt(input[j+1]))); 
            }
        }
        
        // 아무 노드A에서 출발하여 가장 먼 곳에 있는 노드B를 찾음. 
        Node start = findLongestPath(tree[1].get(0), 0); 
        max = 0; 
        maxNode = null; 
        visited = new boolean[N+1];
        
        // 노드B에서 가장 먼 곳에 있는 노드C를 구함. 
        findLongestPath(start, 0); 
        System.out.println(max); 
    }
    
    static Node findLongestPath(Node now, int length){
        
        // 모든 path를 방문하면서 length를 더해준다. 
        visited[now.index] = true; 
        for(Node node: tree[now.index]) {
            if(!visited[node.index])
                findLongestPath(node, node.length + length); 
        }
        // 각 path의 length가 구해지면, 
        // 가장 길이가 긴 노드를 return 함 !
        if (max <length) {
            max = length; 
            maxNode = now; 
        }
        
        return maxNode; 
    }
    
    static class Node {
        int index; 
        int length; 
        Node(int index, int length) {
            this.index = index; 
            this.length = length; 
        }
    }
}
    

