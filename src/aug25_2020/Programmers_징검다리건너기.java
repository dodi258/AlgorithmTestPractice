/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug25_2020;

/**
 *
 * @author 주세인1
 */

public class Programmers_징검다리건너기 {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3; 
        System.out.println(solution(stones, k)); 
    }

    public static int solution(int[] stones, int k) {
        int min = 1; // 징검다리는 최소 1 
        int max = 0; 
        int mid = 0; 
        
        for(int i = 0; i < stones.length; i++) {
            max = Math.max(stones[i], max); 
        }
        
        // 이분탐색 
        while(min <= max) {
            mid = (min + max) / 2; 
            
            // if : 징검다리를 건널 수 있는 인원이라면 
            if (crossTheBridge(stones, k, mid)) {
                min = mid + 1; 
            }
            // if : 징검다리를 건널 수 없는 인원이라면 
            else {
                max = mid - 1; 
            }
        }
        
        return max; 
    }
    
    public static boolean crossTheBridge(int[] stones, int k, int people) {
        int skip_cnt = 0; 
        for(int i = 0; i < stones.length; i++) {
            if (stones[i] - people >= 0) {
                skip_cnt = 0; 
            }
            else {
                skip_cnt ++;
                if (skip_cnt > k) return false; 
            }
        }
        return true; 
    }
}
