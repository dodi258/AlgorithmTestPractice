/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug30_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*; 

public class BOJ_부분수열의합 {
    public static void main(String[] args) throws IOException {
        int answer = 0; 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int S = Integer.parseInt(st.nextToken()); 
        int[] numbers = new int[N];
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()); 
        }
        
        for(int i = 1; i < (1 << N); i++) {
            int sum = 0; 
            for(int k = 0; k < N; k++) {
                if ((i & (1 << k)) != 0) {
                    sum += numbers[k]; 
                }
            }
            
            if (sum == S) answer ++; 
        }
        
        System.out.println(answer); 
    }
    
}
