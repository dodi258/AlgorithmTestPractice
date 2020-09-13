/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep13_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author 주세인1
 */
public class BOJ_Tree_이진검색트리_5639번_복습 {
    static ArrayList<Integer> values; 
    static Node[] tree; 
    static StringBuilder postOrderString; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        values = new ArrayList<>();

        while ((s = in.readLine()) != null & s.length() != 0) {
            values.add(Integer.parseInt(s));
        }

        int N = values.size();
        tree = new Node[N]; 
        for(int i = 0; i < N; i++) {
            tree[i] = new Node(i, values.get(i)); 
        }
        
        
        setTree(0, N);
        postOrderString = new StringBuilder(); 
        findPostOrder(0); 
        System.out.println(postOrderString.toString()); 
    }

    public static void setTree(int start, int end) {
        if (start > end) {
            return;
        }
        int now_value = values.get(start); 
        int right = 0; 
        
        // right 찾기 
        for(int i = start; i < end; i++) {
            if (now_value < values.get(i)) {
                right = i; 
                tree[start].right = right;  
                setTree(right, end); 
                break; 
            }
        }
        if (right == 0) {
            right = end; 
        }
        // left 찾기 
        if (start + 1 < right) {
            if (tree[start].value > values.get(start + 1)) {
                tree[start].left = start + 1; 
                setTree(start + 1, right); 
            }
        }
    }
    
    static void findPostOrder(int root) {
        Node node = tree[root]; 
        if (node.left != -1) {
            findPostOrder(node.left); 
        }
        if(node.right != -1) {
            findPostOrder(node.right); 
        }
        postOrderString.append(node.value + "\n"); 
    }
    
    static class Node {
        int index; 
        int left; 
        int right; 
        int value; 
        Node(int index, int value) {
            this.index = index; 
            this.value = value; 
            this.left = -1; 
            this.right = -1; 
        }
//        
//        void setLeft(int index) {
//            this.left = index; 
//        }
//        
//        void setRight(int index) {
//            this.left = index; 
//        }
    }
}
