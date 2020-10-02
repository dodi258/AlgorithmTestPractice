/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct01_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

public class BOJ_다이얼 {
    public static void main(String[] args) throws IOException {
        int[] alphabet = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9}; 
        int time = 0; 
        
        for(int in = System.in.read(); in >= 'A'; in = System.in.read()) {
            time += alphabet[in - 'A'] + 1; 
        }
        System.out.println(time); 
    }
    
    
}
