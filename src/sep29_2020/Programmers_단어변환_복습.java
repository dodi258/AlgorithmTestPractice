/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep29_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*;

public class Programmers_단어변환_복습 {
//    public static void main(String[] args) {
//        String begin = "hit"; 
//        String target = "cog"; 
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; 
//        
//        System.out.println(solution(begin, target, words)); 
//    }
    
    public static int solution(String begin, String target, String[] words) {
        int answer =0; 
        
        boolean[] visited = new boolean[words.length]; 
        Queue<Word> queue = new LinkedList<>(); 
        queue.add(new Word(-1, begin, 0)); 
        
        int wordLength = begin.length(); 
        while(! queue.isEmpty()) {
            Word now = queue.poll(); 
//            System.out.println(now.value); 
            
            
            if (now.value.equals(target)) {
                answer = now.cnt; 
                break; 
            }
//            
//            if (now.index != -1) 
//                visited[now.index] = true; 
           
            for(int i = 0; i < words.length; i++) {
                if (visited[i]) continue; 
                
                int diffCnt = 0; 
                String next = words[i]; 
                
                for(int j = 0; j < wordLength; j++) {
                    if (now.value.charAt(j) != next.charAt(j)) {
                        diffCnt ++; 
                    }
                } 
                if (diffCnt == 1) {
                    visited[i] = true; 
//                    System.out.println("start: " + now.value + " , next: " + next ); 
                    queue.add(new Word(i, next, now.cnt + 1)); 
                }
            }
        }
        
        return answer; 
    }
    
    static class Word {
        int index; 
        String value; 
        int cnt; 
        
        Word(int index, String value, int cnt) {
            this.index = index; 
            this.value = value; 
            this.cnt = cnt; 
        }
    }
}
