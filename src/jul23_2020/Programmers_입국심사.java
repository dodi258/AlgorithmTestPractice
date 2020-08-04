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
public class Programmers_입국심사 {
//    
//    public static void main(String[] args) {
//        int n = 6; 
//        int[] times = {7, 10};
//        System.out.println(solution(n, times)); 
//    }
      public static long solution(int n, int[] times) {
        Arrays.sort(times); 
        long sum = 0; 
        int length = times.length; 
        long min = 1; 
        long max = (long)times[length-1] * n; 
        long mid = (min + max) / 2; 
        long answer = max; 
        
        while(min <= max) {
            sum = 0; 
            mid = (min + max) / 2; 
            for(int i = 0; i < length; i++) {
                sum += mid/times[i]; 
                
            }
            if (sum < n) min = mid + 1; 
            else {
                if (mid <= answer) {
                    answer = mid;
                }
                max = mid -1; 
            }
        }
        return answer;
    }
      
     
      
}
