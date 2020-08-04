/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul09_2020;

/**
 *
 * @author 주세인1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_미로탈출 {

    static int[][] map;
    static boolean[][][] visited;
    static int N, M;
    static int Ex, Ey = 0;
    static boolean flag = false;
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};
    static int ans = Integer.MAX_VALUE;

//    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
////		long start = System.currentTimeMillis();
//        StringTokenizer st = new StringTokenizer(in.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(in.readLine());
//        int Hx = Integer.parseInt(st.nextToken());
//        int Hy = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(in.readLine());
//        Ex = Integer.parseInt(st.nextToken());
//        Ey = Integer.parseInt(st.nextToken());
//
//        map = new int[N + 1][M + 1];
//        visited = new boolean[2][N + 1][M + 1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(in.readLine());
//            for (int j = 1; j <= M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        visited[0][Hx][Hy] = true;
//        bfs(Hx, Hy, 0);
//        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
////		for(int i = 0 ; i < N; i++) {
////			System.out.println(Arrays.toString(visited[i]));
////		}
////		System.out.println("end-start" + (System.currentTimeMillis() - start));
//    }

    private static void bfs(int r, int c, int t) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, t, 0));
        int nr, nc;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int cnt = p.cnt;
            // 탈출구에 도착하면
            if (p.r == Ex && p.c == Ey) {
                if (ans > cnt) {
                    ans = cnt;
                }
                continue;
            }
            if (ans <= cnt) {
                continue;
            }
            //동서남북 탐방
            for (int i = 0; i < 4; i++) {

                nr = p.r + dr[i];
                nc = p.c + dc[i];

                if (!boundaryCheck(nr, nc)) {
                    continue;
                }

                // 벽을 안뚫었고, 벽이면 
                if (p.brokeWall == 0 && map[nr][nc] == 1) {
                    queue.offer(new Point(nr, nc, cnt + 1, 1));
                    continue;
                }
                
                // 벽을 뚫었다면 1, 벽을 안뚫었다면 0 & 벽이 뚫려있음. 
                if (!visited[p.brokeWall][nr][nc] && map[nr][nc] == 0) {
                    visited[p.brokeWall][nr][nc] = true;
                    queue.offer(new Point(nr, nc, cnt + 1, p.brokeWall));
                }
            }
        }
    }

    public static boolean boundaryCheck(int r, int c) {
        if (r < 1 || r > N || c < 1 || c > M) {
            return false;
        }
        return true;
    }

    static class Point {

        int r, c, cnt;
        int brokeWall;

        Point(int r, int c, int cnt, int brokeWall) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.brokeWall = brokeWall;
        }
    }

}
