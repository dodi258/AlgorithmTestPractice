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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        // M: 가로
        int M = Integer.parseInt(st.nextToken());
        // N: 세로
        int N = Integer.parseInt(st.nextToken());
        
        // redTomato: 익은 토마토를 저장하는 Queue 
        Queue<Tomato> redTomato = new LinkedList<>();
        // box: 토마토의 정보를 저장.
        int[][] box = new int[N][M];
        // greenTomato: 안 익은 토마토의 개수를 셈. 
        int greenTomatoCnt = 0; 
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    redTomato.offer(new Tomato(i, j)); 
                }
                else if(box[i][j] == 0) {
                    greenTomatoCnt ++; 
                }
            }
        }

        // 안익은 토마토가 없다면, --> 0 
        if (greenTomatoCnt == 0) {
            System.out.println(0);
            // 프로그램 종료
            System.exit(0);
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        int day = 0;
        while (!redTomato.isEmpty()) {
            Tomato now = redTomato.poll();
            
            // 상하좌우 검사 & 익히기. & Queue에 넣기.
            for (int i = 0; i < 4; i++) {
                int r = now.r + dr[i];
                int c = now.c + dc[i];

                if (r < 0 || r >= N || c < 0 || c >= M) continue;

                if (box[r][c] == 0) {
                    greenTomatoCnt--;
                    redTomato.add(new Tomato(r, c));
                    box[r][c] = box[now.r][now.c] + 1;
                    day = box[r][c];
                }
            }
        }
        
        // 아직도 안익힌 토마토가 있으면 --> -1
        if (greenTomatoCnt != 0) {
            System.out.println(-1);
        } 
        // 모두 익혔다면, 걸린 시간을 출력 --> day - 1
        else {
            System.out.println(day - 1);
        }
    }

    static class Tomato {
        int r, c;

        Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
