/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct01_2020;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 주세인1
 */
public class Problem_특정문자의삭제 {
//    public static void main(String[] args) {
//        System.out.println(removeChar("Battle of the Vowels: Hawaii vs.Grozny", "aeiou"));
//    }
     
    public static String removeChar(String str, String remove) {
         char[] targets = remove.toCharArray(); 
         char[] characters =  str.toCharArray(); 
         boolean[] flags = new boolean[128]; 
         StringBuilder sb = new StringBuilder(); 
         
        for(char target : targets) {
            flags[target] = true; 
        }
        
        for(char ch : characters) {
            if (flags[ch]) continue; 
            sb.append(ch); 
        }
        
        return sb.toString(); 
    }
}
