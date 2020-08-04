/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june25_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class Programmers_행렬의곱셈 {
//    public static void main(String[] args) {
//        int[][] arr1 = {{1, 4},{3, 2},{4, 1}}; 
//        int[][] arr2 = {{3, 3},{3, 3}};
//        
//        System.out.println(Arrays.toString(solution(arr1, arr2))); 
//    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                for(int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]; 
                }
            }
        }
        
        for(int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i])); 
        }
        return answer; 
    }
}
