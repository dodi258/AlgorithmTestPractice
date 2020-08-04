/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul23_2020;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author 주세인1
 */
import java.util.Comparator; 

public class Programmers_이중우선순위큐 {
    public static void main(String[] args) {
        String[] op1 = {"| 16", "D 1"};
        String[] op2 = {"| 7", "| 5", "| -5", "D -1"}; 
        
        System.out.println(solution(op1)); 
        System.out.println(solution(op2).toString()); 
    }
    
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.value > n2.value) return -1; 
                else return 1; 
            }
        }); 
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.value > n2.value) return 1; 
                else return -1; 
            }
        }); 
        
        for(int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");
            
            if (command[0].equals("|")) {
                maxHeap.add(new Node(i, Integer.parseInt(command[1]))); 
                minHeap.add(new Node(i, Integer.parseInt(command[1]))); 
                
            }
            
            else {
                if (maxHeap.isEmpty()) continue; 
                
                if (Integer.parseInt(command[1]) < 0) {
                    Node min = minHeap.remove(); 
                    maxHeap.remove(min); 
                }
                else {
                    Node max = maxHeap.remove(); 
                    minHeap.remove(max); 
                }
            }
        }
        
        if (!maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll().value; 
            answer[1] = minHeap.poll().value; 
        }
        else 
        {
            answer[0] = 0;
            answer[1] = 0; 
        }
        
        return answer;
    }
    
    public static class Node {
        int index; 
        int value; 
        
        Node(int index, int value) {
            this.index = index; 
            this.value = value; 
        }
    
        @Override
        public boolean equals(Object target) {
            // object 의 타입이 block인지 확인
            if (target == null || getClass() != target.getClass()) return false;
            Node node = (Node) target; 
            return this.index == node.index; 
        }

    }
    
    
}

