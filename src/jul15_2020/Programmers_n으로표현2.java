/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul15_2020;

import java.util.ArrayList;
import java.util.HashSet; 
/**
 *
 * @author 주세인1
 */
public class Programmers_n으로표현2 {
//    public static void main(String[] args) {
//        System.out.println(solution(5, 12)); 
//        System.out.println(solution(4, 17)); 
//        System.out.println(solution(2, 11)); 
//    }
    
    public static int solution(int N, int number) {
        if (number == N) return 1; 
        
        HashSet<Integer>[] numbers = new HashSet[9];
        HashSet<String>[] strings = new HashSet[9]; 
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 1; i < 9; i++) {
            sb.append(N); 
            numbers[i] = new HashSet<Integer>(); 
            strings[i] = new HashSet<String>(); 
            numbers[i].add(Integer.parseInt(sb.toString())); 
            strings[i].add(sb.toString()); 
        }
        
        for(int i = 1; i < 9; i++) {
            System.out.println(numbers[i]); 
        }
        
        for(int i = 2; i < 9; i++){
            for(int j = 1; j < i; j ++) {
                for(int num1: numbers[j]) {
                    for(int num2: numbers[i-j]) {
                        numbers[i].add(num1 + num2);
                        strings[i].add(strings[j] + "+" + strings[i-j]); 
                        numbers[i].add(num1 - num2); 
                        strings[i].add(strings[j] + "-" +strings[i-j]); 
                        numbers[i].add(num1 * num2); 
                        strings[i].add(strings[j] + "*" +strings[i-j]); 
                        if (num2 != 0) {
                            numbers[i].add(num1 / num2); 
                            strings[i].add(strings[j] + "/" +strings[i-j]); 
                        }
                    }
                }
            }
            
                    for(int j = 1; j < 9; j++) {
            System.out.println(numbers[j]); 
        }
                    
                    for(int j = 1; j < 9; j++) {
            System.out.println(strings[j]); 
        }
            
            if(numbers[i].contains(number))
                return i; 
        }

        
        return -1; 
    }
}
