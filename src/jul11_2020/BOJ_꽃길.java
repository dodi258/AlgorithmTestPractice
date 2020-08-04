/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul11_2020;

/**
 *
 * @author 주세인1
 */

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
public class BOJ_꽃길 {
    static int N; 
    static int[][] map;
    static boolean[][] selected; 
    static int[][] blocks; 
    static int answer = Integer.MAX_VALUE; 

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
//        StringTokenizer st;
//        N = Integer.parseInt(reader.readLine());
//        map = new int[N][N];
//        selected = new boolean[N][N];
//        blocks = new int[3][2];
//        
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(reader.readLine()); 
//            for(int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken()); 
//            }
//        }
//        
//        selectBlocks(0, 0); 
//        System.out.println(answer); 
//        
//    }
    
    
    public static void selectBlocks(int level, int start) {
        if (level == 3) {
            answer =  Math.min(answer, getCost(blocks)); 
            return ; 
        }
        
        // 조합으로 (행, 열) 구하기
        // start부터 시작하는것은 오름차순으로 고르기 때문이다.(똑같은 것을 고르게 하지 않기위함) 
        for(int i = start; i < (N-2)*(N-2); i++) {
            int r  = i / (N-2) + 1; 
            int c = i % (N-2) + 1; 

            if(selected[r][c] || selected[r-1][c] || selected[r][c+1] || selected[r+1][c] || selected[r][c-1]) continue; 
            // 동서남북으로 방문했다는 표시를 해준다. 
            selected[r][c] = true; 
            selected[r-1][c] = true; 
            selected[r][c+1] = true; 
            selected[r+1][c] = true; 
            selected[r][c-1] = true; 
            blocks[level][0] = r; 
            blocks[level][1] = c; 
            selectBlocks(level + 1, i + 1); 
            // backtracking: 동서남북으로 방문을 다시 안하게 하여, 나중에도 다시 검사할 수 있도록 한다. 
            selected[r][c] = false; 
            selected[r-1][c] = false; 
            selected[r][c+1] = false; 
            selected[r+1][c] = false; 
            selected[r][c-1] = false; 
        }
        
        
    }
    public static int getCost(int[][] blocks) {
            int sum = 0; 
            for(int i = 0; i < 3; i++) {
                int r = blocks[i][0]; 
                int c = blocks[i][1]; 
                
                // 북 동 남 서 
                sum += map[r][c] + map[r-1][c] + map[r][c+1] + map[r+1][c] + map[r][c-1]; 
            }
            
            return sum; 
        }
}
