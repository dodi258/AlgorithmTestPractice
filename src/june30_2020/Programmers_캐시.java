/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package june30_2020;

/**
 *
 * @author 주세인1
 */
import java.util.ArrayList;

public class Programmers_캐시 {

    static class Block {

        String city;
        int time;

        Block(String city, int time) {
            this.city = city;
            this.time = time;
        }

        public void addTime() {
            this.time += 1;
        }
//        public String print() {
//            return this.city + " " + this.time; 
//        }
    }

//    public static void main(String[] args) {
//        String[] cities = {};
//        System.out.println(solution(3, cities)); 
//    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int len = cities.length;

        if (cacheSize == 0) {
            answer = 5 * cities.length;
        } else {
            ArrayList<Block> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                String city = cities[i].toLowerCase();
                if (list.isEmpty()) {
                    list.add(new Block(city, 0));
                    answer += 5;
                    continue;
                }
                // 캐시에서 city 이름 검색하기 
                int foundIdx = -1;
                for (int j = 0; j < list.size(); j++) {
                    list.get(j).addTime();
                    if (list.get(j).city.equals(city)) {
                        foundIdx = j;
                    }
                }
                // 캐시에서 city를 찾는다면 
                // 찾은 city 맨 뒤로 보내기. 
                if (foundIdx != -1) {
                    list.remove(foundIdx);
                    list.add(new Block(city, list.size()));
                    answer += 1;    
                } 
                // 캐시에서 city찾지 못한다면, 새롭게 city 
                // 캐시에 추가하고, 가장 앞에있는 city 삭제 
                else {
                    list.add(new Block(city, list.size()));
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
