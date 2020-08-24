/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug24_2020;

import java.util.*; 
public class Programmers_최고의집합 {
    public static void main(String[] args) {
        int n1 = 2; 
        int s1 = 9; 
        
        int n2 = 2; 
        int s2 = 1; 
        
        int n3 = 2; 
        int s3 = 8; 
        
        System.out.println(Arrays.toString(solution(n1, s1)));
        System.out.println(Arrays.toString(solution(n2, s2)));
        System.out.println(Arrays.toString(solution(n3, s3)));
    }
    
    public static int[] solution(int n, int s) {
        
        // 경우 1. n > s  : -1
        if (n > s) return new int[]{-1}; 
        // 경우 2. n == s : 1
        else if(n == s) return new int[]{1}; 
        // 경우 3. n < s: 
        int[] answer = new int[n];
        int quotient = s/n; 
        // 3-1. s % n != 0
        if(s % n != 0) {
            for(int i = 0; i < s % n; i++) {
                answer[n-i-1] = 1; 
            }
        }
        // 3-2. s % n == 0
        for(int i = 0; i < n; i++) {
            answer[i] += quotient; 
        }

        return answer; 
    }
}
