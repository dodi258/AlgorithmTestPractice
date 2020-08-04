/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul13_2020;

/**
 *
 * @author 주세인1
 */

import java.util.ArrayList; 

public class Programmers_프렌즈4블록_내것으로만들기 {
    
    static char[][] map;
   
//    public static void main(String[] args) {
//        int m = 4; 
//        int n = 5; 
//        
//        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"}; 
//        System.out.println(solution(m, n, board)); 
//    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0; 
        map = new char[m][n];

        int height = m;
        int width = n; 
        
        boolean[][] selected;
        ArrayList<Character>[] verticalLine;
        
        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray(); 
        }
        
        while(true) {
            boolean changed = false; 
            selected = new boolean[height][width]; 
            verticalLine = new ArrayList[width]; 
            
            for(int i = 0; i < height-1; i++) {
                for(int j = 0; j < width-1; j++) {
                    if (isSquare(i, j)) {
                        changed = true; 
                        selected[i][j] = true; 
                        selected[i+1][j] = true; 
                        selected[i][j+1] = true; 
                        selected[i+1][j+1] = true; 
                    }
                }
            }
            
            // 바뀐것이 하나도 없다면 ! 
            if (! changed) break; 
            
            // 초기화 
            for(int j = 0 ; j < width; j++) {
                verticalLine[j] = new ArrayList<Character>(); 
            }
            
            // 프렌즈 4블록으로 골라진것 빼고 세로줄에 넣습니다. 
            for(int j = 0;  j < width; j++) {
                for(int i = height-1; i >= 0; i --) {
                    if (! selected[i][j]) {
                        verticalLine[j].add(map[i][j]); 
                    }
                    else {
                        answer ++; 
                    }
                }
            }
            
            // 세로줄을 다시 맵에 재 배치 해준다. 
            map = new char[height][width]; 
            for(int j = 0; j < width; j++) {
                ArrayList<Character> line = verticalLine[j]; 
                for(int i = 0; i < line.size(); i++) {
                    map[height-1-i][j] = line.get(i); 
                }
            }
            
        }
        
        return answer; 
    }
    
    public static boolean isSquare(int r, int c) {
        int ch = map[r][c]; 
        if (ch == 0) return false; 
        if (map[r][c+1] != ch || map[r+1][c] != ch || map[r+1][c+1] != ch) 
            return false; 
        return true; 
    }
}
