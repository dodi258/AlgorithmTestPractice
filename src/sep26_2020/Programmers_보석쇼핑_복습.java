/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep26_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_보석쇼핑_복습 {
//
//    public static void main(String[] args) {
//
//    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2]; 
        ArrayList<int[]> candidates = new ArrayList<>();

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        int gemCnt = gemSet.size();
        Map<String, Integer> gemMap = new HashMap<>();
        int start = 100000;
        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            if (gemMap.containsKey(gem)) {
                gemMap.replace(gem, i);
                if (gemMap.size() == gemCnt) {
                    if (gems[start].equals(gem)) {
                        start = 100000; 
                        for (String key : gemMap.keySet()) {
                            if (start > gemMap.get(key)) {
                                start = gemMap.get(key);
                            }
                        }
                    }
                    candidates.add(new int[]{start, i, i - start}); 
                }
            } else {
                gemMap.put(gem, i);
                if (gemMap.size() == gemCnt) {
                    for (String key : gemMap.keySet()) {
                        if (start > gemMap.get(key)) {
                            start = gemMap.get(key);
                        }
                    }

                    candidates.add(new int[]{start, i, i - start});
                }
            }
        }
        
        Collections.sort(candidates, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2]; 
            }
        }); 
        
        answer[0] = candidates.get(0)[0] + 1;
        answer[1] = candidates.get(0)[1] + 1;
        return answer;
    }
}
