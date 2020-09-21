/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep16_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_외벽점검 {

    static int minCheckCnt = 0;
    static boolean[] visited;
    static int weak_length;
    static int dist_length;
    static int[] weakArr;
    static int[] distArr;
    static int N;

//    public static void main(String[] args) {
//        int n1 = 12;
//        int[] weak1 = {1, 5, 6, 10};
//        int[] dist1 = {1, 2, 3, 4};
//
//        int n2 = 12;
//        int[] weak2 = {1, 3, 4, 9, 10};
//        int[] dist2 = {3, 5, 7};
//        
//        int n3 = 200; 
//        int[] weak3 = {0, 10, 50, 80, 120, 160}; 
//        int[] dist3 = {1, 10, 5, 40, 30}; 
//
//        System.out.println("result: " + solution(n1, weak1, dist1));
//
//        System.out.println("result: " + solution(n2, weak2, dist2));
//        System.out.println("result: " + solution(n3, weak3, dist3));
//    }

    public static int solution(int n, int[] weak, int[] dist) {
        minCheckCnt = Integer.MAX_VALUE;
        weak_length = weak.length;
        dist_length = dist.length;

        weakArr = weak;
        distArr = dist;
        N = n;
        
        Arrays.sort(distArr); 

        for (int i = 0; i < weak_length; i++) {
            visited = new boolean[weak.length];
            checkWeaks(dist_length-1, i, 0);
            visited = new boolean[weak.length];
            checkWeaksReverse(dist_length-1, i, 0); 
        }
        
//        Integer[] IntegerDist = Arrays.stream(distArr).boxed().toArray(Integer[]:: new); 
//        Arrays.sort(IntegerDist, Comparator.reverseOrder()); 
//        
//        for (int i = 0; i < weak_length; i++) {
//            visited = new boolean[weak.length];
//            checkWeaks(dist_length-1, i, 0);
//            visited = new boolean[weak.length];
//            checkWeaksReverse(dist_length-1, i, 0); 
//        }
        if (minCheckCnt == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCheckCnt;
        }

    }

    public static void checkWeaks(int dist_index, int weak_index, int cnt) {
        boolean isAllVisited = true;
        for (int i = 0; i < weak_length; i++) {
            if (!visited[i]) {
                isAllVisited = false;
                break;
            }
        }

        if (isAllVisited) {
            minCheckCnt = cnt;
        }

        if (dist_index < 0) {
            return;
        }
        
        if (minCheckCnt <= cnt) {
            return;
        }


        
        int i = weak_index % weak_length; 
        int canGo = distArr[dist_index] + weakArr[i];
        
        if (canGo >= N) {
            while(!visited[i] && (((weakArr[i] <= N) && (weakArr[weak_index] <= weakArr[i])) || (weakArr[i] <= (canGo % N)))) {
                visited[i++] = true; 
                i %= weak_length; 
            }
        }
        else {
            while(!visited[i] && (weakArr[i]>= weakArr[weak_index] && weakArr[i]<= canGo)) {
                visited[i++] = true; 
                i %= weak_length; 
            }
        }
        
        checkWeaks(dist_index-1, (i) % weak_length, cnt + 1);

    }
    

    
    public static void checkWeaksReverse(int dist_index, int weak_index, int cnt) {
        boolean isAllVisited = true;
//       System.out.println(Arrays.toString(visited)); 
        for (int i = 0; i < weak_length; i++) {
            if (!visited[i]) {
                isAllVisited = false;
                break;
            }
        }

        if (isAllVisited) {
            minCheckCnt = cnt;
        }

        if (dist_index < 0) {
            return;
        }
        
        if (minCheckCnt <= cnt) {
            return;
        }


        
        int i = weak_index % weak_length; 
        int canGo = weakArr[i] - distArr[dist_index];

        if (canGo < 0) {
            canGo += N; 
            while(!visited[i] && (((weakArr[i] <= N) && (canGo <= weakArr[i])) || (weakArr[i] <= weakArr[weak_index]))) {
                visited[i--] = true; 
                if (i < 0) 
                    i = weak_length - 1; 
//                i %= weak_length; 
            }
        }
        else {
            while(!visited[i] && (weakArr[i] <= weakArr[weak_index] && weakArr[i]>= canGo)) {
                visited[i--] = true; 
                if (i < 0) 
                    i = weak_length - 1; 
//                i %= weak_length; 
            }
        }
        
        checkWeaksReverse(dist_index-1, (i) % weak_length, cnt + 1);

    }
}
