/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul13_2020;

/**
 *
 * @author 주세인1
 */
import java.io.*; 
import java.util.*; 


public class BOJ_경로찾기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
//        StringTokenizer st; 
//        int N = Integer.parseInt(in.readLine()); 
//        int[][] map = new int[N][N];
//        int[][] go = new int[N][N];
//        ArrayList<Integer>[] relation = new ArrayList[N]; 
//       
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(in.readLine()); 
//            relation[i] = new ArrayList<Integer>();
//            for(int j = 0; j < N; j++) {
//                int input = Integer.parseInt(st.nextToken()); 
//                if (input == 1) {
//                    relation[i].add(j); 
//                }
//                map[i][j] = input; 
//            }
//        }
//        
//        Queue<Integer> queue; 
//        for(int i = 0; i < N; i++) {
//            queue = new LinkedList<>(); 
//            queue.add(i); 
//            
//            while(! queue.isEmpty()) {
//                int node = queue.poll(); 
//                for(int j = 0; j < relation[node].size(); j++) {
//                    int nn = relation[node].get(j); 
//                    if (go[i][nn] == 1) continue;
//                    go[i][nn] = 1; 
//                    if (nn == i) continue; 
//                    queue.offer(nn); 
//                    
//                }
//            }
//        }
//        
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                out.append(String.valueOf(go[i][j])).append(' '); 
//            }
//            out.append("\n"); 
//        }
//        
//        out.flush();
//        out.close(); 
//        
//    }
    
    
}
