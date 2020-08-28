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
import java.util.ArrayList; 
public class Programmers_기지국설치 {
     public static void main(String[] args) {
        int N1 = 11; 
        int[] stations1 = {4, 11};
        int W1 = 1; 
        
        int N2 = 16; 
        int[] stations2 = {9}; 
        int W2 = 2; 
        
        System.out.println(solution(N1, stations1, W1));
        System.out.println(solution(N2, stations2, W2)); 
        
    }
    
    public static int solution(int n,int[] stations, int w) {
        int answer = 0; 
        int unit = w * 2 + 1; 
        int now = 0; // 현재 station 이 있는 동 
        int index = 1; // 1 ~ n 동까지 순회
        
        while(index <= n) {
            if (now < stations.length && index >= stations[now] - w) {
                index = stations[now] + w + 1; 
                now ++; 
            }
            else {
                answer += 1; 
                index += (unit); 
            }
        }
        
        return answer; 
    }
}

