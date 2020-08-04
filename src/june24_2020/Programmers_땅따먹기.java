/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june24_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 

public class Programmers_땅따먹기 {
    
//    public static void main(String[] args) {
//        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}; 
//        solution(land);
//    }
    
    static int solution(int[][] land) {
        int answer = 0;
        int H = land.length; 
        int W = land[0].length; 

        for(int i = 1; i < H; i++) {
            for(int j = 0; j < W; j++) {
                int max = 0; 
                for(int k = 0; k < W; k++) {
                    if (j == k) continue; 
                    if (max < land[i-1][k])
                        max = land[i-1][k]; 
                }
                land[i][j] += max; 
            }
            
        }
        
        for(int j = 0; j < W; j++) {
            if (answer < land[H-1][j])
                answer = land[H-1][j]; 
        }
        return answer; 
    }
    
    
}
