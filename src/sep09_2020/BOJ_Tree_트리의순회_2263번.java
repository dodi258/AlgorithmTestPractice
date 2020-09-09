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
import java.io.*; 
import java.util.*; 
 
public class BOJ_Tree_트리의순회_2263번 {
    static int N;
    
    static int[] inOrder;
    static int[] Indexes; // 중위 순회에 루트들의 인덱스 정보를 입력한다.
    static int[] postOrder;
    
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        
        inOrder = new int[N+1];
        Indexes = new int[N+1];
        postOrder = new int[N+1];
        
        sb = new StringBuilder();
        // inorder 
        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++) 
            inOrder[i] = Integer.parseInt(st.nextToken());
        
        // postorder
        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++) 
            postOrder[i] = Integer.parseInt(st.nextToken());
        
        // 중위순회에 노드들이 루트일경우 인덱스 정보를 저장
        for(int i=1; i <= N; i++) 
            Indexes[inOrder[i]] = i;
        
        getPreOrder(1, N, 1, N);
        System.out.println(sb.toString());
    }
    
    public static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        // 중위, 후위 순회의 시작점은 종료점 보다 크면 안된다.
        if(inStart > inEnd || postStart > postEnd) 
            return;
        
        // 루트를 구한다. 후위 순회의 마지막 인덱스 poO_end가 루트의 인덱스이다. 
        int root = postOrder[postEnd];
        sb.append(root + " ");
        
        // 중위 순회에서 루트의 인덱스를 알아온다.
        int rootIndex = Indexes[root];
        // 중위 순회에서 루트 기준 왼쪽에 몇개가 있는지 계산한다.
        int left = rootIndex - inStart;
        
        //좌측 자식 노드들을 구한다. 
        getPreOrder(inStart, rootIndex-1, postStart, postStart+ left-1);
        
        // 우측 자식 노드들을 구한다. 
        getPreOrder(rootIndex+1, inEnd, postStart + left, postEnd - 1);
    }
}

