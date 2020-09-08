/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep08_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

public class codeforce669A {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int t = Integer.parseInt(in.readLine()); 
        
        while(t --> 0) {
            int n = Integer.parseInt(in.readLine());

            String[] s = in.readLine().split(" "); 
            int[] odd = new int[n/2];
            int[] even = new int[n/2]; 
            int oddSum = 0; 
            int evenSum = 0; 
            for(int i = 0; i < n/2; i++) {
                odd[i] = Integer.parseInt(s[i*2]);
                oddSum += odd[i]; 
                even[i] = Integer.parseInt(s[i*2 + 1]); 
                evenSum += even[i]; 
                
            }
            if (oddSum == evenSum) {
                out.write(n + "\n" + String.join(" ", s) + "\n"); 
            }
            else if (oddSum > evenSum) {
                int length = n;
                int count = oddSum - evenSum; 
                for(int i = 0; i < n/2 && count > 0; i++) {
                    if (even[i] == 0 && odd[i] == 1) {
                        count++; 
                        s[i*2] = "x"; 
                        s[i*2 + 1] = "x"; 
                        length -= 2; 
                    }
                }
                String ss = String.join(" ", s).replace(" x", "").replace("x ", "").replace("x", "");
                
                if (length == 0) {
                    ss = "0"; 
                    length = 1; 
                }
                out.write(length + "\n" + ss + "\n"); 
            }
            
            else {
                int count = evenSum - oddSum;
                int length = n; 
                for(int i = 0; i < n/2 && count > 0; i++) {
                    if (even[i] == 1 && odd[i] == 0) {
                        count++; 
                        s[i*2] = "x"; 
                        s[i*2 + 1] = "x"; 
                        length -= 2; 
                        
                    }
                }
                
                String ss = String.join(" ", s).replace(" x", "").replace("x ", "").replace("x", "");
                if (length == 0) {
                    ss = "0"; 
                    length ++; 
                }
                out.write(length + "\n" + ss + "\n"); 
            }
            
        }
        
        out.flush(); 
        out.close(); 
        
    }
}
