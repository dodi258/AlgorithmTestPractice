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
import java.util.*; 

public class Programmers_최솟값만들기 {
//    public static void main(String[] args) {
//        
//    }
    
    public int solution(int []A, int []B) {
        int answer = 0;
        int len = A.length; 
        Arrays.sort(A);
        Arrays.sort(B); 
        
        for(int i = 0; i < len; i++) {
            answer += A[i] * B[len-1-i]; 
        }
        
        return answer; 
    }
}
