/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
public class Programmers_경주로건설 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}; 
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}}; 
        int[][] board2 = {}; 
        System.out.println(solution(board1)); 
    }
    public static int solution(int[][] board) {
        
        
        int[][] paddedBoard = new int[board.length + 2][board.length + 2];
        for(int i = 0; i < board.length; i++) {
            paddedBoard[i][0] = 1; 
            paddedBoard[i][board.length+1] = 1; 
            for(int j = 0; j < board.length; j++) {
                paddedBoard[i+1][j+1] = board[i][j]; 
            }
        }
        paddedBoard[board.length][board.length+1] = 1; 
        paddedBoard[board.length][0] = 1; 
        Arrays.fill(paddedBoard[0], 1); 
        Arrays.fill(paddedBoard[board.length+1], 1); 
//        
//        for(int i = 0; i <= board.length+1; i++) {
//            System.out.println(Arrays.toString(paddedBoard[i])); 
//        }
        // 오른쪽
        int cost = calculateCost(paddedBoard, new Car(1, 1, -1, -1, 0)); 
        
        return cost; 
    }
    
    static int calculateCost(int[][] board, Car start) {
        int costMin = Integer.MAX_VALUE; 

//        visited[start.r][start.c] = true; 
        int[] dr = {-1, 0, 1, 0}; 
        int[] dc = {0, 1, 0, -1}; 
        Queue<Car> queue = new LinkedList<>(); 
        queue.add(start);
        board[start.r][start.c] = 1; 
        
        
        while(!queue.isEmpty()) {
            Car now = queue.poll(); 
            if (now.r == board.length-2 && now.c == board.length-2) {
                costMin = Math.min(costMin, now.cost); 
                continue; 
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + dr[i]; 
                int nc = now.c + dc[i]; 
                if (board[nr][nc] == 1 ) continue; 
                // 코너 아님
                int cost  = 0; 
                if ((now.dr == dr[i] && now.dc == dc[i]) || (now.dr == -1 && now.dc == -1)) {
                    cost = now.cost + 100; 
//                    queue.add(new Car(nr, nc, dr[i], dc[i], now.cost + 100)); 
                }
                // 코너 임
                else {
                    cost = now.cost + 600; 
//                    queue.add(new Car(nr, nc, dr[i], dc[i], now.cost + 600)); 
                }
                
                if (board[nr][nc] == 0) {
                    board[nr][nc] = cost; 
                    queue.add(new Car(nr, nc, dr[i], dc[i], cost)); 
                }
                else if (board[nr][nc] >= cost) {
                    board[nr][nc] = cost; 
                    queue.add(new Car(nr, nc, dr[i], dc[i], cost)); 
                }
            }
        }
        
        return costMin; 
    }
    
    static class Car {
        private int r, c; 
        private int dr, dc;  
        private int cost; 
        
        Car(int r, int c, int dr, int dc, int cost) {
            this.r = r; 
            this.c = c; 
            this.dr = dr; 
            this.dc = dc; 
            this.cost = cost; 
        }
        
    }
}
