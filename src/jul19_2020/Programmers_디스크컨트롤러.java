/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul19_2020;

/**
 *
 * @author 주세인1
 */

import java.util.PriorityQueue; 
import java.util.Iterator; 

public class Programmers_디스크컨트롤러 {
//    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//        int[][] jobs2 = {{1, 6},{2, 8},{2, 5},{4, 8}}; 
//        System.out.println(solution(jobs2)); 
//    }
    
    public static int solution(int[][] jobs) {
        int answer = 0; 
        PriorityQueue<Job> heap = new PriorityQueue<>(); 
        
        for(int i = 0; i < jobs.length; i++) {
            heap.add(new Job(i, jobs[i][0], jobs[i][1])); 
        }
        
        Iterator<Job> iter; 
        PriorityQueue<Job> tempHeap; 
        
        while(! heap.isEmpty()) {
            Job now = heap.poll(); 
            answer += now.getTotalTime(); 
            int endTime = now.getEndTime(); 
            tempHeap = new PriorityQueue<>();
            tempHeap.addAll(heap); 
            
            iter = tempHeap.iterator(); 
            
            while(iter.hasNext()) {
                Job job = iter.next(); 
                // 만약 지금 실행되는 디스크의 끝나는 시간 보다
                // 이 디스크의 시작 시간이 더 앞서있다면, 
                // 시작시간을 실행되고있는 디스크가 끝나는 시간으로 옮기기 
                if (job.startTime < endTime) {
                    heap.remove(job); 
                    heap.add(new Job(job.index, job.callTime, job.processTime, endTime));
                }
                else {
                    break; 
                }
            }
            System.out.println(heap.toString()); 
        }
        return answer/jobs.length; 
    }
    
    public static class Job implements Comparable<Job>{
        int callTime; 
        int startTime; 
        int processTime;
        int index; 
        
        Job(int index, int callTime, int processTime) {
            this.index = index; 
            this.callTime = callTime; 
            this.processTime = processTime; 
            this.startTime = callTime;
        }
        
        Job(int index, int callTime, int processTime, int startTime) {
            this.index = index;
            this.callTime = callTime; 
            this.processTime = processTime; 
            this.startTime = startTime;
        }
        
        // 총 실행시간
        int getTotalTime() {
            return this.startTime - this.callTime + this.processTime; 
        }
        
        // 실행이 끝나는 시간 
        int getEndTime() {
            return this.startTime + this.processTime; 
        }
        
         // startTime으로 compareTo
        // priority queue에서 어떤 순서로 정렬할지 정의. 
        @Override
        public int compareTo(Job target) {
            // 시작 시간이 같으면, 실행시간 비교
            if (target.startTime == this.startTime) {
                return this.processTime < target.processTime ? -1: 1; 
            }
            // 시작 시간 비교 
            return this.startTime < target.startTime ? -1: 1; 
        }
        
        @Override
        public boolean equals(Object target) {
            // object 의 타입이 block인지 확인
            if (target == null || getClass() != target.getClass()) return false;
            Job job = (Job) target;
            
            if (this.index == job.index) {
                System.out.println(this.index + "==" + job.index); 
                return true; 
            }
            else 
                return false; 

        }

    }
}
