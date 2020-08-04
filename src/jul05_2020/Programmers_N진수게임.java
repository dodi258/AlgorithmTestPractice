/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul05_2020;

/**
 *
 * @author 주세인1
 */
import java.util.HashMap; 

public class Programmers_N진수게임 {
//    public static void main(String[] args) {
//        System.out.println(solution(2, 4, 2, 1)); 
//        System.out.println(solution(16, 16, 2, 1)); 
//        System.out.println(solution(16, 16, 2, 2)); 
//        
//        
//    }
    
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder("0"); 
        int num = 1; 
        while(sb.length() < t * m) {
            sb.append(toNNotation(num, n));
            num++; 
        }
        
        String numbers = sb.toString(); 
        sb = new StringBuilder(); 
        for(int i = 0; i < t; i++) {
            sb.append(numbers.charAt((p -1) + m * i)); 
        }
        return sb.toString(); 
    }
    
    public static String toNNotation(int num, int n) {
        
        HashMap<Integer, String> map = new HashMap<>(); 
        map.put(10, "A"); 
        map.put(11, "B"); 
        map.put(12, "C"); 
        map.put(13, "D"); 
        map.put(14, "E"); 
        map.put(15, "F"); 
        
        StringBuilder sb = new StringBuilder(); 
        
        while(num > 0) {
            int remain = num % n; 
            if (remain >= 10) {
                sb.insert(0,map.get(remain)); 
            }
            
            else {
                sb.insert(0, remain); 
            }
            
            num /= n; 
        }
        
        return sb.toString(); 
    }
}
