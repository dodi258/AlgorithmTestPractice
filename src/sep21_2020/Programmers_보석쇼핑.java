/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep21_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_보석쇼핑 {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

//        int min_idx = 1000000;  
        Map<String, Integer> idx_info = new HashMap<>();
        Set<String> gem_set = new HashSet<>();
        PriorityQueue<int[]> candidates = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2]; 
            }
        });

        for (String gem : gems) {
            gem_set.add(gem);
        }
        int gem_cnt = gem_set.size();
        int start = 1000000;
        int end = 0;

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            if (idx_info.containsKey(gem)) {
                idx_info.replace(gem, i);
                if (idx_info.size() == gem_cnt) {
                    start = 1000000; 
                    for (int idx : idx_info.values()) {
                        if (start > idx) {
                            start = idx;

                        }

                    }
                    end = i;
                    candidates.add(new int[]{start + 1, end + 1, end - start});
                }

            } else {
                idx_info.put(gem, i);
                if (idx_info.size() == gem_cnt) {

                    for (int idx : idx_info.values()) {
                        if (start > idx) {
                            start = idx;

                        }
                        if (end < idx) {
                            end = idx;

                        }
                    }

                    candidates.add(new int[]{start + 1, end + 1, end - start});
                }
            }

//            if (idx_info.size() == gem_cnt) {
//                int[] candidate = new int[3];
//                ArrayList<Integer> idxs = new ArrayList<>();
//                idxs.addAll(idx_info.values());
//
//                Collections.sort(idxs);
//                candidate[0] = idxs.get(0);
//                candidate[1] = idxs.get(gem_cnt - 1);
//                candidate[2] = candidate[1] - candidate[0];
//                candidates.add(candidate);
//            }
        }
        int min_size = Integer.MAX_VALUE;
        for (int[] candidate : candidates) {
            if (min_size > candidate[2]) {
min_size = candidate[2]; 
                answer = Arrays.copyOfRange(candidate, 0, 2);
            }
        }

//        Collections.sort(candidates, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[2] - b[2];
//            }
//        });
//        for (int[] candidate : candidates) {
//            System.out.println(Arrays.toString(candidate));
//        }
//
//        answer[0] = candidates.get(0)[0];
//        answer[1] = candidates.get(0)[1];
        return answer;
    }
}
