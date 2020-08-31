/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug29_2020;

/**
 *
 * @author 주세인1
 */
public class 대각선_연습 {
    public static void main(String[] args) {
        int dim = 4; 
        int[][] array = {{1, 3, 6, 10}, {2, 5, 9, 13}, {4, 8, 12, 15}, {7, 11, 14, 16}}; 
        int[][] array1 = {{16, 15, 13, 10}, {14, 12, 9, 6}, {11, 8, 5, 3}, {7, 4, 2, 1}};
        
        for(int k = 0; k < dim * 2; k++) {
            for(int j = 0; j <= k; j++) {
                int i = k - j; 
                if (i < dim && j < dim) {
                    System.out.print(array[i][j]+ " ");
                }
            }
            System.out.println(); 
        }
        
        int time = 1; 
        for(int k = dim * 2 -3 ; k >= 1; k--) {
            System.out.println(time); 
            for(int j = 0; j <= k; j++) {
                int i = k - j; 
                if (i < dim && j < dim) {
                    System.out.print(array1[i][j]+ " ");
                }
            }
            System.out.println(); 
            time ++; 
        }
        
    }
}
