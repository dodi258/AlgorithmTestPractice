/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug28_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_기지국설치_시간초과 {
//    public static void main(String[] args) {
//        int N1 = 11; 
//        int[] stations1 = {4, 11};
//        int W1 = 1; 
//        
//        int N2 = 16; 
//        int[] stations2 = {9}; 
//        int W2 = 2; 
//        
//        System.out.println(solution(N1, stations1, W1));
//        System.out.println(solution(N2, stations2, W2)); 
//        
//    }
//    
    public static int solution(int n,int[] stations, int w) {
        int answer = 0;
        boolean[] transmitted  = new boolean[n]; 
        int station; 
        for(int i = 0; i < stations.length; i++) {
            station = stations[i]-1; 
            int index = station; 
            // 왼쪽
            while(index >= 0 && index >= station - w) {
                transmitted[index--] = true;  
            }
            // 오른쪽
            index = station; 
            while(index < n && index <= station + w) {
                transmitted[index++] = true;
            }
        }
        int unit = w * 2 + 1; 
        int cnt = 0; 
        for(int i = 0; i < n; i++) {
            if (! transmitted[i]) {
                cnt ++;
                if (cnt == unit) {
                    answer ++;
                    cnt = 0; 
                } 
            } 
            else {
                if (cnt > 0) {
                    answer ++; 
                    cnt = 0; 
                } 
            }
        }
        // 마지막
        if (cnt > 0)
            answer ++; 
        
        return answer; 
    }
}
