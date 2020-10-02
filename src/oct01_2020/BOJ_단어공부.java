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
import java.io.*; 

public class BOJ_단어공부 {
    
    public static void main(String[] args) throws IOException {
        int alphabet[] = new int[26]; 
        
        // 몇개 있는지 저장하고, 
        for(int i = System.in.read(); i >= 'A'; i = System.in.read()) {
            if (i > 'Z')
                alphabet[i - 'a'] ++; 
            
            else 
                alphabet[i - 'A'] ++; 
        }
        
        int maxIdx = 0; 
        int answer = 0; 
        
        for(int i = 1; i < 26; i++) {
            
            // 현재 저장된 값 보다 크면 갱신한다. 
            if(alphabet[maxIdx] < alphabet[i]) {
                maxIdx = i;
                answer = i; 
            }
            // 저장된 것이 같으면 answer = ? 저장 
            else if (alphabet[maxIdx] == alphabet[i]) {
                answer = 'A' - '?'; 
            }
        }
        
        // ? 의 아스키 코드를 찾아내면, answer + 'A' 를 해서 ? 의 아스키 코드가 나오도록 할 수 있다. 
        System.out.println((char) (answer + 'A')); 
        
    }
}
