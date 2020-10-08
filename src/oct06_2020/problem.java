/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct06_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
public class problem {
//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder(); 
//        List<String> list = new ArrayList<String>();  
//        List<String> result = combination(4, 4, "", list); 
//        
//        for(String s: result) {
//            System.out.println(s); 
//        }
//    }
    
    private static List<String> combination(int start, int end,
                                     String pairs, List<String> result) {
        if (start > end) return result;
        if (start < 0 || end < 0) return result;
        if (start == 0 && end == 0) {
            result.add(pairs);
            return result;
        }
        combination(start - 1, end, pairs + "(", result);
        combination(start, end - 1, pairs + ")", result);
        return result;
    }
}
