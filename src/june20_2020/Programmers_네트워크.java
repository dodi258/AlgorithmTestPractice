/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june20_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_네트워크 {
    static boolean[] visited; 
    public int solution(int n, int[][] computers) {
        int answer = 0; 
        visited = new boolean[computers.length]; 
        
        for(int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                answer ++; 
                dfs(i, computers); 
            }
        }
        return answer; 
    }
    
    public void dfs(int num, int[][] computers) {
        visited[num] = true; // 방문했다고 알려주기 
        
        for(int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[num][i] == 1) {
                dfs(i, computers); 
            }
        }
    }
}
