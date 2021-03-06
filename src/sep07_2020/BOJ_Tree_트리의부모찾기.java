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

public class BOJ_Tree_트리의부모찾기 {
    static int[] parents; 
    static ArrayList<Integer>[] connections; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(in.readLine());
        parents = new int[N+1]; 
        connections = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            connections[i] = new ArrayList<Integer>(); 
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(in.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            
            connections[n1].add(n2); 
            connections[n2].add(n1); 
        }
        findParent(1);
        for(int parent: Arrays.copyOfRange(parents, 2, N+1)) {
            out.write(parent + "\n"); 
        }
        out.flush(); 
        out.close(); 
    }
    
    public static void findParent(int now) {
        
        for(int child: connections[now]) {
            if (parents[child] == 0) {
                parents[child] = now; 
                findParent(child); 
            }
        }
    }
}
