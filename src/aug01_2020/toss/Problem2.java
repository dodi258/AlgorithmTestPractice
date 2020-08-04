/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug01_2020.toss;

/**
 *
 * @author 주세인1
 */
import java.io.*;
import java.util.*; 
class Problem2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
                char ch = ' '; 
                if (ch == ' '){
                    System.out.println(true); 
                }
                System.out.println(solution(input)); 
        }
	
	public static boolean solution(String input) {
             String[] arr = input.split(" ");
            int[] nums = new int[46]; 
            //6
            if (arr.length != 6) return false; 
            // 중복 X
            // 숫자
            //1~ 45
            
            System.out.println(Arrays.toString(arr)); 
            char chNum; 
            for(int i = 0; i < 6; i++) {
		char[] str = arr[i].toCharArray(); 
                System.out.println("str: " + Arrays.toString(str)); 
                        
		for(int j = 0; j < str.length; j++) {
		if (! Character.isDigit(str[j]) || str[j] == ' ')
                    return false; 
                }
                
                int num = Integer.parseInt(arr[i]); 
                if (num < 1 || num > 45) return false; 
                if (nums[num] != 0) return false;
                nums[num] ++; 
            }
            String[] unsortedArr = arr.clone(); 
            Arrays.sort(arr); 
            //오름차순
            for(int i = 0; i < 6; i++) {
                if (! arr[i].equals(unsortedArr[i]))
                    return false; 
            }
            
              return true; 
	}
}
