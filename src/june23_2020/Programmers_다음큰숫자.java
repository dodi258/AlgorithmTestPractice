/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june23_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_다음큰숫자 {
//    public static void main(String[] args) {
//        System.out.println(solution(78)); 
//        System.out.println(solution(15)); 
//    }
    
    //solution 함수
    public static int solution(int n) {
        //숫자 n에 들어있는 1의 개수
        int nCnt = count1InBinary(n); 
        
        // 반환된 1의 개수가 nCnt의 개수와 같을때까지 
        while(count1InBinary(++n) != nCnt){}
        
        return n; 
    }
    
    // 이진수를 만들면서 숫자 1이 몇개있는지 세는 함수
    public static int count1InBinary(int n) {
        int cnt = 0; 
        while(n > 0) {
            cnt += n % 2; 
            n /= 2; 
        }
        
        return cnt;  
    }
}
