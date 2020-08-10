/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug10_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 주세인1
 */
public class BOJ_backtracking_NQueen {

    static int[] positions;
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N/2 ; i++) {
            positions = new int[N];;
            positions[0] = i; // 첫 row의 column을 i로 지정. 
            placeQueens(1);
        }
        answer *= 2; 
        if (N % 2 != 0) {
            positions[N/2] = N/2; 
            placeQueens(1); 
        }
        System.out.println(answer);

    }

    public static void placeQueens(int row) {
        if (row == N) {
            answer++;
        } 
        
        else {
            // 열을 순회 
            for (int col = 0; col < N; col++) {
                boolean isAvailable = true;
                int pos_r = 0;
                int pos_c = 0;
                for (; pos_r < row; pos_r++) {
                    pos_c = positions[pos_r];
                    // 세로와 가로 검사 
                    if (col == pos_c) {
                        isAvailable = false;
                        break;
                    }
                    // 대각선 검사 - 기울기가 1인지 보는것. 
                    if (Math.abs(row - pos_r) == Math.abs(col - pos_c)) {
                        isAvailable = false;
                        break;
                    }
                }
                // 채택

                if (isAvailable) {
                    positions[row] = col;
                    placeQueens(row + 1);
                }
            }
        }
    }
}
