/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep26_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_네트워크_복습 {
    public static void main(String[] args) {
        int n = 3; 
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; 
        System.out.println(solution(n, computers)); 
        
    }
    
    public static int solution(int n, int[][] computers) {
        int answer = 0; 
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            answer += visitComputers(visited, i, computers); 
            if (isAllVisited(visited))
                break; 
        }
        
        return answer; 
    }
    
    public static int visitComputers(boolean[] visited, int start, int[][] computers) {
        int network = 0; 
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(start); 
        
        while(!queue.isEmpty()) {
            int now = queue.poll(); 
            if (visited[now]) continue; 
            visited[now] = true; 
            network = 1; 
            for(int i = 0; i < computers.length; i++) {
                if (computers[now][i] == 1 && !visited[i])
                    queue.add(i); 
            }
        }
        
        return network; 
    }
    
    public static boolean isAllVisited(boolean[] visited) {
        for(int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false; 
        }
        
        return true; 
    }
}
