/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep02_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_보행자천국 {
// 동적 계획법

    public static int MOD = 20170805;
    public static void main(String[] args) {
        int m = 3;
        int n = 6;

        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        solution(m, n, cityMap);
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int[][] result = new int[m][n];
        int[][] paddedCityMap = new int[m+1][n+1]; 
        for(int i = 0; i < m; i++) {
            paddedCityMap[i+1][0] = 1;  
            for(int j = 0; j < n; j++) {
                paddedCityMap[i+1][j+1] = cityMap[i][j]; 
            }
        }
        Arrays.fill(paddedCityMap[0], 1);
        result[0][0] = 1; 
        
        int dr[] = {-1, 0};
        int dc[] = {0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (paddedCityMap[i+1][j+1] != 1) {
                    for (int k = 0; k < 2; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        while (paddedCityMap[nr+1][nc+1] == 2) {
                                nr = nr + dr[k];
                                nc = nc + dc[k];
                            }
                        //맨 왼쪽, 맨 오른쪽, 맨 위, 아래에서 2인 것을 제외 하기 위함. 
                        if (nr >= 0 && nc >= 0)
                            result[i][j] = (result[i][j] + result[nr][nc]) % MOD;
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
