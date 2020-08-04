/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june28_2020;

/**
 *
 * @author 주세인1
 */

import java.util.HashMap; 
import java.util.HashSet;  
import java.util.regex.Pattern; 
public class Programmers_뉴스클러스터링 {
    static HashSet<String> set = new HashSet<>(); 
//    public static void main(String[] args) {
//        String str1_1 = "FRANCE"; 
//        String str2_1 = "french"; 
//        
//        String str1_2 = "handshake"; 
//        String str2_2 = "shake hands"; 
//        
//        String str1_3 = "aa1+aa2"; 
//        String str2_3 = "AAAA12"; 
//        
//        String str1_4 = "E=M*C^2"; 
//        String str2_4 = "e=m*c^2"; 
//        
//        System.out.println(solution(str1_1, str2_1)); 
//        System.out.println(solution(str1_2, str2_2)); 
//        System.out.println(solution(str1_3, str2_3)); 
//        System.out.println(solution(str1_4, str2_4)); 
//    }
//    
    public static int solution(String str1, String str2) {
        int answer = 0;
        int len1 = str1.length(); 
        int len2 = str2.length(); 
        
        if (len1 == 0 && len2 == 0) return 65536; 
        str1 = str1.toLowerCase(); 
        str2 = str2.toLowerCase(); 
        
        HashMap<String, Integer> str1Map = getMap(str1); 
        HashMap<String, Integer> str2Map = getMap(str2); 
        
        if (str1Map.isEmpty() && str2Map.isEmpty()) return 65536; 
        float union = 0; 
        float inter = 0; 
        
        for(String word: set) {
            int cnt1 = str1Map.getOrDefault(word, 0); 
            int cnt2 = str2Map.getOrDefault(word, 0); 
            
            union += cnt1 > cnt2 ? cnt1: cnt2; 
            inter += cnt1 > cnt2 ? cnt2: cnt1; 
        }
        
        answer = (int) (inter/union * 65536);
        return answer;
    }
    
    public static HashMap getMap(String str) {
        int len = str.length(); 
        HashMap<String, Integer> strMap = new HashMap<>(); 
//        str = str.replaceAll("[^a-z]", " "); 

        for(int i = 0; i < len -1; i++) {
//            
//            if (str.charAt(i) == ' ') continue; 
//            if (str.charAt(i +1) == ' ') {
//                i++; 
//                continue; 
//            }
            StringBuilder sb = new StringBuilder();
            
            sb.append(str.charAt(i)); 
            sb.append(str.charAt(i+1)); 
            
            String word = sb.toString(); 
            
            if (word.matches("^[a-z]+$")) {
                strMap.put(word, strMap.getOrDefault(word, 0) + 1);
                set.add(word);
            } 
             
        }
        
        return strMap; 
    }
    
}
