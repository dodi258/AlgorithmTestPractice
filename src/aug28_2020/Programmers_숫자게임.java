/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug28_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 

public class Programmers_숫자게임 {
//    public static void main(String[] args) {
//        int[] A1 = {5, 1, 3, 7}; 
//        int[] B1 = {2, 2, 6, 8}; 
//        int[] A2 = {2, 2, 2, 2}; 
//        int[] B2 = {1, 1,  1, 1};
//        System.out.println(solution(A1, B1)); 
//        System.out.println(solution(A2, B2)); 
//    }
    
    public static int solution(int[] A, int[] B) {
        // idea : 정렬을 한 후에, 이기는 것 중, 가장 작은 수를 차례대로 배정한다. 
        int answer = 0; 
        int N = A.length; 
        Arrays.sort(A); 
        Arrays.sort(B); 
        
        
        int j = 0; 
        for(int i = 0; i < N; i++) {
            for(j += 1; j < N; j++) {
                if (A[i] < B[j]) {
                    answer ++; 
                    break; 
                } 
            }
        }

        return answer; 
    }
}
