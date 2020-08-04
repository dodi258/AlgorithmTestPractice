package june25_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *
 *
 *주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
 */

/**
 *
 * @author 주세인1
 */
public class Programmers_숫자의표현 {
//    
//    public static void main(String[] args) {
//        System.out.println(solution(15)); 
//    }
//    
    public static int solution(int n) {
        int answer = 0; 

        for(int i = 1; i <= n; i++) {
             int sum = 0; 
            for(int j = i; j <= n; j++) {
                sum += j; 
                if (sum == n) {
                    answer ++; 
                    break; 
                }
                
                else if (sum > n) {
                    break; 
                }
            }
            
        }
        return answer; 
    }
    
}
