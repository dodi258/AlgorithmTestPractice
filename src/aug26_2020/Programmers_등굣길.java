/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug26_2020;

/**
 *
 * @author 주세인1
 */

public class Programmers_등굣길 {
    public static void main(String[] args) {
        int m = 4; 
        int n = 3; 
        int[][] puddles = {{2, 2}}; 
        System.out.println(solution(m, n, puddles)); 
    }
    
    public static int solution(int m, int n, int[][] puddles) {
        final int INF = -10; 
        int[][] map = new int[n+1][m+1];
        
        // 물구덩이 표시 
        for(int[] puddle: puddles) {
            map[puddle[1]-1][puddle[0]-1] = INF; 
        }
        
        // 처음 출발점을 1로 만듦. 
        map[n-1][m] = 1; 

        for(int col = m-1; col >= 0; col--) {
            for(int row = n-1; row >= 0; row--) {
                if (map[row][col] != INF)
                    map[row][col] = (map[row][col+1]+ map[row+1][col])% 1000000007; 
                // 물구덩이에 저장된 INF 가 경로의 합에 영향을 미치지 않게 하기 위해 0을 해줌. 
                else map[row][col] = 0; 
            }
        }
        
        return map[0][0]; 
    }
}
