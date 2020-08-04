package june27_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.Stack; 

public class Programmers_짝지어제거하기 {
//    public static void main(String[] args) {
//        String s1 = "baabaa"; 
//        String s2 = "cdcd"; 
//        
//        System.out.println(solution(s1));
//        System.out.println(solution(s2));
//    }
    
    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0)); 
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (! stack.isEmpty() && c == stack.peek()) {
                stack.pop(); 
            }
            
            else {
                stack.push(c); 
            }
        }
        
        if (stack.isEmpty()) answer = 1; 
        
        return answer; 
    }
}
