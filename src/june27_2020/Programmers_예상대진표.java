/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june27_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_예상대진표 {
//    public static void main(String[] args) {
//        System.out.println(solution(8, 4, 7));
//    }
    public static int solution(int n, int a, int b) {
        int answer = 0; 
        while(a != b) {
            answer++; 
            a = (a+1)/2; 
            b = (b+1)/2; 
        }
        
        return answer; 
    }
}
