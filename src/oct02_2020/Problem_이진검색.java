/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct02_2020;

/**
 *
 * @author 주세인1
 */
public class Problem_이진검색 {
//    public static void main(String[] args) {
//        int[] array = {1, 3, 5, 6, 7, 8, 9}; 
//        
//        System.out.println(solution(array, 7)); 
//    }
    
    public static int solution(int[] array, int target) {
        int start = 0; 
        int end = array.length - 1; 
        int mid = 0; 
        int maxMid = 0; 
        while(start <= end) {
            mid = (start + end) / 2; 
            
            if (array[mid] > target) {
                end = mid - 1;
                
            }
            else {
                start = mid + 1; 

            }
        }
        
        return mid; 
    }
}
