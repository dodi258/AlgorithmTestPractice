///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package june29_2020;
//
///**
// *
// * @author 주세인1
// */
//
//import java.util.Queue; 
//import java.util.LinkedList; 
//
//public class Programmers_프렌즈4블록 {
//    class Node {
//        int r, c; 
//        Node(int r, int c) {
//            this.r = r; 
//            this.c = c; 
//        }
//    }
//    
//    static int answer = 0; 
//    
//    public static void main(String[] args) {
//        
//    }
//    
//    public int solution(int m, int n, String[] board) {
//        int answer =0; 
//        
//        return answer; 
//    }
//    
//    public static String[] rotateBlocks(String[] board) {
//        int len = board.length; 
//        String[] newBoard = new String[len];
//        for(int c = 0; c < len; c++) {
//            StringBuilder sb = new StringBuilder(); 
//            for(int r = 0; r < len; r++) {
//                sb.append(board[r].charAt(c)); 
//            }
//            newBoard[len-c-1] = sb.toString(); 
//        }
//        board = newBoard; 
//        
//        
//        return board; 
//    }
//    
//    public static String[] removeBlocks(String[] board) {
//        int len = board.length; 
//        for(int r = 0; r < len; r++) {
//            for(int c = 0; c < len; c++) {
//                char ch = board[r].charAt(c); 
//                if (ch == '0') continue; 
//                Queue<Node> queue = new LinkedList<>(); 
//                
//                while(!queue.isEmpty()) {
//                    
//                    
//                }
//            }
//        }
//        
//        return board; 
//    }
//    public static String[] moveBlocks(String[] board) {
//        int len = board.length; 
//        for(int r = 0; r < len; r++) {
//            String s = board[r]; 
//            StringBuilder sb = new StringBuilder(); 
//            for(int c = 0; c < len; c++) {
//                char ch = s.charAt(c); 
//                if (ch == '0') {
//                    sb.insert(0, '0'); 
//                } 
//                else {
//                    sb.insert(sb.length()-1, ch); 
//                }
//            }
//            board[r] = sb.toString(); 
//        }
//        return board; 
//    }
//}
