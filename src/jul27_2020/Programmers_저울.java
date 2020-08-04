///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jul27_2020;
//
///**
// *
// * @author 주세인1
// */
//import java.util.Arrays; 
//
//public class Programmers_저울 {
//    public static void main(String[] args) {
//        int[] weight = {3, 1, 6, 2, 7, 30, 1};
//        System.out.println(solution(weight)); 
//    }
//    
//    public static int solution(int[] weight) {
//        int answer = 1; 
//        Arrays.sort(weight);
//        if (weight[0] > 1) return 1; 
//        
//        for(int i = 0; i < weight.length; i++) {
//            answer += weight[i]; 
//        }
//        
//        boolean[] summation = new boolean[answer+1]; 
//        int index = 0;
//        summation[0] = true; 
//
//        for(int w: weight) {
////            System.out.println("weight:" + w);
////            System.out.println("index: " + index); 
//            summation[w] = true; 
////            System.out.println(Arrays.toString(summation)); 
//            for(int j = index+1; j < w; j++) {
//                if (! summation[j]) {
//                    answer = j; 
//                    return answer; 
//                }
//            }
//            for(int j = 0; j <= index; j++) {
//                summation[j+w] = true; 
//            }
//            
//            index += w; 
//        }
//        answer = index + 1; 
//        return answer; 
//    }
//}
