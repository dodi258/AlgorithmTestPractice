/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep25_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_보행자천국 {
    public static void main(String[] args) {
        int m = 3;  // 세로 
        int n = 6;  // 가로
        
        int[][] city_map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}; 
        
        
    }
    
    static int MOD = 20170805;
    
    public static int solution(int m, int n, int[][] city_map) {
        int[][] vertical = new int[m+1][n+1]; 
        int[][] horizontal = new int[m+1][n+1];

        vertical[1][1] = horizontal[1][1] = 1; 
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int dir = city_map[i-1][j-1]; 
                if (dir == 1) continue; 
                
                else if (dir == 0) {
                    vertical[i][j] += (vertical[i-1][j] + horizontal[i][j-1]) % MOD; 
                    horizontal[i][j] += (vertical[i-1][j] + horizontal[i][j-1]) % MOD; 
                }
                else {
                    vertical[i][j] = vertical[i-1][j]; 
                    horizontal[i][j] = horizontal[i][j-1]; 
                 }
                
            }
        }
        return vertical[m][n]; 
    }
    
}
