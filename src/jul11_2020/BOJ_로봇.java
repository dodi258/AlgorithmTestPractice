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
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_로봇 {

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static int R, C;

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
//
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        char[][] map = new char[R][C];
//
//        // 장애물 설치 
//        int wallCnt = Integer.parseInt(in.readLine());
//        for (int i = 0; i < wallCnt; i++) {
//            st = new StringTokenizer(in.readLine());
//            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 'X';
//        }
//
//        // 시작 위치
//        st = new StringTokenizer(in.readLine());
//        int sr = Integer.parseInt(st.nextToken());
//        int sc = Integer.parseInt(st.nextToken());
//
//        // 방향 지시
//        String[] directions = in.readLine().split(" ");
//        
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(sr, sc));
//        Point now = new Point(0,0); 
//        int d = 0; 
//        while (!queue.isEmpty()) {
//            now = queue.poll();
//            map[now.r][now.c] = 'O';
//            int nr, nc;
//            int rejectCnt = 0; 
//            while(true) {
//                int nextDir = Integer.parseInt(directions[d % directions.length]); 
//                nr = now.r + dr[nextDir];
//                nc = now.c + dc[nextDir];
//                if (boundaryCheck(nr, nc) && map[nr][nc] == 0) {
//                    queue.add(new Point(nr, nc));
//                    break;
//                }
//                d++; 
//                rejectCnt ++; 
//                if (rejectCnt == 4) break; 
//            }
//        }
////        for(int i = 0; i < R; i++) {
////            System.out.println(Arrays.toString(map[i])); 
////        }
//        System.out.println(now.r + " "+ now.c); 
//
//    }

    public static boolean boundaryCheck(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return false;
        }

        return true;
    }

    public static class Point {

        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
