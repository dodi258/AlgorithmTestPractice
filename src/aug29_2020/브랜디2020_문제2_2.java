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

public class 브랜디2020_문제2_2 {

    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    public static final int WALL = Integer.MAX_VALUE; 
    
//    public static void main(String[] args) throws IOException {
//        int answer = 0;
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(in.readLine());
//        int[][] map = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(in.readLine());
//            for (int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//
//            }
//        }
//        int time = 1;
//        for (int k = N * 2 - 3; k >= 1; k--) {
//            for (int j = 0; j <= k; j++) {
//                int i = k - j;
//                if (i < N && j < N && map[i][j] == 0) {
//                    map[i][j] = WALL; // 벽 설치 
//                    answer = Math.max(waterMoves(deepCopy(map), N, time), answer);
//                    map[i][j] = 0;
//                }
//            }
//            time++;
//        }
//
//        System.out.println(answer);
//    }

    public static int waterMoves(int[][] map, int N, int time) {
        boolean isOkay = true;
        int waterTime = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        map[0][0] = 1; 
        Outer:
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nextR = 0;
            int nextC = 0;
            for (int i = 0; i < 4; i++) {
                nextR = now.r + dr[i];
                nextC = now.c + dc[i];
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
                    continue;
                }
                // 벽과 만남. 
                if (map[nextR][nextC] == WALL) {
                    if (waterTime -1 <= time) {
                        isOkay = false;
                        break Outer;
                    }
                } // 벽과 안 만났는데 아무도 안간 곳. 
                else if (map[nextR][nextC] == 0) {
                    map[nextR][nextC] = map[now.r][now.c] + 1;
                    if (waterTime < map[nextR][nextC]) {
                        waterTime = map[nextR][nextC];
                    }
                    queue.add(new Node(nextR, nextC));
                }
            }
        }

        if (isOkay) {
            return countSafePlace(map);
        } else {
            return 0;
        }

    }

    public static int countSafePlace(int[][] map) {
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i])); 
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }
        System.out.println(); 
        return answer;
    }

    public static int[][] deepCopy(int[][] map) {
        int[][] copy = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }

    static class Node {

        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
