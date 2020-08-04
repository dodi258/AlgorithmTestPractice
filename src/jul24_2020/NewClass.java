/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul24_2020;

/**
 *
 * @author 주세인1
 */
import java.util.PriorityQueue; 
import java.util.Collections; 
import java.util.Comparator; 

public class NewClass {
    public void heapImplementation() {
        // 구현 1: Collections 사용, 내림차순 -> 가장큰값이 root(index 0) 으로 오도록 정렬 
        PriorityQueue<Integer> maxheap1 = new PriorityQueue<>(Collections.reverseOrder()); 

        // 구현 2: Comparator 재정의, 내림차순 -> 가장큰값이 root(index 0) 으로 오도록 정렬 
        PriorityQueue<Integer> maxheap2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 <= i2 ? 1 : -1; 
            }
        });
    }
}
