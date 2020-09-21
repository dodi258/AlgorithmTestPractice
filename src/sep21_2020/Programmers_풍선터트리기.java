/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep21_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_풍선터트리기 {
//    public static void main(String[] args) {
//        int[] a1 = {9, -1, -5}; 
//        int[] a2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
//        solution(a1); 
//        solution(a2); 
//    }
    public static int solution(int[] a) {
        int answer = 0; 
        
        int[] a_left_min = new int[a.length]; 
        int[] a_right_min = new int[a.length]; 
        
        int n = a.length; 
        
        a_left_min[0] = a[0]; 
        a_right_min[n-1] = a[n-1]; 
        
        n -= 1; 
        while(n --> 0) {
            a_left_min[a.length - 1 - n] = Math.min(a[a.length - 1 - n], a_left_min[a.length -1 - n - 1]); 
            a_right_min[n] = Math.min(a[n], a_right_min[n+1]); 
        }
        
        for(int i = 0; i < a.length; i++) {
            if ((a[i] == a_left_min[i]) || (a[i] == a_right_min[i]))
                answer ++; 
        }
        System.out.println(answer); 
        return answer; 
    }
}
