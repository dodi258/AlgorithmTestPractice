/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep20_2020;

import java.util.*;

public class Programmers_셔틀버스 {

//    public static void main(String[] args) {
//        int n1 = 1;
//        int t1 = 1;
//        int m1 = 5;
//        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
//
//        int n2 = 2;
//        int t2 = 10;
//        int m2 = 2;
//        String[] timetable2 = {"09:10", "09:09", "08:00"};
//
//        int n3 = 10;
//        int t3 = 60;
//        int m3 = 45;
//        String[] timetable3 = {"23:59", "23:59", "23:59", "23:59",
//            "23:59", "23:59", "23:59", "23:59",
//            "23:59", "23:59", "23:59", "23:59",
//            "23:59", "23:59", "23:59", "23:59"};
//
//        int n4 = 2;
//        int t4 = 1;
//        int m4 = 2;
//        String[] timetable4 = {"09:00", "09:00", "09:00", "09:00"};
//
//        // 실험용 
////        System.out.println(solution(n1, t1, m1, timetable1));
////        System.out.println(solution(n2, t2, m2, timetable2));
////        System.out.println(solution(n3, t3, m3, timetable3));
////        System.out.println(solution(n4, t4, m4, timetable4));
//    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // 가장 빨리 대기한 사람부터 정렬 
        Arrays.sort(timetable);
        
        int[] latest_time = new int[2]; // 탈 수 있는 가장 마지막 시간 저장. 
        int[] bus_time = new int[2]; // 도착하는 버스 시간 
        int total_time = 0; // 총 흐른 시간. 
        int start_idx = 0;  // 버스가 도착할 때 가장 먼저 탈 수 있는지 검사할 사람의 인덱스 

        while (n -- > 0) {
            bus_time[0] = 9 + total_time / 60;
            bus_time[1] = total_time % 60;

            int people_cnt = 0; // 버스에 탄 사람 수 
            int i = 0;
            for (i = start_idx; i < timetable.length && people_cnt < m; i++) {
                String[] time = timetable[i].split(":");

                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);

                // 버스 도착 시간 >= 사람 도착시간  --> 이사람은 탈 수 있음. 
                if ((bus_time[0] * 60 + bus_time[1]) >= (hour * 60 + minute)) {
                    people_cnt++;
                    latest_time[0] = hour;
                    latest_time[1] = minute;
                } 
                // 이 사람 부터 탈 수 없음. 
                else {
                    break;
                }
            }
            start_idx = i;
            
            // 버스 정원 꽉 참. 
            if (people_cnt == m) {
                if (latest_time[1] == 0) {
                    latest_time[1] = 59;
                    latest_time[0] -= 1;
                } else {
                    latest_time[1] -= 1;
                }
            } // 버스 정원이 꽉 안찼음. 
            else {
                if ((bus_time[0] * 60 + bus_time[1]) > (latest_time[0] * 60 + latest_time[1])) {
                    latest_time[0] = bus_time[0];
                    latest_time[1] = bus_time[1];
                }
            }

            // 시간이 t 씩 감. 
            total_time += t;
        }

        // 시간을 문자열로 변경하기 
        StringBuilder sb = new StringBuilder();
        if (latest_time[0] < 10) {
            sb.append("0");
        }
        sb.append(latest_time[0]);
        sb.append(":");
        if (latest_time[1] < 10) {
            sb.append("0");
        }
        sb.append(latest_time[1]);
        answer = sb.toString();
        
        return answer;
    }
}
