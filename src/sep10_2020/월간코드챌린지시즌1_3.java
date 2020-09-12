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
import java.util.*; 
import java.io.*; 
public class 월간코드챌린지시즌1_3 {
//    public static void main(String[] args) {
//        int[] a1 = {-16,27,65,-2,58,-92,-71,-68,-61,-33}; 
//        int[] a2 = {9,-1,-5};
////        System.out.println(solution(a1)); 
//        System.out.println(solution(a2)); 
//    }
    public static int solution(int[] a) {
        int answer = 0; 
        int N = a.length; 
        int[] arr1 = new int[N]; 
        int[] arr2 = new int[N]; 
        arr1[0] = a[0];
        arr2[N-1] = a[N-1]; 
        
        for(int i = 1; i < N; i++) {
            arr1[i] = Math.min(arr1[i-1], a[i]); 
        }
        
        for(int i = N-2; i >= 0; i--) {
            arr2[i] = Math.min(arr2[i+1], a[i]); 
        }
        
        for(int i = 0; i < N; i++) {
            if (arr1[i] == a[i] || arr2[i] == a[i])
                answer += 1; 
        }
        
        return answer; 
    }
}
