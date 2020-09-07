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

public class CodeForce_problem_1409A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int target = Math.abs(a - b);
            int cnt = 0;
            for(int i = 10; i > 0 && target > 0; i--) {
                cnt += target / i;
                target %= i; 
            }

            out.write(cnt + "\n"); 
        }
        out.flush();
    }

}
