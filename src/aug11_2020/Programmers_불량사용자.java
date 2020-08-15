/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug11_2020;

/**
 *
 * @author 주세인1
 */

import java.util.regex.Pattern; 
import java.util.*; 
public class Programmers_불량사용자 {
    
    static boolean[] visited; 
    static ArrayList<Integer>[] matched;  
    static int len; 
    static Set<String> set; 
    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};
        
        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};
        
        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
        
        System.out.println(solution(user_id1, banned_id1));
        System.out.println(solution(user_id2, banned_id2));
        System.out.println(solution(user_id3, banned_id3));
    }
    
    public static int solution(String[] user_id, String[] banned_id) {
        len = banned_id.length; 
        visited = new boolean[user_id.length]; 
        matched = new ArrayList[len];
        set = new HashSet<>(); 
        for(int i = 0; i < len; i++) {
            matched[i] = new ArrayList<>(); 
        }
        
        for(int i = 0; i < len; i++) {
            banned_id[i] = banned_id[i].replace("*", "[a-z0-9]"); 
        }
        
        for(int i = 0; i < user_id.length; i++) {
            for(int j = 0; j < len; j++) {
                if (Pattern.matches(banned_id[j], user_id[i])) {
                    matched[j].add(i); 
                }
            }
        }
        dfs(0); 
        return set.size(); 
    }
    
    public static void dfs(int level) {
        if (level == len) {
            set.add(Arrays.toString(visited)); 
            
        }
        
        else {
            for(int i : matched[level]) {
                if (! visited[i]) {
                    visited[i] = true; 
                    dfs(level + 1); 
                    visited[i] = false; 
                }
            }
        }
    }
}
