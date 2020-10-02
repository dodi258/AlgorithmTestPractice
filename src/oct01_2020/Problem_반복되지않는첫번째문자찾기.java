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

public class Problem_반복되지않는첫번째문자찾기 {
//    public static void main(String[] args) {
//        System.out.println(solution("teeter"));
//    }
    
    public static char solution(String s) {
        char answer = 0; 
        Map<Character, Boolean> alphabet = new HashMap();
        Boolean TRUE = true; 
        Boolean FALSE = false; 
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if (alphabet.containsKey(c)) {
                alphabet.put(c, FALSE); 
            }
            else {
                alphabet.put(c, TRUE); 
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (alphabet.get(c)) {
                answer = c; 
                break; 
            }
        }
        
        return answer; 
    }
}
