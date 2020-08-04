///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package june23_2020;
//
///**
// *
// * @author 주세인1
// */
//import java.util.Arrays;
//import java.util.HashSet; 
//import java.util.Comparator;
//
//
//public class Programmers_튜플 {
//    
//    public static class SizeComparator implements Comparator<String> {
//    @Override
//    public int compare(String s1, String s2) {
//        return s1.length() - s2.length(); 
//    }
//}
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
//    }
//    
//    
//    public static int[] solution(String s) {
//        String regExp = "(\\},\\{)"; 
//        String[] strArr = s.substring(2, s.length()-2).split(regExp); 
//        Arrays.sort(strArr, new SizeComparator()); 
// 
//        HashSet<Integer> numberSet = new HashSet<>();
//        int[] tuple = new int[strArr.length];
//        int idx = 0; 
//        for(int i = 0; i < strArr.length; i++) {
//            String[] arr = strArr[i].split(","); 
//            
//            for(int j = 0; j < arr.length; j++) {
//                int num = Integer.valueOf(arr[j]); 
//                
//                if (!  numberSet.contains(num)) {
//                    tuple[idx ++] = num; 
//                    numberSet.add(num); 
//                    break; 
//                }
//            }
//        }
//        
//        return tuple; 
////        int[] answer = tuple.stream().mapToInt(i->i).toArray(); 
////        return answer; 
//    }
//}
