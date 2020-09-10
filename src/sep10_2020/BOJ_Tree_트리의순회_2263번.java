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

import java.util.StringTokenizer; 
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class BOJ_Tree_트리의순회_2263번 {
    static StringBuilder preorder;
    static int[] inorder; 
    static int[] postorder;
    static int[] inorder_index;
    static int N; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = null; 
        
        N = Integer.parseInt(in.readLine()); 
        inorder = new int[N];
        postorder = new int[N];
        inorder_index = new int[N+1];
        
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorder_index[inorder[i]] = i; 
        }
        
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        preorder = new StringBuilder(); 
        findPreorder(0, N-1, 0, N-1); 
        System.out.println(preorder.toString()); 
    }
    
    public static void findPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) return; 

        int root = postorder[postEnd]; 
        int rootIndex = inorder_index[root]; 
        
        preorder.append(root + " "); 
        
        //왼쪽
        if ((rootIndex > 0) && (postStart + (rootIndex - inStart) > 0))
            findPreorder(inStart, rootIndex - 1, postStart, postStart + (rootIndex - inStart)-1);
        //오른쪽 
        if ((rootIndex < N) && (postStart + (rootIndex - inStart) >= 0) && (postEnd > 0))
            findPreorder(rootIndex +1, inEnd, postStart + (rootIndex - inStart), postEnd-1); 
    }
}
