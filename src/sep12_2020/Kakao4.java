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
public class Kakao4 {
//    public static void main(String[] args) {
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150" }; 
//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}; 
//        System.out.println(Arrays.toString(solution(info, query))); 
//    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] infos = new String[info.length][2]; 
        String[][] queries = new String[query.length][2]; 
        StringBuilder sb;
        for(int i = 0; i < info.length; i++) {
            sb = new StringBuilder(); 
            String[] in = info[i].split(" "); 
            for(int j = 0; j < 4; j++) {
                sb.append(in[j].charAt(0)); 
            }
            infos[i][0] = sb.toString(); 
            infos[i][1] = in[4]; 
            
            System.out.println(Arrays.toString(infos[i])); 
        }
        
        
        for(int i = 0; i < query.length; i++) {
            sb = new StringBuilder(); 
            String s = query[i].replace(" and", ""); 
            String[] qu = s.split(" "); 
//            System.out.println(Arrays.toString(qu)) ; 
            for(int j = 0; j < 4; j++) {
                if (qu[j].charAt(0) == '-')
                    sb.append("."); 
                else {
                    sb.append(qu[j].charAt(0)); 
                }
            }
            
            if (qu[4].equals("-"))
                queries[i][1] = "0"; 
            else 
                queries[i][1] = qu[4]; 
            queries[i][0] = sb.toString(); 
            System.out.println(Arrays.toString(queries[i])); 
        }
        
        for(int i = 0; i < queries.length; i++) {
            String[] que = queries[i]; 
            for(int j = 0; j < infos.length; j++) {
                String[] inf = infos[j]; 
                if (inf[0].matches(que[0])) {
//                    System.out.println("inf: " + inf[0] + " que: " + que[0]); 
                    if(Integer.parseInt(que[1]) <= Integer.parseInt(inf[1]))
                        answer[i]++; 
                }
            }
        }

        return answer;
    }
}
