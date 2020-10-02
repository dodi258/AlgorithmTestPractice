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
public class Problem_전화단어 {
    public static String[] book = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"}; 
    private static StringBuilder out = new StringBuilder(); 
    public static void main(String[] args) {
        combination(0, "4971927"); 
        System.arraycopy(args, 0, out, 0, 0);
    }
    
    public static void combination(int level, String phoneNumber) {
        if (level == 7) {
            System.out.println(out.toString()); 
            return; 
        }
        
        String s = book[phoneNumber.charAt(level) - '0']; 
        for(int i = 0; i < s.length(); i++) {
            out.append(s.charAt(i)); 
            combination(level + 1, phoneNumber); 
            out.deleteCharAt(out.length() - 1); 
        }
    }
    public static char getCharKey(int telephoneKey, int place) {
        return book[telephoneKey].charAt(place-1); 
    }
}
