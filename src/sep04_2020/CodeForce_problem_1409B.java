/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep04_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*;

public class CodeForce_problem_1409B {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());
        
        while(t --> 0) {
            st = new StringTokenizer(in.readLine()); 
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long result1 = 0;
            long result2 = 0; 

            // case 1
            if (a - x <= n) {
                result1 = x; 
                if (b - y <= n-(a-x)) {
                    result1 *= y; 
                }
                else {
                    result1 *= (b - (n-(a-x))); 
                }
            }
            else {
                result1 = a - n;
                result1 *= b; 
            }
            
            // case2
            if (b - y <= n) {
                result2 = y; 
                if (a - x <= n-(b-y)) {
                    result2 *= x; 
                }
                else {
                    result2 *= (a - (n-(b-y))); 
                }
            }
            
            else {
                result2 = b - n; 
                result2 *= a; 
            }
            
            if (result1 < result2) {
                out.write(result1 + "\n"); 
            }
            else out.write(result2 + "\n"); 

        }
        out.flush(); 
    }
    
}
