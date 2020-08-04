/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.HashMap; 
import java.util.HashSet; 
public class Programmers_폰켓몬 {
//    public static void main(String[] args) {
//        
//    }
    
    public int solution(int[] nums) {
        int answer = 0; 
        int N = nums.length; 
        HashSet<Integer> monsters = new HashSet<>(); 
        
        for(int i = 0; i < N; i++) {
            monsters.add(nums[i]); 
        }
        
        if (monsters.size() > N/2) {
            answer = N/2; 
        }
        else answer = monsters.size(); 
        
        return answer; 
    }
}
