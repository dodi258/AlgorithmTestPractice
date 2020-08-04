/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul15_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

public class Programmers_2xn타일링 {
    public static void main(String[] args) {
        
    }
    
    public int solution(int n) {
        int[] tiles = new int[n+1]; 
        tiles[1] = 1; 
        
        if (n > 1) tiles[2] = 2; 
        if (n > 2) {
            for(int i = 3; i <= n; i++) {
                tiles[i] = (tiles[i-1] + tiles[i-2])%1000000007; 
            }
        }
        return tiles[n]; 
    }
    
    
}
