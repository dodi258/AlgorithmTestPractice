/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep05_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
/*
미완
*/
public class Programmers_블록이동하기 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        int[][] board1 = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
        System.out.println(solution(board1));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int[][] paddedBoard = new int[N + 2][N + 2];
        boolean[][] ver = new boolean[N + 2][N + 2];
        boolean[][] hor = new boolean[N + 2][N + 2];
        
        for (int i = 0; i < N; i++) {
            paddedBoard[i][N + 1] = 1;
            paddedBoard[i][0] = 1;
            for (int j = 0; j < N; j++) {
                paddedBoard[i + 1][j + 1] = board[i][j];
            }
        }
        paddedBoard[N][0] = 1;
        paddedBoard[N][N + 1] = 1;
        Arrays.fill(paddedBoard[N + 1], 1);
        Arrays.fill(paddedBoard[0], 1);

        for (int i = 0; i <= N + 1; i++) {
            System.out.println(Arrays.toString(paddedBoard[i]));
        }

        Queue<Robot> queue = new LinkedList<Robot>();
        queue.add(new Robot(1, 1, 1, 2, 0, 1));
        while (!queue.isEmpty()) {
            Robot now = queue.poll();

            if ((now.left_r == N && now.left_c == N) || (now.right_r == N && now.right_c == N)) {
                answer = now.time;
                break;
            }
            int time = now.time + 1; 
            // 가로
            if (now.dir == 1) {
//                if (hor[now.left_r][now.left_c]) continue;
//                hor[now.left_r][now.left_c] = true;

                if (hor[now.left_r][now.left_c] && hor[now.right_r][now.right_c]) continue; 
                hor[now.left_r][now.left_c] = true;
                hor[now.right_r][now.right_c] = true; 
                // 오
                if (paddedBoard[now.right_r][now.right_c + 1] == 0) {
                    queue.add(new Robot(now.right_r, now.right_c, now.right_r, now.right_c + 1, time, now.dir));
                }
                // 왼
                if (paddedBoard[now.right_r][now.right_c - 1] == 0) {
                    queue.add(new Robot(now.right_r, now.right_c, now.right_r, now.right_c - 1, time, now.dir));
                }
                // 위
                if (paddedBoard[now.left_r - 1][now.left_c] == 0 && paddedBoard[now.right_r - 1][now.right_c] == 0) {
                    // 가로 위 평행이동
                    queue.add(new Robot(now.left_r - 1, now.left_c, now.right_r - 1, now.right_c, time, now.dir));
                    // 왼쪽 축 90도
                    queue.add(new Robot( now.left_r - 1, now.left_c, now.left_r, now.left_c, time, 2));
                    // 오른쪽 축 90도
                    queue.add(new Robot(now.right_r -1 , now.right_c, now.right_r, now.right_c, time, 2));
                }

                // 아래
                if (paddedBoard[now.left_r + 1][now.left_c] == 0 && paddedBoard[now.right_r + 1][now.right_c] == 0) {
                    // 가로 아래 평행이동
                    queue.add(new Robot(now.left_r + 1, now.left_c, now.right_r + 1, now.right_c, time, now.dir));
                    // 왼쪽 축 90도
                    queue.add(new Robot(now.left_r, now.left_c, now.left_r + 1, now.left_c, time, 2));
                    // 오른쪽 축 90도
                    queue.add(new Robot(now.right_r, now.right_c, now.right_r + 1, now.right_c, time, 2));
                }

                

            } // 세로 
            else {


                if (ver[now.left_r][now.left_c] && ver[now.right_r][now.right_c]) {
                    continue;
                }
                ver[now.left_r][now.left_c] = true;
                ver[now.right_r][now.right_c] = true;

                // 오
                if (paddedBoard[now.left_r][now.left_c + 1] == 0 && paddedBoard[now.right_r][now.right_c + 1] == 0) {
                    queue.add(new Robot(now.left_r, now.left_c + 1, now.right_r, now.right_c + 1, time, now.dir)); 
                    // 왼쪽 축 90도
                    queue.add(new Robot(now.left_r, now.left_c, now.left_r, now.left_c + 1, time, 1)); 
                    // 오른쪽 축 90도
                    queue.add(new Robot(now.right_r, now.right_c, now.right_r, now.right_c+1, time, 1)); 
                    
                }
                // 왼
                if (paddedBoard[now.left_r][now.left_c - 1] == 0 && paddedBoard[now.right_r][now.right_c -1] == 0) {
                    queue.add(new Robot(now.left_r, now.left_c - 1, now.right_r, now.right_c -1, time, now.dir)); 
                    // 왼쪽 축 90도
                    queue.add(new Robot(now.left_r, now.left_c -1, now.left_r, now.left_c, time, 1)); 
                    // 오른쪽 축 90도
                    queue.add(new Robot(now.right_r, now.right_c -1, now.right_r, now.right_c, time, 1)); 
                }
                // 위
                if (paddedBoard[now.left_r-1][now.left_c] == 0) {
                    queue.add(new Robot(now.left_r - 1, now.left_c , now.left_r, now.left_c, time, now.dir)); 
                }
                // 아래
                if (paddedBoard[now.right_r + 1][now.right_c] == 0) {
                    queue.add(new Robot(now.right_r, now.right_c, now.right_r + 1, now.right_c, time, now.dir)); 
                }
//                
//                // 아래 평행이동 
//                if (paddedBoard[now.right_r + 1][now.right_c] == 0) {
//                    queue.add(new Robot(now.right_r, now.right_c, now.right_r + 1, now.right_c, time, now.dir));
//                }
//
//                if (paddedBoard[now.left_r][now.left_c + 1] == 1 || paddedBoard[now.right_r][now.right_c + 1] == 1) {
//                    continue;
//                }
//                // 오른쪽 평행이동
//                queue.add(new Robot(now.left_r, now.left_c + 1, now.right_r, now.right_c + 1, time, now.dir));
//                // 왼쪽 축 90도
//                queue.add(new Robot(now.left_r, now.left_c, now.left_r, now.left_c + 1, time, 1));
//                // 오른쪽 축 90도
//                queue.add(new Robot(now.right_r, now.right_c, now.right_r, now.right_c + 1, time, 1));

            }
        }
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(ver[i]));
        }
        System.out.println("     ");
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(hor[i]));
        }
        return answer;
    }

    public static class Robot {

        int left_r;
        int left_c;
        int right_r;
        int right_c;
        int time;
        int dir;

        Robot(int left_r, int left_c, int right_r, int right_c, int time, int dir) {
            this.left_r = left_r;
            this.left_c = left_c;
            this.right_r = right_r;
            this.right_c = right_c;
            this.time = time;
            this.dir = dir;
        }

    }
}
