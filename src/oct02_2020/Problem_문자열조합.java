/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct02_2020;

/**
 *
 * @author 주세인1
 */
public class Problem_문자열조합 {
    static private StringBuilder out = new StringBuilder(); 
    static private String in; 
    
//    public static void main(String[] args) {
//        in = "wxyz"; 
//        combine(0); 
//    }
    public static void combine(int start) {
        for(int i = start; i < in.length(); i++) {
            out.append(in.charAt(i)); 
            System.out.println(out.toString()); 
            combine(i + 1); 
            out.deleteCharAt(out.length()-1); 
        }
    }
}
