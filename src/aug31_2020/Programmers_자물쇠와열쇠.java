/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug31_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

public class Programmers_자물쇠와열쇠 {
    private static List<Node> keys; 
    private static int keySize; 
    private static int lockSize; 
    private static int[][] board; 
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0},{1, 0, 0},{0, 1, 1}};
        int[][] lock = {{1, 1, 1},{1, 1, 0},{1, 0, 1}}; 
        
        System.out.println(solution(key, lock)); 
        
    }
    
    public static boolean solution(int[][] key, int[][] lock) {
        
        keySize = key.length; 
        lockSize = lock.length; 
        int length = lock.length + (key.length - 1) * 2; 
        board = new int[length][length];
        keys = new LinkedList<>(); 
        for(int i = 0; i < key.length; i++) {
            for(int j = 0 ;j < key.length; j++) {
                if (key[i][j] == 1)
                    keys.add(new Node(i, j));
            }
        }
        
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                board[i+key.length-1][j+key.length-1] = lock[i][j]; 
            }
        }
        
        // rotate 안했을 때 검사
        if (tryUnlock()) {
            return true; 
        }
        
        // rotate 3번
        int rotateCnt = 0; 
        while(rotateCnt++ < 3) {
            System.out.println(rotateCnt + "번 돌림"); 
            rotateKey(); 
            if (tryUnlock()) {
                return true; 
            }
        }
        return false; 
    }
    
    // 확인 완료
    public static void rotateKey() {
        int length = keys.size(); 
        while(length --> 0) {
            Node node = keys.remove(length); 
            keys.add(new Node(node.c, keySize - node.r)); 
        } 
    }
    // 확인 완료
    public static boolean tryUnlock() {
        for(int i = 0; i <= board.length - keySize; i++) {
            for(int j = 0; j <= board.length - keySize; j++) {
                for(int k = 0; k < keys.size(); k++) {
                    Node node = keys.get(k); 
                    board[node.r + i][node.c + j] += 1; 
                }
                
                for(int a = 0; a < board.length; a ++) {
                    System.out.println(Arrays.toString(board[a])); 
                }
                System.out.println("꺅"); 
                if (canUnlock()) {
                    return true; 
                }
                else {
                    eraseKey(i, j); 
                }
            }    
        }
        return false; 
    }
    // 확인완료
    public static void eraseKey(int r, int c) {
        for(Node node: keys) {
            board[node.r + r][node.c + c] -= 1; 
        }
    }
    // 확인완료 
    public static boolean canUnlock() {
        for(int i = keySize -1; i < keySize -1 + lockSize; i++) {
            for(int j = keySize -1; j < keySize -1 + lockSize; j++) {
                if (board[i][j] != 1)
                    return false; 
            }
        }
        return true; 
    }
    
    private static class Node {
        int r, c; 
        Node(int r, int c) {
            this.r = r; 
            this.c = c; 
        }
    }
    
}
