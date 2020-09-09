/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep09_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

public class BOJ_Tree_트리순회_1991번 {
    static Node[] tree; 
    static StringBuilder result; 
    public static void main(String[] args) throws IOException {
        //A: 65
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(in.readLine()); 
        tree = new Node[N]; 

        for(int i = 0; i < N; i++) {
            tree[i] = new Node(); 
        }
        
        for(int i = 0; i < N; i++) {
            String input = in.readLine(); 
            int parent = input.charAt(0) - 65; 
            char left = input.charAt(2); 
            char right = input.charAt(4); 
            if (left != '.')
                tree[parent].left = left - 65; 
            if (right != '.')
                tree[parent].right = right - 65; 
//            char[] nodes =  in.readLine().replace(" ", "").toCharArray();
//            
//            if (nodes[1] != '.')
//                tree[nodes[0]-65].left = nodes[1]-65;
//
//            if (nodes[2] != '.')
//                tree[nodes[0]-65].right = nodes[2]-65; 
        }
        result = new StringBuilder();
        preOrder(0); 
        result.append("\n"); 
        inOrder(0); 
        result.append("\n"); 
        postOrder(0); 
        
        System.out.println(result.toString()); 
    }
    
    static void preOrder(int index) {
        result.append((char) (index + 65));
        if (tree[index].left != -1) 
            preOrder(tree[index].left); 
        if (tree[index].right != -1)
            preOrder(tree[index].right); 
    }
    
    static void inOrder(int index) {
        if (tree[index].left != -1)
            inOrder(tree[index].left);
        result.append((char) (index + 65));
        if (tree[index].right != -1)
            inOrder(tree[index].right); 

    }
    static void postOrder(int index) {
        if (tree[index].left != -1)
            postOrder(tree[index].left);
        if (tree[index].right != -1)
            postOrder(tree[index].right); 
        result.append((char) (index + 65));
    }
    
    
    static class Node {
        int left;
        int right; 
        Node() {
            this.left = -1; 
            this.right = -1; 
        }
        Node(int left, int right) {
            this.left = left; 
            this.right = right; 
        }
    }
    
}
