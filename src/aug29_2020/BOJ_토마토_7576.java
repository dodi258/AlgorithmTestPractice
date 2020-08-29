/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug29_2020;

/**
 *
 * @author 주세인1
 */
import java.io.*;
import java.util.*;

public class BOJ_토마토_7576 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
//
//        int M = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//        Queue<Tomato> RedTomato = new LinkedList<>();
//
//        int[][] box = new int[N][M];
//        int greenTomatoCnt = 0;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(in.readLine());
//            for (int j = 0; j < M; j++) {
//                box[i][j] = Integer.parseInt(st.nextToken());
//                if (box[i][j] == 1) {
//                    RedTomato.offer(new Tomato(i, j)); 
//                }
//                else if(box[i][j] == 0) {
//                    greenTomatoCnt ++; 
//                }
//            }
//        }
//
//        if (greenTomatoCnt == 0) {
//            System.out.println(0);
//            System.exit(0);
//        }
//
//        int[] dr = {-1, 0, 1, 0};
//        int[] dc = {0, 1, 0, -1};
//
//        int day = 0;
//        while (!RedTomato.isEmpty()) {
//            Tomato now = RedTomato.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int r = now.r + dr[i];
//                int c = now.c + dc[i];
//
//                if (r < 0 || r >= N || c < 0 || c >= M) {
//                    continue;
//                }
//                if (box[r][c] == 0) {
//                    greenTomatoCnt--;
//                    RedTomato.add(new Tomato(r, c));
//                    box[r][c] = box[now.r][now.c] + 1;
//                    day = box[r][c];
//                }
//            }
//        }
//
//        if (greenTomatoCnt == 0) {
//            System.out.println(day - 1);
//        } else {
//            System.out.println(-1);
//        }
//    }

    static class Tomato {
        int r, c;

        Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
