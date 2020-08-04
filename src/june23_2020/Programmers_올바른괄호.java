/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june23_2020;

/**
 *
 * @author 주세인1
 */

import java.util.Stack; 

public class Programmers_올바른괄호 {
//    public static void main(String[] args) {
//        System.out.println(solution("()()")); 
//        System.out.println(solution("(())()")); 
//        System.out.println(solution(")()(")); 
//        System.out.println(solution("(()(")); 
//    }
    
    // Stack을 쓴 풀이 => 2중 if 때문에 더 느린듯 하다. 
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); 
        boolean answer = false; 
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (c == '(')
                stack.push(c); 
            else
                if (! stack.isEmpty())
                    stack.pop();
                else 
                    break; 
        }
        
        if (stack.isEmpty())
            answer = true; 
        
        return answer; 
    }
    
    // Stack을 쓰지 않은 풀이 => 훨 빠르다
    public static boolean solution2(String s) {
        boolean answer = false; 
        int count = 0; 
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if (c == '(') 
                count ++; 
            if (c == ')')
                count --; 
            if (count < 0)
                break; 
        }
        if (count == 0) 
            answer = true; 
        
        return answer; 
    }
}
