/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul06_2020;

/**
 *
 * @author 주세인1
 */
import java.util.ArrayList;

public class Programmers_캐시 {

//
//    public static void main(String[] args) {
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//        System.out.println(solution(3, cities)); 
//    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int len = cities.length;

        if (cacheSize == 0) {
            answer = 5 * cities.length;
        } else {
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                String city = cities[i].toLowerCase();
                if (list.isEmpty()) {
                    list.add(city);
                    answer += 5;
                    continue;
                }
                // 캐시에서 city 이름 검색하기 
                int foundIdx = -1;
                for (int j = 0; j < list.size(); j++) {;
                    if (list.get(j).equals(city)) {
                        foundIdx = j;
                    }
                }
                // 캐시에서 city를 찾는다면 
                // 찾은 city 맨 뒤로 보내기. 
                if (foundIdx != -1) {
                    list.remove(foundIdx);
                    list.add(city);
                    answer += 1;    
                } 
                // 캐시에서 city찾지 못한다면, 새롭게 city 
                // 캐시에 추가하고, 가장 앞에있는 city 삭제 
                else {
                    list.add(city);
                    if (list.size() > cacheSize) {
                        list.remove(0);
                    }
                    answer += 5;
                }

            }
        }
        return answer;
    }
}

