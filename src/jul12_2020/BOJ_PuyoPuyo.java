/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul12_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Queue;
import java.util.LinkedList; 
import java.util.ArrayList; 
import java.io.IOException;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class BOJ_PuyoPuyo {
    static char[][] map; 
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1}; 
    
    public void solution(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        map = new char[12][6]; 
        for(int i = 0; i < 12; i++) {
            map[i] = in.readLine().toCharArray(); 
        }
        
//        for(int i = 0; i < 12; i++) {
//            System.out.println(Arrays.toString(map[i])); 
//        }
        
        ArrayList<Character>[] vertical = new ArrayList[6]; 
        int answer = 0; 
        
        while(true) {
            int cnt = 0; 
            for(int i = 10; i >= 0; i--) {
                for(int j = 0; j < 6; j++) {
                    cnt += removeBlocks(i, j); 
                }
            }
            
            if (cnt == 0)
                break; 
            
            answer ++; 
            
            for (int i = 0; i < 6; i++) {
                vertical[i] = new ArrayList<Character>();
            }
            
            //블록 땡기기
            for(int j = 0; j < 6; j++) {
                for(int i = 11; i >= 0; i--) {
                    if (Character.isAlphabetic(map[i][j])) {
                        vertical[j].add(map[i][j]); 
                    }
                }
            }
            
            map = new char[12][6]; 
            for(int j = 0; j < 6; j++) {
                for(int i = 11; i >=0; i--) {
                    if (vertical[j].size() <= 11 - i)
                        break; 
                    map[i][j] = vertical[j].get(11-i); 
                }
            }
            
//            System.out.println("*************  "+ answer); 
//            for(int i = 0; i < 12; i++) {
//                System.out.println(Arrays.toString(map[i])); 
//            }
            
        }
        
        System.out.println(answer); 
    }
    
    public static int removeBlocks(int r, int c) {
        if (!Character.isAlphabetic(map[r][c])) return 0; 
        
        boolean[][] visited = new boolean[12][6]; 
        Queue<Point> queue = new LinkedList<>(); 
        queue.add(new Point(r, c)); 
        ArrayList<Point> blocks = new ArrayList<>(); 
        char alphabet = map[r][c]; 
        visited[r][c] = true; 
        while(!queue.isEmpty()) {
            Point p = queue.poll(); 
            blocks.add(p);
            
            for(int i = 0; i < 4; i++) {
                int nr = p.r + dr[i]; 
                int nc = p.c + dc[i]; 
                if (!boundaryCheck(nr, nc) || visited[nr][nc]) continue; 
                if (map[nr][nc] == alphabet) {
                    visited[nr][nc] = true; 
                    queue.add(new Point(nr, nc)); 
                }
            }
        }
        
        if (blocks.size() >= 4){
            for(int i = 0; i < blocks.size(); i++) {
                Point block = blocks.get(i); 
                map[block.r][block.c] = 0; 
            }
            
            return 1; 
        }
        
        else {
            return 0; 
        }
    }
    
    public static boolean boundaryCheck(int r, int c) {
        if (r < 0 || r >= 12 || c < 0 || c >= 6 ) {
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
