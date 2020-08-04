/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june26_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class Programmers_N개의최소공배수 {
//    public static void main(String[] args) {
//        int[] arr1 = {2, 6, 8, 14};
//        int[] arr2 = {1, 2, 3}; 
//        
//        System.out.println(solution(arr1)); 
//         System.out.println(solution(arr2)); 
//    }
    // 최소공배수 
    public static int getGCD(int a, int b) {
        int tmp; 
        while( b != 0) {
            tmp = b; 
            b = a % b; 
            a = tmp; 
        }
        
        return a; 
    }
    
    public static int getLCM(int a, int b) {
        if (a <= 0 || b <= 0) return 0; 
        return a * b / getGCD(a, b); 
    }
    
    
    public static int solution(int[] arr) {
        int lcm = arr[0]; 
        for(int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]); 
        }
        
        return lcm; 
    }
}
