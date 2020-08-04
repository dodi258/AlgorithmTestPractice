/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul22_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_네트워크 {
    static boolean[] visited; 
//    public static void main(String[] args) {
//        int n1 = 3; 
//        int n2 = 3; 
//        
//        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; 
//        System.out.println(solution(n1, computers1)); 
//        System.out.println(solution(n2, computers2)); 
//    }
    
    public static int solution(int n, int[][] computers) {
        int answer = 0; 
        visited = new boolean[n];  
        
        for(int i = 0; i < n; i++) {
            if (visited[i]) continue; 
            answer ++; 
            visitUnion(i, computers); 
        }
        
        return answer; 
    }
    
    public static void visitUnion(int num, int[][] computers) {
        visited[num] = true; 
        
        for(int i = 0; i < visited.length; i++) {
            if (computers[num][i] != 1 || visited[i]) continue; 
            visitUnion(i, computers); 
        }
    }
}
