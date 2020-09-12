/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep10_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class 월간코드챌린지시즌1_2 {
//    public static void main(String[] args) {
//        int n = 4; 
//        int n2 = 5; 
//        int n3 = 6; 
//        solution(n); 
//        solution(n2); 
//        solution(n3); 
//    }
    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int count = n; 
        int num = 1; 
        int[][] arr = new int[n][n];
        int r = 0; 
        int c = 0; 
        int dir = 1; 
        while(count > 0) {
            dir %= 3; 
            if (dir == 1) {
                for(int i = 1; i <= count; i++) {
                    arr[r++][c] = num++; 
                }
                r--;
                c++; 
            }
            else if (dir == 2) {
                for(int i = 1; i <= count; i++) {
                    arr[r][c++] = num++; 
                }
                c-=2;
                r--;
            }
            else {
                for(int i = 1; i <= count; i++) {
                    arr[r--][c--] = num++; 
                }
                r += 2; 
                c ++; 
            }
            dir ++; 
            count --; 
        } 
        int index = 0; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j<= i; j++) {
                answer[index++] = arr[i][j]; 
            }
            
        }
//        
//        System.out.println(Arrays.toString(answer)); 
        return answer;
    }
    
}
