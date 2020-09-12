/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep12_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*;

public class codeforce670_A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            int answer = 0;
            int N = Integer.parseInt(in.readLine());
            char[] arr = in.readLine().replace(" ", "").toCharArray();
            Arrays.sort(arr);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                int num = arr[i] - '0'; 
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num) + 1); 
                }
                else {
                    map.put(num, 1); 
                }
            }
            if (arr[0] -'0' != 0) out.write(0 + "\n");
            
            else {
                int pre = arr[0] - '0'; 
                int max = arr[N-1] - '0' + 1;
                System.out.println("max:" + max); 
                int count = 0; 
                for(int i = 1; i < N && count < 2; i++) {
                    int num = arr[i] - '0'; 
                    System.out.println("num: " + num); 
                    if (pre == num) continue; 
                    if (map.get(num) == 1) {
                        answer += pre; 
                        count++;
                        
                    }
                    if (num - pre > 1) {
                        answer += pre;
                        count ++; 
                        System.out.println("added: " + (pre + 1)); 
                        pre += 1; 
                        i--; 
                    }
                    else {
                        pre = num; 
                    }
                     
                }
                if (count < 2) {
                    answer += max; 
                }
                
                out.write(answer + "\n");
            }

        }

        out.flush();
        out.close();
    }
}


//ArrayList<Integer> A = new ArrayList<>(); 
//            ArrayList<Integer> B = new ArrayList<>(); 
//            int max = arr[N-1] + 1;
//            int pre = arr[0] - '0';
//                A.add(pre);
//                int count = 0; 
//                for (int i = 1; i < N; i++) {
//                    int num = arr[i] - '0';
//                    if (pre == num) {
//                        B.add(num);
//                    } else {
//                        pre = num;
//                        if (count  % 2 == 0)
//                            A.add(num);
//                        else 
//                            B.add(num); 
//                        count ++; 
//                    }
//                }
//                
//                System.out.println("A: " + Arrays.toString(A.toArray()));
//                System.out.println("B: " + Arrays.toString(B.toArray()));
//                for (int i = 0; i <= max; i++) {
//                    if (!A.contains(new Integer(i))) {
//                        answer += i;
//                        break;
//                    }
//                }
//
//                for (int i = 0; i <= max; i++) {
//                    if (!B.contains(new Integer(i))) {
//                        answer += i;
//                        break;
//                    }
//                }


//A. Subset Mex
//time limit per test1 second
//memory limit per test512 megabytes
//inputstandard input
//outputstandard output
//Given a set of integers (it can contain equal elements).
//
//You have to split it into two subsets A and B (both of them can contain equal elements or be empty). You have to maximize the value of mex(A)+mex(B).
//
//Here mex of a set denotes the smallest non-negative integer that doesn't exist in the set. For example:
//
//mex({1,4,0,2,2,1})=3
//mex({3,3,2,1,3,0,0})=4
//mex(∅)=0 (mex for empty set)
//The set is splitted into two subsets A and B if for any integer number x the number of occurrences of x into this set is equal to the sum of the number of occurrences of x into A and the number of occurrences of x into B.
//
//Input
//The input consists of multiple test cases. The first line contains an integer t (1≤t≤100) — the number of test cases. The description of the test cases follows.
//
//The first line of each test case contains an integer n (1≤n≤100) — the size of the set.
//
//The second line of each testcase contains n integers a1,a2,…an (0≤ai≤100) — the numbers in the set.
//
//Output
//For each test case, print the maximum value of mex(A)+mex(B).
//
//Example
//inputCopy
//4
//6
//0 2 1 5 0 1
//3
//0 1 2
//4
//0 2 0 1
//6
//1 2 3 4 5 6
//outputCopy
//5
//3
//4
//0
//Note
//In the first test case, A={0,1,2},B={0,1,5} is a possible choice.
//
//In the second test case, A={0,1,2},B=∅ is a possible choice.
//
//In the third test case, A={0,1,2},B={0} is a possible choice.
//
//In the fourth test case, A={1,3,5},B={2,4,6} is a possible choice.

