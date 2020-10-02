/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep29_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_추석트래픽_복습 {

//    public static void main(String[] args) {
//
//        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
//            "2016-09-15 20:59:58.233 1.181s",
//            "2016-09-15 20:59:58.299 0.8s",
//            "2016-09-15 20:59:58.688 1.041s",
//            "2016-09-15 20:59:59.591 1.412s",
//            "2016-09-15 21:00:00.464 1.466s",
//            "2016-09-15 21:00:00.741 1.581s",
//            "2016-09-15 21:00:00.748 2.31s",
//            "2016-09-15 21:00:00.966 0.381s",
//            "2016-09-15 21:00:02.066 2.62s"
//
//        };
//
//        System.out.println(solution(lines));
//    }

    public static int solution(String[] lines) {
        int answer = 0;

        Log[] logs = new Log[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            double t = (Double.parseDouble(line[2].substring(0, line[2].length() - 1)) * 1000);
            double endTime = toSeconds(line[1].split(":"));
            double startTime = endTime - t + 1;
            logs[i] = new Log(startTime, endTime);
        }

        for (Log now : logs) {
            double start1 = now.startTime;
            double end1 = now.startTime + 1000 - 1;
            double start2 = now.endTime;
            double end2 = now.endTime + 1000 - 1;

            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 0; i < lines.length; i++) {
                Log log = logs[i];
                
                if (log.endTime < start1 || log.startTime > end1) 
                    cnt1 = cnt1; 
                else 
                    cnt1 ++ ; 
                
                if (log.endTime < start2 || log.startTime > end2) 
                    cnt2 = cnt2; 
                else 
                    cnt2 ++; 
                
                answer = Math.max(answer, Math.max(cnt1, cnt2)); 
            }
        }

        return answer;
    }

    static double toSeconds(String[] time) {
        int hh = Integer.parseInt(time[0]);
        int mm = Integer.parseInt(time[1]);
        double ss = Double.parseDouble(time[2]);

        return (hh * 3600 + mm * 60 + ss) * 1000;
    }

    static class Log {

        double startTime;
        double endTime;

        Log(double startTime, double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }
}
