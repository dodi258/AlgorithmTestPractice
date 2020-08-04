/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul23_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class Programmers_정수삼각형 {
//    public static void main(String[] args) {
//        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        System.out.println(solution(triangle)); 
//        for(int i = 0; i < triangle.length; i++) {
//            System.out.println(Arrays.toString(triangle[i])); 
//        }
//    }
    
    public static int solution(int[][] triangle) {
        int answer = 0; 
        int n = triangle.length; 
        
        for(int i = n-2; i >= 0; i--) {
            n--; 
            for(int j = 0; j < n; j++) {
               triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); 
               System.out.println(triangle[i][j]); 
            }
        }
        
        
        return triangle[0][0];
    }
}
