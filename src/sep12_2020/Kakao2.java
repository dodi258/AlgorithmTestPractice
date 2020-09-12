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
import java.util.*;

public class Kakao2 {

    static Map<String, Integer>[] sets;

//    public static void main(String[] args) {
////        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
////        int[] course = {2, 3, 4};
//
//        String[] orders = {"XYZ", "XWY", "WXA"}; 
//        int[] course = {2, 3, 4}; 
//        System.out.println(Arrays.toString(solution(orders, course)));
//    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        sets = new Map[11];
        for (int i = 0; i <= 10; i++) {
            sets[i] = new HashMap<>();
        }

        String[][] orders_array = new String[orders.length][];
        for (int i = 0; i < orders.length; i++) {
            orders_array[i] = orders[i].split("");
        }

        for (int i = 0; i < orders.length; i++) {
            Arrays.sort(orders_array[i]); 
            getSets(orders_array[i]);
            
        }

        ArrayList<String> result = new ArrayList<>();

        Arrays.sort(course);
        for (int length : course) {
            int max_count = 0;
            ArrayList<String> ret = new ArrayList<>();
            Map<String, Integer> set = sets[length];
            for (String key : set.keySet()) {
                if (set.get(key) >= 2) {
                    if (max_count < set.get(key)) {
                        ret.clear();
                        ret.add(key);
                        max_count = set.get(key);
                    } else if (max_count == set.get(key)) {
                        ret.add(key);
                    }
                }
            }

            if (ret.size() > 0) {
                result.addAll(ret);
            }
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void getSets(String[] array) {
//        System.out.println(Arrays.toString(array)); 
        StringBuilder sb = new StringBuilder();

        for (int set = 1; set < (1 << array.length); set++) {
            sb = new StringBuilder();
            String binary = Integer.toBinaryString(set);
            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) == '1') {
                    sb.append(array[binary.length() - i - 1]);
                }
            }
            String key = sb.toString();
            System.out.println(key); 
            int length = key.length();
            if (sets[length].containsKey(key)) {
                sets[length].replace(key, sets[length].get(key) + 1);
            } else {
                sets[length].put(key, 1);
            }
            
            System.out.println(key + " : " + sets[length].get(key)); 
            
        }
    }
}
