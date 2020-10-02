/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct01_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*; 
// space: 32
// enter: 13
// - : 45; 
// = : 61; 
public class BOJ_크로아티아알파벳 {
//    public static void main(String[] args) throws IOException {
//        int count = 0; 
//        int prev = 0; 
//        for(int c = System.in.read(); c >= 13 ; c = System.in.read()) {
//            if (c == '=' || c == '-') {
//                if (c == '=' && prev == -1)
//                    count --; 
//            }
//            
//            else {
//                if (c == 'z' && prev == 'd') {
//                    prev = -1; // 특별한 표시를 해줌. 
//                    count ++; 
//                    continue; 
//                }
//                
//                else {
//                    if (!(c == 'j' && (prev == 'l' || prev == 'n')))
//                        count ++; 
//                }
//            }
//            
//            prev = c; 
//
//        }
//        
//        System.out.println(count); 
//    }
//    public static void main(String[] args) {
//        int answer = 0;
//        Scanner in = new Scanner(System.in);
//
//        char[] charArray = in.next().toCharArray();
//
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            if (i < charArray.length - 1) {
//
//                char nc = charArray[i + 1];
//                switch (c) {
//                    case 'c':
//                        if (nc == '=' || nc == '-') {
//                            i += 1;
//                        }
//                        break;
//                    case 'd':
//                        if (nc == '-') {
//                            i += 1;
//                        } else if (nc == 'z' && i < charArray.length - 2) {
//                            if (charArray[i + 2] == '=') {
//                                i += 2;
//                            }
//                        }
//                        break;
//                    case 'l':
//                        if (nc == 'j') {
//                            i += 1;
//                        }
//                        break;
//                    case 'n':
//                        if (nc == 'j') {
//                            i += 1;
//                        }
//                        break;
//                    case 's':
//                        if (nc == '=') {
//                            i += 1;
//                        }
//                        break;
//                    case 'z':
//                        if (nc == '=') {
//                            i += 1;
//                        }
//                        break;
//                }
//            }
//
//            if (c >= 'a' && c <= 'z') {
//                answer++;
//            }
//
//        }
//
//        System.out.println(answer);
//    }
}
