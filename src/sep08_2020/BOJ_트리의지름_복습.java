/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep08_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 
public class BOJ_트리의지름_복습 {
    
    private static boolean[] visited; 
    private static Node maxNode;
    private static int max; 
    private static ArrayList<Node>[] tree;
    
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
        // 임의의 노드에서 가장 긴 노드 
        Node start = findLongestPath(tree[1].get(0), 0); 
        maxNode = null; 
        max = 0; 
        visited = new boolean[N+1];
        // 찾은 가장 긴 노드에서 또 가장 긴 노드 
        findLongestPath(start, 0); 
        System.out.println(max); 
    }
    
    // 현재 노드에서 가장 긴 노드를 찾음. 
    private static Node findLongestPath(Node now, int length){
        
        // 여기에 조건을 붙여서 끝내는 대신 모든 경로가 끝나기를 기다리고, 마지막에 max를 구하는 것임. 
        visited[now.index] = true; 
        for(Node node: tree[now.index]) {
            if(!visited[node.index])
                findLongestPath(node, node.length + length); 
        }
        // 각 path의 length가 구해지면, 
        if (max <length) {
            max = length; 
            maxNode = now; 
        }
        
        return maxNode; 
    }
    
    private static class Node {
        int index; 
        int length; 
        Node(int index, int length) {
            this.index = index; 
            this.length = length; 
        }
    }
}
