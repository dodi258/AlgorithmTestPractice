/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug09_2020;

/**
 *
 * @author dodi258
 */
import java.util.HashMap; 
public class Programmers_방문길이 {
    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU"; 
        String dirs2 = "LULLLLLLU";
        
        System.out.println(solution(dirs1)); 
        System.out.println(solution(dirs2)); 
        
    }
    
    public static int solution(String dirs) {
        int answer = 0;
        HashMap<Character, int[]> dirMap = new HashMap<>(); 
        dirMap.put('U', new int[]{0, 1});
        dirMap.put('D', new int[]{0, -1}); 
        dirMap.put('R', new int[]{1, 0}); 
        dirMap.put('L', new int[]{-1, 0}); 
        
        boolean[][] visited_col = new boolean[11][10];
        boolean[][] visited_row = new boolean[10][11]; 
 
        
        int r = 5; 
        int c = 5; 
        int nr = 0; 
        int nc = 0;
        int path = 0; 

        for(int i = 0; i < dirs.length(); i++) {
            int[] move = dirMap.get(dirs.charAt(i));
            nc = c + move[0]; 
            nr = r + move[1]; 
            if (nr < 0 || nr > 10 || nc < 0 || nc > 10) continue; 
            
            // col 가 움직 였다면! --> R, L
            if (nr == r) {
                path = c < nc ? c : nc;
                if (! visited_col[nr][path]) {
                    answer ++; 
                    visited_col[nr][path] = true; 
                }
            }
            // row 가 움직 였다면! --> U, D
            else {
                path = r < nr ? r : nr;
                if (! visited_row[path][nc]) {
                    answer ++; 
                    visited_row[path][nc] = true; 
                }
            }
            
            r = nr;
            c = nc; 
        }
        
        return answer; 
    }
}
