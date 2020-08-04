/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul15_2020;

/**
 *
 * @author 주세인1
 */
import java.util.ArrayList; 

public class Programmers_n으로표현 {
//    public static void main(String[] args) {
//        System.out.println(solution(5, 12));
//        System.out.println(solution(2, 11));
//    }
    
    public static int solution(int N, int number) {
        boolean[] exist = new boolean[100000000];
        
        ArrayList<Integer>[] numbers = new ArrayList[9];
        for(int i = 0; i < 9; i++) {
            numbers[i] = new ArrayList<Integer>(); 
        }
        // 숫자 1개로만 이루어진 조합. 
        numbers[1].add(N); 
        exist[N] = true; 

        
        for(int i = 2; i < 9; i++) {
            ArrayList<Integer> list = new ArrayList<>(); 
            for(int j = 0; j < numbers[i-1].size(); j++) {
                // 사칙연산
                int newNum = 0;
                int num = numbers[i-1].get(j); 
                if (number == num)
                    return i-1; 
                
                // 더하기 
                newNum = num + N;
                if (! exist[newNum]) {
                    exist[newNum] = true;
                    list.add(newNum); 
                }
                // 빼기 
                // 빼기1
                newNum = num - N; 
                if (newNum >= 1 && ! exist[newNum]) {
                    exist[newNum] = true; 
                    list.add(newNum); 
                }
                // 빼기2
                newNum = N - num; 
                if (newNum >= 1 && !exist[newNum]) {
                    exist[newNum] = true; 
                    list.add(newNum); 
                }
                // 나누기
                // 나누기1
                newNum = N/num; 
                if (newNum >= 1 && !exist[newNum]) {
                    exist[newNum] = true;
                    list.add(newNum); 
                }
                // 나누기2
                newNum = num/N; 
                if (newNum >= 1 && !exist[newNum]) {
                    exist[newNum] = true;
                    list.add(newNum); 
                }
                // 곱하기 
                newNum = num * N; 
                if (!exist[newNum]) {
                    exist[newNum] = true; 
                    list.add(newNum);
                } 
            }
            //자릿수 한개 더 더하기 
            StringBuilder sb = new StringBuilder(); 
            for(int k = 0; k < i; k++) {
                sb.append(N); 
            }
            
            list.add(Integer.parseInt(sb.toString())); 
            numbers[i] = list; 
        }
       
        
        return -1; 
    }
}
