/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct07_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 

public class Programmers_N으로표현 {
//    public static void main(String[] args) {
//        int N = 5; 
//        int number = 12; 
//        System.out.println(solution(2, 11)); 
//  
//    }
    public static int result; 
    public static HashMap<Integer, Integer> Ns; 
    public static int solution(int N, int number) {
        Ns = new HashMap<>(); 
        StringBuilder sb = new StringBuilder(); 
        result = Integer.MAX_VALUE; 

        //8 초과이면 안되기 때문에 
        for(int i = 1; i <= 8; i++) {
            sb.append(N); 
            Ns.put(i, Integer.parseInt(sb.toString())); 
        }
        
        makeTheNumber(number, 0, 0); 
        
        if (result == Integer.MAX_VALUE) 
            return -1; 
        
        return result; 
    }
    
    public static void makeTheNumber(int number, int cnt, int curr_num) {
        if (curr_num == number) {
            result = cnt; 
            return; 
        }
        
        if (cnt >= 8 || cnt >= result) return; 
        
        for(int i = 1; i <= 8; i ++) {
            int N = Ns.get(i); 
            makeTheNumber(number, cnt + i, curr_num + N); 
            makeTheNumber(number, cnt + i, curr_num - N); 
            makeTheNumber(number, cnt + i, curr_num * N); 
            makeTheNumber(number, cnt + i, curr_num / N); 
        }
    }
}
