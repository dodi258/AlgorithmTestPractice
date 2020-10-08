/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct08_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
public class Programmers_야근지수_복습 {
//    public static void main(String[] args) {
//        
//    }
    
    public long solution(int n, int[] works) {
        long answer = 0; 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work: works) {
            pq.add(work); 
        }
        while(n --> 0) {
            int work = pq.poll(); 
            if (work == 0) break;  
            
            work -= 1; 
            pq.add(work); 
        }
        
        for(int work: pq) {
            answer += work * work; 
        }
        
        return answer; 
    }
    
}
