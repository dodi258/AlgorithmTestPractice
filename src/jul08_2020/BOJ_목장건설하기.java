/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul08_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException; 

/**
 *
 * @author 주세인1
 */
public class BOJ_목장건설하기 {
    
    
//    public static void main(String[] args) throws IOException {
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
//
//        // M: 행, N: 열
//        int M = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//        int[][] map = new int[M+1][N+1];
//        int[][] dp = new int[1002][1002];
//        for (int i = 1; i <= M; i++) {
//            st = new StringTokenizer(in.readLine());
//            for (int j = 1; j <= N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int answer = 0; 
//        for(int i = 1; i <= M; i++) {
//            for(int j = 1; j <= N; j++) { 
//
//                if (map[i][j] == 0) {
//                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) +1; 
//                    answer = Math.max(map[i][j], answer); 
//                }
//            }
//        }
//        
//        
//        System.out.println(answer); 
//    }
}
