/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june02_2020;

/**
 *
 * @author 주세인1
 */


public class Programmers_방금그곡 {
//    public static void main(String[] args) {
//
//        String m1 = "ABCDEFG"; 
//        String m2 = "CC#BCC#BCC#BCC#B"; 
//        String m3 = "ABC";
//        
//        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}; 
//        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}; 
//        
//        System.out.println(solution(m1, musicinfos1)); 
//        System.out.println(solution(m2, musicinfos2)); 
//        System.out.println(solution(m3, musicinfos3)); 
//    }
    
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)"; 
        int maxTime = 0; 
        m = replaceSharp(m); 

        String[] info; 
        String music; 
        for(int i = 0; i < musicinfos.length; i++) {
            info = musicinfos[i].split(","); 
            int time = getPlayMinutes(info[0],info[1]); 
            music = getMusicSeque(time, replaceSharp(info[3])); 
            System.out.println("music: " + music); 

            if (music.contains(m)) {
                if (maxTime < time) {
                    maxTime = time; 
                    answer = info[2]; 
                }
            }
        }
        
        return answer; 
    }
    
    // 재생 시간 분 단위로 구하기 
    public static int getPlayMinutes(String start, String end) {
        String[] sArr = start.split(":"); 
        String[] eArr = end.split(":"); 
        
        return (Integer.parseInt(eArr[0])*60 + Integer.parseInt(eArr[1])) 
                - (Integer.parseInt(sArr[0])*60 + Integer.parseInt(sArr[1])); 
    }
    
    // 재생한 시간 만큼 재생된 음악의 악보를 구한다. 
    public static String getMusicSeque(int time, String sheet) {
        StringBuilder sb = new StringBuilder(); 
        int cnt = 0; 
        int len = sheet.length(); 
        while(cnt < time) {
            sb.append(sheet.charAt((cnt++)%len));
        }

        return sb.toString();
    }
    
     // # 을 가진 음계를 소문자로 바꾼다. 
    public static String replaceSharp(String music) {
        
        return music.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
    }
    
}
