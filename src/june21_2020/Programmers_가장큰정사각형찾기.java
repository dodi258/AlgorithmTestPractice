package june21_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
//import java.awt.Point; 
import java.util.Arrays;
public class Programmers_가장큰정사각형찾기 {

//    public static void main(String[] args) {
//        int[][] board = {{1, 1, 0, 1, 1, 1}, 
//                         {1, 0, 0, 1, 1, 1}, 
//                         {0, 0, 1, 1, 1, 0},
//                         {1, 1, 1, 0, 0, 1}, 
//                         {1, 1, 0, 0, 0, 1}, 
//                         {1, 1, 0, 1, 1, 1}}; 
//        System.out.println(solution(board)); 
//    }
    
    
    public static int solution(int[][] board) {
        int H = board.length;      //세로 (행)
        int W = board[0].length;   //가로 (열)
        int max = 0; 
        
        // 양 끝 라인에 1이 있다면 max 를 1로 변경!
        for(int i = 0; i < H; i++) {
            if (board[i][0] == 1) 
            { 
                max = 1; 
                break; 
            }
        }
        if (max == 0) {
            for(int j = 0; j < W; j++) {
                if (board[0][j] == 1) {
                    max = 1; 
                    break; 
                }
            }
        }
        
        // 인덱스 1 부터 시작
        for(int i = 1; i < H; i++) {
            for(int j = 1; j < W; j++) {
                //board[i][j] = 0 일 때 자신을 곱하면 사라짐
                board[i][j] *= Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1; 
 
                if (board[i][j] > max)
                    max = board[i][j]; 
            }
         }
        return max * max; 
    }
    
}
