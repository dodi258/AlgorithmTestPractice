/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul19_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

public class Programmers_단어변환 {
    public static boolean[] visited; 
    public static int n; 
    public static String end; 
    public static String[] arr; 
    public static int min; 
//    public static void main(String[] args) throws IOException {
//        String begin = "hit"; 
//        String target = "cog"; 
//        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words2 = {"hot", "dot", "dog", "lot", "log"}; 
////        
//        System.out.println(solution(begin, target, words1)); 
//        System.out.println(solution(begin, target, words2)); 
//    }
    
    public static int solution(String begin, String target, String[] words) {
        n = words.length; 
        min = Integer.MAX_VALUE; 
        end = target; 
        visited = new boolean[n];
        arr = words; 
        changeWord(begin, 0); 
        
        
        return min== Integer.MAX_VALUE?-1: min; 
    }
    
    public static void changeWord(String word, int cnt) {
        if (word.equals(end) && cnt != 0) {
            min = Math.min(min, cnt); 
            return; 
        }
        
        for(int i = 0; i < n; i++) {
            if (visited[i]) continue;  
//            System.out.println(arr[i]); 
            if (isOneDiff(word.toString(), arr[i])) {
                visited[i] = true; 
                word = arr[i];  
                changeWord(word, cnt+1); 
            }           
        }
    }
    
    public static boolean isOneDiff(String w1, String w2){
        int cnt = 0; 
        char[] arr1 = w1.toCharArray(); 
        char[] arr2 = w2.toCharArray(); 
//        System.out.println("arr1: " + Arrays.toString(arr1));
//        System.out.println("arr2: " + Arrays.toString(arr2));

        for(int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) continue; 
            cnt++; 

        }
        
        return cnt==1? true: false; 
    }
}
