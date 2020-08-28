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

public class Programmers_기지국설치_시간초과2 {
//     public static void main(String[] args) {
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
    
    public static int solution(int n,int[] stations, int w) {
        int answer = 0; 

        int unit = w * 2 + 1;
        // 경우 1: 처음(index = 1) ~ stations[0]
        if (stations[0] - w - 1 > 0)
            answer += Math.ceil((stations[0] - w - 1)/(double)unit); 
//        System.out.println("answer: " + answer); 
        int start = 0; 
        int end = 0; 
        
        // 경우 2: stations[n] ~ stations[n+1]
        for(int i = 0; i < stations.length-1; i++) {
            start = stations[i] + w; 
            end = stations[i+1] - w - 1; 
            if (end - start > 0)
                answer += Math.ceil((end-start) / (double)unit); 

        }
//        System.out.println("answer: " + answer); 
        // 경우 3: stations[length-1] ~ 마지막
        if (n - stations[stations.length - 1] - w > 0)
            answer += Math.ceil((n-stations[stations.length-1]-w)/(double)unit); 
//        System.out.println("answer: " + answer); 
//        sections.add(n - (stations[stations.length -1] + w)); 

        
//         
//        for(int section: sections) {
////            System.out.println("section: " + section); 
//            if (section > 0) {
//                if (section <= unit) 
//                    answer += 1; 
//                else 
//                    answer += (int)Math.ceil(section/(double)unit); 
//            }
//        }
        
        return answer; 
    }
}
