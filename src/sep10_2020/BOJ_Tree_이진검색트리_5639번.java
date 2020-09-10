/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep10_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 
import java.io.*; 

public class BOJ_Tree_이진검색트리_5639번 {
    static StringBuilder postorder; 
    static int N; 
    static Node[] tree; 
    static boolean[] selected; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        String s  = ""; 
         
        ArrayList<Integer> values = new ArrayList<>();  
         
        // s= in.readLine() != null; --> 이건 안먹혔음. 
        while((s = in.readLine()) != null && s.length() != 0) {
            values.add(Integer.parseInt(s)); 
        }
        N = values.size(); 
        tree = new Node[N];
        selected = new boolean[N]; 
        postorder = new StringBuilder(); 
        
        for(int i = 0; i < N; i++) {
            tree[i] = new Node(i, values.get(i)); 
        }
        
        getTree(0, N); 
        findPostOrder(0); 
        
        System.out.println(postorder.toString()); 
        
//        for(int i = 0; i < N; i++) {
//            System.out.println(tree[i].toString()); 
//        }
        
        
    }
    
    static void getTree(int rootIndex, int endIndex) { 
        if (rootIndex >= endIndex) return; 
        
        int right = -1; 
        for(int i = rootIndex + 1; i < endIndex; i++) {
            if (tree[rootIndex].value < tree[i].value) {
                right = i; 
                break; 
            }
        }
        tree[rootIndex].right = right;
        if (right < 0) 
            right = endIndex; 
        
        // 왼쪽 자식 채우기
        if (rootIndex +1 < right) {
            if (tree[rootIndex].value > tree[rootIndex + 1].value) {
                tree[rootIndex].left = rootIndex + 1; 
                getTree(rootIndex + 1, right); 
            }
        }
        
        // 오른쪽 자식 채우기 
        getTree(right, endIndex); 
        
    }
    static void findPostOrder(int rootIndex) {
        Node root = tree[rootIndex]; 
        if (root.left != -1)
            findPostOrder(root.left); 
        if (root.right != -1)
            findPostOrder(root.right); 

        postorder.append(root.value + "\n"); 
    }
    
    static class Node {
        int value; 
        int index; 
        int left; 
        int right; 
        Node(int index, int value) {
            this.index = index; 
            this.value = value; 
            this.left = -1;
            this.right = -1; 
        }
        
//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder(); 
//            sb.append("index: " + this.index + " // " + "value: " + this.value + "\n");
//            sb.append("left: " + this.left + "// " + "right: " + this.right + "\n"); 
//            return sb.toString(); 
//        }
    }
}
