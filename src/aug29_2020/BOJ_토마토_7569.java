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
import java.util.*; 
import java.io.*; 

public class BOJ_토마토_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        // M: 가로
        int M = Integer.parseInt(st.nextToken()); 
        // N: 세로
        int N = Integer.parseInt(st.nextToken()); 
        // H: 상자의 높이 
        int H = Integer.parseInt(st.nextToken()); 
        
        int greenTomatoCnt = 0; 
        int[][][] box = new int[H][N][M];
        Queue<Tomato> redTomato = new LinkedList<>(); 
        
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine()); 
                for(int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken()); 
                    if (box[h][i][j] == 0) greenTomatoCnt ++; 
                    else if (box[h][i][j] == 1) {
                        redTomato.offer(new Tomato(h, i, j)); 
                    }
                }
            }
        }
        if (greenTomatoCnt == 0) {
            System.out.println(0);
        }
        else {
            int[] dr = {0, 0, 1, -1};
            int[] dc = {1, -1, 0, 0}; 
            int day = 0; 
            while(! redTomato.isEmpty()) {
                Tomato now = redTomato.poll(); 
                int curTime = box[now.h][now.r][now.c]; 
                int r = 0; 
                int c = 0;
                // 위, 아래 
                if (now.h + 1 < H)
                    if(box[now.h + 1][now.r][now.c] == 0) {
                        box[now.h + 1][now.r][now.c] = curTime + 1; 
                        day = curTime + 1; 
                        redTomato.add(new Tomato(now.h + 1, now.r, now.c)); 
                        greenTomatoCnt --; 
                    }
                if (now.h - 1 >= 0) {
                    if(box[now.h - 1][now.r][now.c] == 0) {
                        box[now.h - 1][now.r][now.c] = curTime + 1; 
                        day = curTime + 1; 
                        redTomato.add(new Tomato(now.h - 1, now.r, now.c)); 
                        greenTomatoCnt --; 

                    }
                }
                // 동서남북
                for(int i = 0; i < 4; i++) {
                    r = now.r + dr[i]; 
                    c = now.c + dc[i]; 
                    if (r < 0 || r >= N || c < 0 || c >= M) continue; 
                    if (box[now.h][r][c] == 0) {
                        box[now.h][r][c] = curTime + 1; 
                        day = curTime + 1; 
                        redTomato.add(new Tomato(now.h, r, c));
                        greenTomatoCnt --;
                    }
                }
            }
            
            if (greenTomatoCnt == 0) {
                System.out.println(day-1); 
            }
            else {
                System.out.println(-1); 
            }
        }
        
    }
    
    static class Tomato {
        int h, r, c; 
        Tomato(int h, int r, int c) {
            this.h = h; 
            this.r = r; 
            this.c = c; 
            
        }
    }
}
