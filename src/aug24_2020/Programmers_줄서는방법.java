/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_줄서는방법 {
    private static int N; 
    private static long K; 
    public static void main(String[] args) {
        int n = 6; 
        long k = 140; 
        
        System.out.println(Arrays.toString(solution(n, k))); 
    }
    
    private static int[] solution(int n, long k) {
        N = n; 
        K = k; 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; ++i) list.add(i);
    
        return findNumberSequence(0, 0, new int[n], list);
    }
    
    public static int[] findNumberSequence(long order, int idx, int[] sequence, ArrayList<Integer> list){
        if(idx == N){
            return sequence;
        }
        
        int num = 0;
        long next = factorial(N - (idx + 1));
        int i = 0; 
        
        while(true){
            num = list.get(i);
            if(order + next >= K) break;
            order += next;
            i++; 
        }
            
        sequence[idx] = num;
        list.remove(i); 
        
        return findNumberSequence(order, idx + 1, sequence, list);
    }
    
    public static long factorial(int n){
        long answer = 1; 
        
        while(n > 1) {
            answer *= n--; 
        }
        return answer; 
    }
}
