/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug01_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 

public class Programmers_프렌즈4블록 {
//    public static void main(String[] args) {
//        int m1 = 4; 
//        int n1 = 5; 
//        int m2 = 6;
//        int n2 = 6; 
//        
//        String[] board1 = {"CCBDE","AAADE","AAABF","CCBBF"};
//        String[] board2 = {"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"}; 
////        
////        System.out.println(solution(m1, n1, board1)); 
//        System.out.println(solution(m2, n2, board2)); 
//        
//    }
    
    public static int solution(int m, int n, String[] board) {
        int answer = 0; 
        char[][] playBoard = new char[n][m]; 
        boolean[][] selected = new boolean[n][m]; 
        
        // 가로방향으로 전환! n == 행, m == 열
        for(int i = 0; i < m; i++) {
            char[] chars = board[i].toCharArray(); 
            
            for(int j = 0; j < n; j++) {
                playBoard[j][i] = chars[j]; 
            }
        }
        boolean flag; 
        char character; 
        while(true) {
            flag = false; 
            for(int i = 0; i < n; i++) {
                Arrays.fill(selected[i], false); 
            }
            
            for(int i = 0; i < n-1; i++) {
                for(int j = 0; j < m-1; j++) {
                    character = playBoard[i][j]; 
                    if (character == 0) continue; 
                    if (playBoard[i][j+1] != character || playBoard[i+1][j+1] != character || playBoard[i+1][j] != character) 
                        continue; 
                    flag = true; 
                    selected[i][j] = true; 
                    selected[i][j+1] = true; 
                    selected[i+1][j+1] = true; 
                    selected[i+1][j] = true; 
                }
            }
            
            if (! flag) break; 
            
            //지움 선택된거 
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (selected[i][j]) {
                        playBoard[i][j] = 0; 
                        answer ++; 
                    }
                }
            }
            
            // 옮김
            char[][] temp = playBoard.clone(); 
            playBoard = new char[n][m]; 
            for(int i = 0; i < n; i++) {
                int idx = m-1; 
                for(int j = m-1; j >= 0; j--) {
                    if (temp[i][j] != 0) {
                        playBoard[i][idx--] = temp[i][j]; 
                    }
                }
            }
        }
        
        return answer;
    }
}
