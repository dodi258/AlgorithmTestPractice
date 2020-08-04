/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul29_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_가장긴팰린드롬 {
//    public static void main(String[] args) {
////        String s1 = "abcdcba"; 
////        String s2 = "abacde";
//        String s3 = "qwertrewqq"; 
////        System.out.println(solution(s1)); 
////        System.out.println(solution(s2));
//        System.out.println(solution(s3));
//    }
    
    public static int solution(String s) {
        int answer = 0;
        int s_length = s.length(); 
        for(int i = 0; i < s_length; i++) {
            int length = 0; 
            int front = i; 
            int back = s_length-1;
            int back_cnt = 1; 
            while(back >= front && front < s_length) {
                if (s.charAt(front) == s.charAt(back)) {
                    if (front == back) length += 1; 
                    else length += 2; 
                    
                    front ++; 
                }
                
                else{
                    length = 0; 
                    back = s_length - back_cnt; 
                    front = i; 
                    back_cnt ++; 
                }
                back --; 
            }
            answer = Math.max(answer, length); 
        }
        
        return answer; 
    }
    
}
