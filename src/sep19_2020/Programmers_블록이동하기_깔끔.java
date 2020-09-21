import java.util.*;

public class Programmers_블록이동하기_깔끔 {
    
    public int solution(int[][] board) {

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
        paddedBoard[N][0] = 1; paddedBoard[N][N + 1] = 1;
        Arrays.fill(paddedBoard[0], 1); Arrays.fill(paddedBoard[N + 1], 1);
        // ---------------------------

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
                    // 평행이동 - 위쪽
                    if (!horizontal[now.r1 - 1][now.c1]) {
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2 - 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 - 왼쪽 위
                    if (!vertical[now.r1 - 1][now.c1]) {
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 - 오른쪽 위
                    if (!vertical[now.r1 - 1][now.c1 + 1]) {
                        queue.add(new Robot(now.r1 - 1, now.c1 + 1, now.r2, now.c2, 2, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1 + 1][now.c1] == 0 && paddedBoard[now.r2 + 1][now.c2] == 0) {
                    // 평행이동 - 아래 
                    if (!horizontal[now.r1 + 1][now.c1]) {
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2 + 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 - 왼쪽 아래
                    if (!vertical[now.r1][now.c1]) {
                        queue.add(new Robot(now.r1, now.c1, now.r2 + 1, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 - 오른쪽 아래
                    if (!vertical[now.r2][now.c2]) {
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2 + 1, now.c2, 2, now.cnt + 1));
                    }
                }

                // 평행이동 - 오른쪽
                if (paddedBoard[now.r1][now.c1 + 1] == 0 && paddedBoard[now.r2][now.c2 + 1] == 0) {
                    if (!horizontal[now.r1][now.c1 + 1]) {
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2, now.c2 + 1, 1, now.cnt + 1));
                    }
                }

                // 평행이동 - 왼쪽
                if (paddedBoard[now.r1][now.c1 - 1] == 0 && paddedBoard[now.r2][now.c2 - 1] == 0) {
                    if (!horizontal[now.r1][now.c1 - 1]) {
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2, now.c2 - 1, 1, now.cnt + 1));
                    }
                }

            } // 로봇 방향 ==> 세로
            else {
                // type == 2; 
                if (vertical[now.r1][now.c1]) {
                    continue;
                }
                vertical[now.r1][now.c1] = true;

                // 평행이동 - 위쪽 
                if (paddedBoard[now.r1 - 1][now.c1] == 0 && paddedBoard[now.r2 - 1][now.c2] == 0) {
                    if (!vertical[now.r1 - 1][now.c1]) {
                        queue.add(new Robot(now.r1 - 1, now.c1, now.r2 - 1, now.c2, 2, now.cnt + 1));
                    }
                }
                // 평행이동 - 아래쪽
                if (paddedBoard[now.r1 + 1][now.c1] == 0 && paddedBoard[now.r2 + 1][now.c2] == 0) {
                    if (!vertical[now.r1 + 1][now.c1]) {
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2 + 1, now.c2, 2, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1][now.c1 + 1] == 0 && paddedBoard[now.r2][now.c2 + 1] == 0) {
                    // 평행이동 - 오른쪽 
                    if (!vertical[now.r1][now.c1 + 1]) {
                        queue.add(new Robot(now.r1, now.c1 + 1, now.r2, now.c2 + 1, 2, now.cnt + 1));
                    }
                    // 회전 - 오른쪽 위
                    if (!horizontal[now.r1][now.c1]) {
                        queue.add(new Robot(now.r1, now.c1, now.r2 - 1, now.c2 + 1, 1, now.cnt + 1));
                    }
                    // 회전 - 오른쪽 아래
                    if (!horizontal[now.r1 + 1][now.c1]) {
                        queue.add(new Robot(now.r1 + 1, now.c1, now.r2, now.c2 + 1, 1, now.cnt + 1));
                    }
                }

                if (paddedBoard[now.r1][now.c1 - 1] == 0 && paddedBoard[now.r2][now.c2 - 1] == 0) {
                    // 평행이동 - 왼쪽
                    if (!vertical[now.r1][now.c1 - 1]) {
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2, now.c2 - 1, 2, now.cnt + 1));
                    }
                    // 회전 - 왼쪽 위
                    if (!horizontal[now.r1][now.c1 - 1]) {
                        queue.add(new Robot(now.r1, now.c1 - 1, now.r2 - 1, now.c2, 1, now.cnt + 1));
                    }

                    // 회전 - 왼쪽 아래
                    if (!horizontal[now.r1 + 1][now.c1 - 1]) {
                        queue.add(new Robot(now.r1 + 1, now.c1 - 1, now.r2, now.c2, 1, now.cnt + 1));
                    }

                }

            }
        }

        return 0;
    }

    public class Robot {

        int type; // 로봇의 방향
        int r1, c1; // 로봇 왼쪽 or 위 좌표
        int r2, c2; // 로봇 오른쪽 or 아래 좌표
        int cnt; // 현재까지 간 거리 

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
