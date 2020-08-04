/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul25_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class Programmers_예산 {
//    public static void main(String[] args) {
//        int[] budgets = {120, 110, 140, 150};
//        int M = 485; 
//        int[] budgets2 = {100, 120, 100, 120, 150};
//        int M2 = 400; 
//        System.out.println(solution(budgets2, M2)); 
////        System.out.println(solution(budgets, M)); 
//    }
    
    public static int solution(int[] budgets, int M) {
        int n = budgets.length;
        int sum = 0; 
        Arrays.sort(budgets);
        for(int i = 0; i < n; i++) {
            sum += budgets[i]; 
        }
        
        if (sum <= M) return budgets[n-1]; 
       
        int min = 0; 
        int max = budgets[n-1]; 
        int mid = 0;
        
        while(min <= max) {
            mid = (max + min) / 2; 
            sum = 0; 
            for(int i = 0; i < n; i++) {
                sum += Math.min(budgets[i], mid); 
            }
            
            if (sum <= M) {
                min = mid + 1; 
            }
            
            else {
                max = mid - 1; 
            }
        }
        
        return mid; 
    }
}
