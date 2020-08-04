///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jul08_2020;
//
///**
// *
// * @author 주세인1
// */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ_목장건설하기_시간초과 {
//
//    public static final int TREE = 1;
//    public static final int ROCK = 2;
//    public static final int FIELD = 0;
//    public static int[][] map;
//    public static int M;
//    public static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
//
//        // M: 행, N: 열
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        map = new int[M][N];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(in.readLine());
//            for (int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int size = M < N ? M : N;
//        for (; size >= 1; size--) {
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (isInside(i + size - 1, j + size - 1)) {
//                        if (isAllField(i, i + size - 1, j, j + size - 1)) {
//                            System.out.println(size);
//                            return;
//                        }
//                    } else {
//                        break;
//                    }
//                } 
//            }
//        }
//
//    }
//
//    public static boolean isInside(int r, int c) {
//        if (r >= 0 && r < M && c >= 0 && c < N) {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isAllField(int startRow, int endRow, int startCol, int endCol) {
//        for (int i = startRow; i <= endRow; i++) {
//            for (int j = startCol; j <= endCol; j++) {
//                if (map[i][j] != FIELD) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//}
