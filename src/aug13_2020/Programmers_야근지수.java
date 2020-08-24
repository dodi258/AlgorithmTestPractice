/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug13_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_야근지수 {
    public static void main(String[] args) {
        int[] works1 = {4 ,3, 3};
        int[] works2 = {2, 1, 1};
        int[] works3 = {1, 1}; 
        int[] works4 = {6, 5, 4}; 
        int[] works5 = {7, 6, 1}; 
        int n1 = 4; 
        int n2 = 1; 
        int n3 = 3; 
        int n4 = 10;  
        int n5 = 3; 
        
        System.out.println(solution(n5, works5)); 
        
    }
    
    public static long solution(int n, int[] works) {
        long answer= 0; 
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); 
        for(int work : works) {
            queue.add(work); 
        }
        
        while(n --> 0) {
            int work = queue.poll(); 
            if (work == 0) {
                queue.add(work); 
                break;
            } 
            work -= 1; 
            queue.add(work); 
        }
        
        for(int work: queue) {
            answer += work * work; 
        }
        return answer; 
    }
}
