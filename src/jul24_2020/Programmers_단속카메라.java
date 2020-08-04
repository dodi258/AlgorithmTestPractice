/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 

public class Programmers_단속카메라 {
//    public static void main(String[] args) {
//        
//    }
    
    public static int solution(int[][] routes) {
        int answer = 0; 
        int camera = 300001; 
        
        Arrays.sort(routes, (b, a) -> Integer.compare(a[0], b[0]));
     
        for(int[] route: routes) {
            if (camera > route[1]) {
                camera = route[0]; 
                answer ++; 
            }
        }
        
        return answer; 
    }
}
