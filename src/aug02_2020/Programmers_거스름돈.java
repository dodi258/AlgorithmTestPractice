/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug02_2020;

/**
 *
 * @author 주세인1
 */

import java.util.Arrays; 

public class Programmers_거스름돈 {
    public static void main(String[] args) {
        
    }
    
    public static int solution(int n, int[] money) {
        Arrays.sort(money); 
        int[] ways = new int[n+1];
        int m = money[0]; 
        for(int i = 0; i <= n; i++) {
            ways[i] = i % m == 0? 1: 0;  
        }
        for(int i = 1; i < money.length; i++) {
            for(int j = money[i]; j <= n; j++) {
                ways[j] += ways[j - money[i]]; 
            }
        }
        
        return ways[n]; 
    }
}
