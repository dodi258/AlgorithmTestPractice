/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug08_2020;

/**
 *
 * @author 주세인1
 */


public class Programmers_멀리뛰기 {
    public static void main(String[] args) {
        int n1 = 4; 
        int n2 = 3; 
        
        solution(n1);
        solution(n2); 
    }

    public static long solution(int n) {
      long[] ways = new long[n+1]; 
        if (n == 1) 
            return 1; 
        ways[1] = 1; 
        ways[2] = 2; 

        for(int i = 3; i <= n; i++) {
            ways[i] = ( ways[i-2] + ways[i-1] ) % 1234567; 
        }
        
        return ways[n]; 
    }
}
