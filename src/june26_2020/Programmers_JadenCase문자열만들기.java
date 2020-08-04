/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june26_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_JadenCase문자열만들기 {
//    public static void main(String[] args) {
//        String str1 = "3people unFollowed me"; 
//        String str2 = "for the last week"; 
//        
//        System.out.println(solution(str1));
//        System.out.println(solution(str2)); 
//    }
    
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder(); 
        
        char prev = s.charAt(0); 
        sb.append(Character.toUpperCase(prev)); 
        
        for(int i = 1; i < s.length(); i++) {
            char now = s.charAt(i); 
            if(prev == ' ') {
                sb.append(Character.toUpperCase(now)); 
            }
            
            else {
                sb.append(Character.toLowerCase(now)); 
            }
            
            prev = now; 
        }
//        for(String str: arr) {
//            sb.append(" "); 
//            sb.append(Character.toUpperCase(str.charAt(0)));
//            sb.append(str.substring(1).toLowerCase()); 
//        }
//        
//        sb.replace(0, 1, ""); 
        
        return sb.toString(); 
    }
}
