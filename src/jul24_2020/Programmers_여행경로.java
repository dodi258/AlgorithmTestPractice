/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.List;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Comparator; 

public class Programmers_여행경로 {
    
    public static boolean[] visited; 
    public static List<String> destinations; 
    public static List<List<String>> answers; 
//    public static void main(String[] args) {
//        String[][] tickets1 = {{"ICN", "JFK"},{"HND","IAD"},{"JKF","HND"}};
//        String[][] tickets2 = {{"ICN", "SFO"},{"ICN","ATL"},{"SFO","ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}; 
////        System.out.println(Arrays.toString(solution(tickets1))); 
////        System.out.println("1절 끝.!!!!!!!"); 
//        System.out.println("answer = " +Arrays.toString( solution(tickets2))); 
//    }
    public static String[] solution(String[][] tickets) {
        
        int length = tickets.length; 
        answers = new ArrayList<List<String>>(); 
        
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                
                if (s1[0].equals(s2[0])) 
                {
                    String[] arr = {s1[1], s2[1]};
                    Arrays.sort(arr); 
                    if (arr[0].equals(s1[1])) return -1; 
                    else return 1; 
                }
                
                else {
                    String[] arr = {s1[0], s2[0]}; 
                    Arrays.sort(arr);
                    if (arr[0].equals(s1[0])) return -1; 
                    return 1; 
                }

                
            }
        });
        
        for(int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(tickets[i])); 
        }
        
        for(int i = 0; i < length; i++) {
            String[] ticket = tickets[i]; 
            if (ticket[0].equals("ICN")) {
            visited = new boolean[tickets.length]; 
            destinations.clear(); 
            destinations.add(ticket[0]);
            visited[i] = true; 
            dfs(ticket[1], tickets, i); 
            if (answers.size() > 0) break; 
            }
        }

        String[] answer = answers.get(0).toArray(new String[length + 1]); 
        return answer; 
    }
    
    public static void dfs(String dest, String[][] tickets, int index) {
        
        if (destinations.size() == tickets.length) {
            destinations.add(tickets[index][1]); 
            answers.add(new ArrayList<>(destinations)); 
            destinations.remove(tickets.length); 
            return; 
        }
        
        else {
            for(int i = 0; i < tickets.length; i++) {
                if(visited[i]) continue; 
                if(tickets[i][0].equals(dest)) {
                    destinations.add(tickets[i][0]); 
                    visited[i] = true; 
                    System.out.println("mid:" + Arrays.toString(destinations.toArray())); 
                    dfs(tickets[i][1], tickets, i); 
                    destinations.remove(tickets[i][0]); 
                    visited[i] = false; 
                }
            }
        }
        
    } 
}
