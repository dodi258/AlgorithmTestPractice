/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul21_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_추석트래픽 {
//    public static void main(String[] args) {
//        String[] lines1 = {"2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s"};
//        String[] lines2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
//        String[] lines3 = {"2016-09-15 20:59:57.421 0.351s","2016-09-15 20:59:58.233 1.181s",
//            "2016-09-15 20:59:58.299 0.8s","2016-09-15 20:59:58.688 1.041s",
//            "2016-09-15 20:59:59.591 1.412s","2016-09-15 21:00:00.464 1.466s",
//            "2016-09-15 21:00:00.741 1.581s","2016-09-15 21:00:00.748 2.31s",
//            "2016-09-15 21:00:00.966 0.381s","2016-09-15 21:00:02.066 2.62s"}; 
//        System.out.println(solution(lines1));
//        System.out.println(solution(lines2));
//        System.out.println(solution(lines3));
//        
//        
//    }
    public static int solution(String[] lines) {
		int answer = 0;
                int length = lines.length; 
		int[] startTimes = new int[length];
		int[] endTimes = new int[length];
		int[] sectionTimes = new int[length * 2]; 
                
                for(int i = 0; i < length; i++) {
                    int[] time = getMilisecons(lines[i]); 
                    startTimes[i] = time[0]; 
                    endTimes[i] = time[1]; 
                    sectionTimes[i] = time[0];
                    sectionTimes[i+length] = time[1]; 
                }
                
		
                for(int i = 0; i < sectionTimes.length; i++) {
                    int sectionStart = sectionTimes[i]; 
                    int sectionEnd = sectionStart + 1000; //1000 --> 1초
                    int count = 0; 
                    
                    for(int j = 0; j < length; j++) {
                        int start = startTimes[j]; 
                        int end = endTimes[j]; 
                        
                        if ((start >= sectionStart && start < sectionEnd) || 
                            (end >= sectionStart && end < sectionEnd) ||
                            (start <= sectionStart && end >= sectionEnd)) {
                            count ++; 
                        }
                    }
                    
                    answer = Math.max(count, answer); 
                }
		
		
		return answer;
	}

    // 0.001s을 1로 단위 변환을 시켜준다. 
        public static int[] getMilisecons(String line) {
            String[] log = line.split(" ");
            String[] time = log[1].split(":"); 
            int processTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length()-1)) * 1000); 
            int start = 0; 
            int end = 0; 
            
            // 시간
            end += Integer.parseInt(time[0]) * 60 * 60 * 1000; 
            // 분
            end += Integer.parseInt(time[1]) * 60 * 1000; 
            // 초
            end += (int)(Double.parseDouble(time[2]) * 1000); 
            
            // 시작시간 = 끝나는 시간 - 걸린시간 +0.001초
            start = end - processTime + 1; // 0.001초 더해주는것. 
            
            return new int[]{start, end};
        }
        
    
}
