/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep19_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_블록이동하기 {

//    public static void main(String[] args) {
//
//        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
//        System.out.println(solution(board));
//    }

    public static int solution(int[][] board) {
        
        int N = board.length;
        boolean[][] vertical = new boolean[N + 2][N + 2];
        boolean[][] horizontal = new boolean[N + 2][N + 2];

        // out of range 에러를 막기 위해 패딩을 만들어줌. 
        int[][] paddedBoard = new int[N + 2][N + 2];
        for (int i = 0; i < N; i++) {
            paddedBoard[i][0] = 1;
            paddedBoard[i][N + 1] = 1;
            for (int j = 0; j < N; j++) {
                paddedBoard[i + 1][j + 1] = board[i][j];
            }
        }
        paddedBoard[N][0] = 1;
        paddedBoard[N][N + 1] = 1;
        Arrays.fill(paddedBoard[0], 1);
        Arrays.fill(paddedBoard[N + 1], 1);
        
        // BFS를 위한 queue 
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(1, 1, 1, 2, 1, 0));
        while (!queue.isEmpty()) {
            Robot now = queue.poll();
            
            // 도착지에 도달하면 답을 return 
            if ((now.r2 == N && now.c2 == N) || (now.r1 == N && now.c1 == N)) {
                return now.cnt;
            }

            // 로봇 방향 ==> 가로 
            if (now.type == 1) {
                if (horizontal[now.r1][now.c1]) {
                    continue;
                }
                horizontal[now.r1][now.c1] = true;

                if (paddedBoard[now.r1 - 1][now.c1] == 0 && paddedBoard[now.r2 - 1][now.c2] == 0) {
                    // 평행이동 - 위 
                    if (!horizontal[now.r1 - 1][now.c1]) {
//                            System.out.println("위로 평행이동: " + (now.r1 - 1) + " " + now.c1);
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2 - 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 왼쪽
                    if (!vertical[now.r1 - 1][now.c1]) {
//                            System.out.println("왼쪽 위로 회전: " + (now.r1 - 1) + " " + now.c1);
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 오른쪽
                    if (!vertical[now.r1 - 1][now.c1 + 1]) {
//                            System.out.println("오른쪽 위로 회전: " + (now.r1 - 1) + " " + (now.c1 - 1));
                        queue.add(new Robot(now.r1 - 1, now.c1 + 1, now.r2, now.c2, 2, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1 + 1][now.c1] == 0 && paddedBoard[now.r2 + 1][now.c2] == 0) {
                    // 평행이동 - 아래 
                    if (!horizontal[now.r1 + 1][now.c1]) {
//                            System.out.println("아래로 평행이동: " + (now.r1 + 1) + " " + (now.c1));
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2 + 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 왼쪽
                    if (!vertical[now.r1][now.c1]) {
//                            System.out.println("왼쪽 아래로 회전: " + (now.r1) + " " + (now.c1));
                        queue.add(new Robot(now.r1, now.c1, now.r2 + 1, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 오른쪽
                    if (!vertical[now.r2][now.c2]) {
//                            System.out.println("오른쪽 아래로 회전: " + (now.r1) + " " + (now.c1 + 1));
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2 + 1, now.c2, 2, now.cnt + 1));
                    }
                }

                // 평행이동 - 오른쪽
                if (paddedBoard[now.r1][now.c1 + 1] == 0 && paddedBoard[now.r2][now.c2 + 1] == 0) {
                    if (!horizontal[now.r1][now.c1 + 1]) {
//                            System.out.println("오른쪽으로 평행이동: " + now.r1 + " " + (now.c1 + 1));
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2, now.c2 + 1, 1, now.cnt + 1));
                    }
                }

                // 평행이동 - 왼쪽
                if (paddedBoard[now.r1][now.c1 - 1] == 0 && paddedBoard[now.r2][now.c2 - 1] == 0) {
                    if (!horizontal[now.r1][now.c1 - 1]) {
//                            System.out.println("왼쪽으로 평행이동: " + now.r1 + " " + (now.c1 - 1));
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2, now.c2 - 1, 1, now.cnt + 1));
                    }
                }

            } else {
                // type == 2; 
                if (vertical[now.r1][now.c1]) {
                    continue;
                }
                vertical[now.r1][now.c1] = true;

                // 평행이동 - 위쪽 
                if (paddedBoard[now.r1 - 1][now.c1] == 0 && paddedBoard[now.r2 - 1][now.c2] == 0) {
                    if (!vertical[now.r1 - 1][now.c1]) {
//                            System.out.println("위쪽으로 평행이동 들어감: " + (now.r1 - 1) + " " + now.c1);
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2 - 1, now.c2, 2, now.cnt + 1));
                    }
                }
                // 평행이동 - 아래쪽
                if (paddedBoard[now.r1 + 1][now.c1] == 0 && paddedBoard[now.r2 + 1][now.c2] == 0) {
                    if (!vertical[now.r1 + 1][now.c1]) {
//                            System.out.println("아래로 평행이동 들어감: " + (now.r1 + 1) + "  " + now.c1);
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2 + 1, now.c2, 2, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1][now.c1 + 1] == 0 && paddedBoard[now.r2][now.c2 + 1] == 0) {
                    // 평행이동 - 오른쪽 
                    if (!vertical[now.r1][now.c1 + 1]) {
//                            System.out.println("오른쪽 평행이동 들어감: " + now.r1 + " " + (now.c1 + 1));
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2, now.c2 + 1, 2, now.cnt + 1));
                    }
                    // 회전 - 오른쪽위
                    if (!horizontal[now.r1][now.c1]) {
//                            System.out.println(" 오른쪽 위 회전 들어감: " + (now.r1) + " " + (now.c1));
                        queue.add(new Robot(now.r1, now.c1, now.r2 - 1, now.c2 + 1, 1, now.cnt + 1));
                    }
                    // 회전 - 오른쪽 아래
                    if (!horizontal[now.r1 + 1][now.c1]) {
//                            System.out.println(" 오른쪽 아래 회전 들어감:" + (now.r1 + 1) + " " + now.c1);
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2, now.c2 + 1, 1, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1][now.c1 - 1] == 0 && paddedBoard[now.r2][now.c2 - 1] == 0) {
                    // 평행이동 - 왼쪽
                    if (!vertical[now.r1][now.c1 - 1]) {
//                            System.out.println("왼쪽 평행이동 들어감. : " + now.r1 + " " + (now.c1 - 1));
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 - 왼쪽 위
                    if (!horizontal[now.r1][now.c1 - 1]) {
//                            System.out.println("왼쪽 위 회전 들어감: " + now.r1 + " " + (now.c1 - 1));
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2 - 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 - 왼쪽 아래
                    if (!horizontal[now.r1 + 1][now.c1 - 1]) {
//                            System.out.println("왼쪽 아래 회전 들어감: " + (now.r1 + 1) + " " + (now.c1 - 1));
                        queue.add(new Robot(now.r1 + 1, now.c1 - 1, now.r2, now.c2, 1, now.cnt + 1));
                    }

                }

            }
        }

        return 0;
    }

    public static class Robot {

        int type;
        int r1, c1;
        int r2, c2;
        int cnt;

        Robot(int r1, int c1, int r2, int c2, int type, int cnt) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.type = type;
            this.cnt = cnt;
        }
    }
}
