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

public class CodeForce_problem_1409D {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());
        
        while(t --> 0) {
            st = new StringTokenizer(in.readLine()); 
            long n = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken()); 
            long start_n = n;

            long tenpow = 10;
            while(sum(n) > s) {
                n += (tenpow - (n%tenpow));
                tenpow*=10;
            }
            
            out.write(n - start_n + "\n");
        }
 
        out.flush();
        out.close();
    }
 
    public static long sum(long n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n = n/10;
        }
        return sum;
    }
 
    
}