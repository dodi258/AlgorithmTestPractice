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
public class Kakao1 {
//    public static void main(String[] args) {
//        solution("...!@BaT#*..y.abcdefghijklm"); 
//    }
    public static String solution(String new_id) {
        String answer = ""; 
        
        //1. 대문자를 대응되는 소문자로 치환합니다.
        answer = new_id.toLowerCase(); 
//        System.out.println(answer);
        //2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        answer = answer.replaceAll("[^a-z0-9_\\.\\-]", ""); 
//        System.out.println(answer);
        //3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = answer.replaceAll("\\.{2,}", "."); 
//        System.out.println(answer);
        //4. 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (answer.length() > 0 && answer.charAt(0) == '.')
            answer = answer.replaceFirst("\\.", ""); 
//        System.out.println(answer);
        if (answer.length() > 1 && answer.charAt(answer.length()-1) == '.') 
            answer = answer.substring(0, answer.length()-1); 
//        System.out.println(answer);
        //5. 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (answer.length() == 0) {
            answer = "a"; 
        }
//        System.out.println(answer);
        //6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15); 
        }
//        System.out.println(answer);
        //7. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (answer.charAt(answer.length()-1) == '.') 
            answer = answer.substring(0, answer.length()-1); 
//        System.out.println(answer);
        //8. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        StringBuilder sb = new StringBuilder(answer); 
        char c = sb.charAt(sb.length()-1); 
        while(sb.length()< 3) {
            sb.append(c); 
        }
        answer = sb.toString(); 
//        System.out.println(answer); 
        return answer; 
    }
}
