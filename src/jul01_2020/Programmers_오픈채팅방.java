/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul01_2020;

/**
 *
 * @author 주세인1
 */

import java.util.HashMap;
import java.util.ArrayList; 

public class Programmers_오픈채팅방 {
//    public static void main(String[] args) {
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//        solution(record); 
//    }
    
    public static String[] solution(String[] record) {
        String[] answer; 
        ArrayList<String[]> log = new ArrayList<>(); 
        HashMap<String, String> user = new HashMap<>(); 
        
        for(int i = 0; i < record.length; i++) {
            String s = record[i]; 
            String[] arr = s.split(" ");
            String status = arr[0]; 
           
            // log 저장할 명령어
            if (! status.equals("Change")) {
                log.add(new String[]{arr[1], status}); 
            }
            // user 닉네임 바꿀 명령어 
            if (! status.equals("Leave")) {
                user.put(arr[1], arr[2]); 
            }
        }
        
        answer = new String[log.size()]; 
        for(int i = 0; i < log.size(); i++) {
            String[] arr = log.get(i); 
            if (arr[1].equals("Enter")) {
                answer[i] = new StringBuilder().append(user.get(arr[0])).append("님이 들어왔습니다.").toString(); 
            }
            else {
                 answer[i] = new StringBuilder().append(user.get(arr[0])).append("님이 나갔습니다.").toString(); 
            }
        }

        return answer; 
    }
}
