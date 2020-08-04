/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul30_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays;
import java.util.ArrayList; 
import java.util.Set; 
import java.util.HashSet; 
public class Programmers_순위 {
//    public static void main(String[] args) {
//        int n = 5; 
//        int[][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}}; 
//        System.out.println(solution(5, results)); 
//    }
    
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] relations = new int[n+1][n+1];
        int[][] play_cnt = new int[n+1][2]; 
        ArrayList<Set<Integer>>[] result = new ArrayList[n+1]; 
        
        for(int i = 0; i <= n; i++) {
            result[i] = new ArrayList<>();
            result[i].add(new HashSet<Integer>()); 
            result[i].add(new HashSet<Integer>()); 
            play_cnt[i][0] = i; 
        }
        for(int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1]; 
            // 이김

            result[win].get(0).add(lose); 
            play_cnt[win][1]++; 
            // 짐

            result[lose].get(1).add(win); 
            play_cnt[lose][1]++; 
        }
        
        Arrays.sort(play_cnt, (b, a) -> Integer.compare(a[1], b[1])); 
        
        // 내가 이긴 상대는 내가 진 상대가 무조건 이김. 
        // 내가 진 상대는 내가 이긴상대가 무조건 짐. 
        for(int i = 0; i <= n; i++) {
            int player = play_cnt[i][0]; 
            Set<Integer> losers = result[player].get(0);
            Set<Integer> winners = result[player].get(1); 
            
            for(int winner: winners) {
                for(int loser: losers) {

                    result[loser].get(1).add(winner); 

                    result[winner].get(0).add(loser); 
                }
            }
        }
        int cnt; 
        for(int i= 1; i <= n; i++) {
            cnt = 0; 
            ArrayList<Set<Integer>> player_result = result[i]; 
            cnt += player_result.get(0).size();
            cnt += player_result.get(1).size(); 
            if (cnt == n -1) answer++; 
        }
        
        return answer; 
    }
}
