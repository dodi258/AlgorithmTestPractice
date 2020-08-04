package jul03_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.HashMap; 
import java.util.ArrayList; 

public class Programmers_압축 {
//    public static void main(String[] args) {
//        String msg1 = "KAKAO"; 
//        String msg2 = "TOBEORNOTTOBEORTOBEORNOT"; 
//        String msg3 = "ABABABABABABABAB"; 
//        
////        System.out.println(Arrays.toString(solution(msg1)));
////        System.out.println(Arrays.toString(solution(msg2)));
////        System.out.println(Arrays.toString(solution(msg3)));
//    }
    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        HashMap<String, Integer> dictionary = initDictionary(); 
        String[] words = msg.split(""); 
        StringBuilder word;
        
        
        for(int i = 0; i < words.length; i++) {
            word = new StringBuilder(); 
            int prev_index = -1; 
            int j = i; 
            for(; j < words.length; j++) {
                word.append(words[j]); 
                int index = dictionary.getOrDefault(word.toString(), -1); 
                if (index == -1) {
                    dictionary.put(word.toString(), dictionary.size()+1);
                    break; 
                }
                prev_index = index; 
            }
            answer.add(prev_index); 
            i = j-1; 
        }

        return answer.stream().mapToInt(i->i).toArray(); 
    }
    
    public static HashMap<String, Integer> initDictionary(){
        HashMap<String, Integer> dictionary = new HashMap<>(); 
        
        dictionary.put("A", 1);
        dictionary.put("B", 2);
        dictionary.put("C", 3);
        dictionary.put("D", 4);
        dictionary.put("E", 5);
        dictionary.put("F", 6);
        dictionary.put("G", 7);
        dictionary.put("H", 8);
        dictionary.put("I", 9);
        dictionary.put("J", 10);
        dictionary.put("K", 11);
        dictionary.put("L", 12);
        dictionary.put("M", 13);
        dictionary.put("N", 14);
        dictionary.put("O", 15);
        dictionary.put("P", 16);
        dictionary.put("Q", 17);
        dictionary.put("R", 18);
        dictionary.put("S", 19);
        dictionary.put("T", 20);
        dictionary.put("U", 21);
        dictionary.put("V", 22);
        dictionary.put("W", 23);
        dictionary.put("X", 24);
        dictionary.put("Y", 25);
        dictionary.put("Z", 26);
        
        return dictionary; 
    }
}
