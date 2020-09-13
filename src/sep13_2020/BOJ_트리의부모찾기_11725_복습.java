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
public class BOJ_트리의부모찾기_11725_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st; 
        
        int N = Integer.parseInt(in.readLine()); 
        int[] parents = new int[N+1];
        
        ArrayList<Integer>[] connections = new ArrayList[N+1]; 
        for(int i = 0; i <= N; i++) {
            connections[i] = new ArrayList<Integer>(); 
        }
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            connections[node1].add(node2); 
            connections[node2].add(node1); 
        }
        
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(1); 
        
        while(! queue.isEmpty()) {
            int now = queue.poll(); 
            
            for(int node: connections[now]) {
                if (parents[node] != 0) continue; 
                parents[node] = now;
                queue.add(node); 
            }
        }
        
        for(int parent: Arrays.copyOfRange(parents, 2, N+1)) {
            out.write(parent + "\n"); 
        }
//        for(int i = 2; i <= N; i++) {
//            out.write(parents[i] + "\n");
//        }
        
        out.flush(); 
        out.close(); 
    }
}
