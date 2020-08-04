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
//import java.util.Arrays; 

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Programmers_후보키 {

    static int answer;
    static String[][] relation;
    static ArrayList<List<Integer>> alternatives;
//
//    public static void main(String[] args) {
//        String[][] table2 = {{"a", "b", "c"},
//        {"1", "b", "c"},
//        {"a", "b", "4"},
//        {"a", "5", "c"}};
//        String[][] table3 = {{"a", "1", "4"},
//        {"2", "1", "5"},
//        {"a", "2", "4"},};
//        String[][] table = {{"100", "ryan", "music", "2"},
//        {"200", "apeach", "math", "2"},
//        {"300", "tube", "computer", "3"},
//        {"400", "con", "computer", "4"},
//        {"500", "muzi", "music", "3"},
//        {"600", "apeach", "music", "2"}};
//
//        System.out.println(solution(table));
//
//        for (int i = 0; i < alternatives.size(); i++) {
//            System.out.println("alters: " + Arrays.toString(alternatives.get(i).toArray()));
//        }
//
//    }

    public static int solution(String[][] table) {
        int col_len = table[0].length;
        relation = table;
        alternatives = new ArrayList<>();

        // 후보키가 1개로 구성 
        for (int i = 0; i < col_len; i++) {
            List<Integer> key = Arrays.asList(i);
            if (isUnique(key)) {
                alternatives.add(key);
                answer++;
            }
        }

        // 후보키가 2개 이상
        for(int cnt = 2; cnt <= col_len; cnt++) {
            int[] columns = new int[cnt]; 
            findAlternatives(0, 0, columns); 
        }
        
        return answer;
    }

    public static void findAlternatives(int depth, int index, int[] columns) {
        if (depth == columns.length) {
            List<Integer> list = Arrays.stream(columns).boxed().collect(Collectors.toList()); 
            if (isMinimum(list) && isUnique(list)) {
                alternatives.add(list);
                answer++;
            }
        } else {
            for (int i = index; i < relation[0].length; i++) {
                columns[depth] = i; 
                findAlternatives(depth+1, i + 1, columns);
            }
        }

    }

    public static boolean isUnique(List<Integer> columns) {
        List<String> values = new ArrayList<>(); 
        StringBuilder sb;
        
        for (int i = 0; i < relation.length; i++) {
            sb = new StringBuilder();
            for (int j : columns) {
                sb.append(relation[i][j]);
            }
            String s = sb.toString();
            if (values.contains(s)) {
                return false;
            }

            values.add(s);
        }
        return true;
    }

    public static boolean isMinimum(List<Integer> columns) {
        for (int i = 0; i < alternatives.size(); i++) {
            if (columns.containsAll(alternatives.get(i))) {
                return false;
            }
        }

        return true;

    }
}
