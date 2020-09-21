/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep18_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*;

public class Programmers_길찾기게임 {

//    public static void main(String[] args) {
//        int[][] nodeinfo = {{5, 3},{11, 5},{13, 3},{3, 5},{6, 1},{1, 3},{8, 6},{7, 2},{2, 2}};
//        int[][] result = solution(nodeinfo);
//        System.out.println(Arrays.toString(result[0])); 
//        System.out.println(Arrays.toString(result[1])); 
//    }
    static ArrayList<Integer> order;
    static Node[] tree;

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        
        tree = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            tree[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(tree, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.y == n2.y) {
                    return n1.x - n2.x;
                }
                return n2.y - n1.y;
            }
        });
        tree[0].index = 0; 
        
        for (int i = 1; i < nodeinfo.length; i++) {
            tree[i].index = i;
            findPosition(0, tree[i]);
        }
        
        order = new ArrayList<Integer>();
        preOrder(tree[0]); 
        answer[0] = order.stream().mapToInt(i->i).toArray(); 
        
        order = new ArrayList<Integer>();
        postOrder(tree[0]); 
        answer[1] = order.stream().mapToInt(i->i).toArray(); 
        return answer;
    }

    public static void findPosition(int parentIdx, Node now) {
        Node parent = tree[parentIdx];

        if (now.x > parent.x) {
            if (parent.right == null) {
                tree[parentIdx].right = now;
            } else {
                findPosition(parent.right.index, now);
            }
        } else {
            if (parent.left == null) {
                tree[parentIdx].left = now;
            } else {
                findPosition(parent.left.index, now);
            }
        }
    }

    public static void preOrder(Node node) {
        order.add(node.number);
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        order.add(node.number);
    }

    public static class Node {

        int number;
        int x, y;
        int index;
        Node left;
        Node right;

        Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.index = -1;
            this.left = null;
            this.right = null;
        }
    }
}
