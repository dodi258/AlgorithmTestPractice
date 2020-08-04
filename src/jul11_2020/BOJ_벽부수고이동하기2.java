/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul11_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Queue;
import java.util.StringTokenizer; 
import java.util.LinkedList; 
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException; 

public class BOJ_벽부수고이동하기2 {
    static int N, M; 
    static int K; 
    static int[][] map;
    static boolean[][][] visited; 
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1}; 
    static int ans = Integer.MAX_VALUE; 
    
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
//        StringTokenizer st = new StringTokenizer(in.readLine()); 
//        
//        N = Integer.parseInt(st.nextToken()); 
//        M = Integer.parseInt(st.nextToken()); 
//        K = Integer.parseInt(st.nextToken()); 
//        
//        map = new int[N+1][M+1];
//        visited = new boolean[11][N+1][M+1]; 
//        
//        for(int i = 1; i <= N; i++) {
//            String s = in.readLine(); 
//            for(int j = 1 ;j <= M; j++) {
//                map[i][j] = s.charAt(j-1)- '0'; 
//            }
//        }
//        bfs(1, 1, 1); 
//        
//        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//    }
    
    private static void bfs(int r, int c, int dist) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0, dist));
        int nr, nc;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int distance = p.distance;
            // 탈출구에 도착하면
            if (p.r == N && p.c == M) {
                if (ans > distance) {
                    ans = distance;
                }
                continue;
            }
            if (ans <= distance) {
                continue;
            }
            //동서남북 탐방
            for (int i = 0; i < 4; i++) {

                nr = p.r + dr[i];
                nc = p.c + dc[i];

                if (!boundaryCheck(nr, nc)) {
                    continue;
                }

                // 벽을 K 개 전으로 뚫었고, 벽이면 뚫고 지나가기
                if (p.brokeCnt < K && map[nr][nc] == 1) {
                    queue.offer(new Point(nr, nc, p.brokeCnt + 1, distance + 1));
                    continue;
                }
                
                // 벽을 뚫었다면 brokeCnt, 벽을 안뚫었다면 0 & 벽이 뚫려있음. 
                if (!visited[p.brokeCnt][nr][nc] && map[nr][nc] == 0) {
                    visited[p.brokeCnt][nr][nc] = true;
                    queue.offer(new Point(nr, nc, p.brokeCnt, distance + 1));
                }
            }
        }
    }
    public static boolean boundaryCheck(int r, int c) {
        if (r < 1 || r > N || c < 1 || c > M)
            return false; 
        return true; 
    }
    static class Point{
        int r, c; 
        int brokeCnt; 
        int distance; 
        Point(int r, int c, int brokeCnt, int distance) {
            this.r = r; 
            this.c = c; 
            this.brokeCnt = brokeCnt; 
            this.distance = distance; 
        }
    }
}
