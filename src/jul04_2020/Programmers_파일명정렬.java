/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul04_2020;

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
import java.util.PriorityQueue; 

public class Programmers_파일명정렬 {
    static class File implements Comparable<File>{
        String head; 
        String number; 
        String tail; 
        int index; 
        
        File(String head, String number, String tail, int index) {
            this.head = head;  
            this.number = number; 
            this.tail = tail;
            this.index = index; 
        }
        
        @Override
        public int compareTo(File target) {
            String this_head = this.head.toLowerCase(); 
            String target_head = target.head.toLowerCase(); 
            
            // 서로 head 값이 같으면 
            if (this_head.equals(target_head)) {
                int this_num = Integer.parseInt(this.number); 
                int target_num = Integer.parseInt(target.number); 
                
                // number 비교 
                if (this_num < target_num)
                    return -1; 
                // number 값이 같으면, index 비교 
                else if(this_num == target_num) {
                    if (this.index < target.index)
                        return -1; 
                    else
                        return 1; 
                }
                else 
                    return 1; 
            }
            // 서로 알파벳 순으로 무엇이 더 앞에 있는지 비교 
            String[] arr = new String[]{this_head, target_head}; 
            Arrays.sort(arr); 
            if (arr[0].equals(this_head))
                return -1; 
            else
                return 1; 
        }
        
        
    }
    
//    public static void main(String[] args) {
//        String[] files1 = {"img10", "img02020", "i1.png1111", "IMG01.    ", "img 22222.JPG"}; 
//        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}; 
//        System.out.println(Arrays.toString(solution(files1)));
//        System.out.println(Arrays.toString(solution(files2))); 
//    }
//    
    public static String[] solution(String[] files) {
        String[] answer; 
        PriorityQueue<File> pq = new PriorityQueue<>(); 
        
        for(int i = 0; i < files.length; i++) {
            String[] arr = splitName(files[i]);
            pq.add(new File(arr[0], arr[1], arr[2], i)); 
        }
        
        StringBuilder sb = new StringBuilder();
        answer = new String[pq.size()];
        int cnt = 0; 
        while(!pq.isEmpty()) {
            File f = pq.poll(); 
            sb.append(f.head).append(f.number).append(f.tail); 
            answer[cnt++] = sb.toString();
            
            sb = new StringBuilder();
         }
        
        return answer; 
    }
    
    public static String[] splitName(String fileName) {
        String[] arr = new String[3]; 
        StringBuilder sb = new StringBuilder(); 
        int i = 0; 
        
        // head
        for(; i < fileName.length(); i++) {
            char c = fileName.charAt(i); 
            if (Character.isDigit(c)) {
                break; 
            }
            
            else {
                sb.append(c); 
            }
        }
        arr[0] = sb.toString(); 
        System.out.println("head: "+  arr[0]); 
        
        // number
        int cnt = 0; 
        sb = new StringBuilder(); 
        int j = i;
        for(i = j; i < fileName.length(); i++) {
            char c = fileName.charAt(i); 
            if (Character.isDigit(c) && cnt < 5) {
                sb.append(c); 
                cnt++; 
            }
            else {
                break; 
            }
        }
        arr[1] = sb.toString();
        System.out.println("number: "+  arr[1]); 
        
        // tail 
        sb = new StringBuilder(); 
        j = i; 
        for(i = j; i < fileName.length(); i++) {
            sb.append(fileName.charAt(i)); 
        }
        
        arr[2] = sb.toString(); 
        System.out.println("tail: "+  arr[2]); 
        return arr; 
    }
    
}
