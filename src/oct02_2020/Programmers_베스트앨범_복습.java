/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oct02_2020;

import java.util.*; 

class Programmers_베스트앨범_복습 {
//    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"}; 
//        int[] plays = {500, 600, 150, 800, 2500}; 
//        solution(genres, plays); 
//    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = null; 
        int N = genres.length;
        HashMap<String, Integer> genreMap = new HashMap<>(); 
        
        int index = 0; 
        for(String genre: genres) {
            if (genreMap.containsKey(genre)) continue; 
            genreMap.put(genre, index++); 
        }
//        for(String key: genreMap.keySet()) {
//            System.out.println(key + ":" + genreMap.get(key)); 
//        }
        
        
        int[][] genreCount = new int[index][2];
        for(int i = 0; i < index; i ++) {
            genreCount[i][0] = i; 
        }
        for(int i = 0; i < N; i++) {
            genreCount[genreMap.get(genres[i])][1] += plays[i]; 
        }

        Arrays.sort(genreCount, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1]; 
            }
        }); 
//        
//                for(int i = 0; i < index; i ++) {
//            System.out.println(genreMap.get(genres[i]) + ": " + Arrays.toString(genreCount[i])); 
//        }
        int[][] playIdx = new int[N][2];
        for(int i = 0; i < N; i++) {
            playIdx[i][0] = i; 
            playIdx[i][1] = plays[i]; 
        }
        
        Arrays.sort(playIdx, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0]; 
                }
                return b[1] - a[1]; 
            }
        }); 
        
        HashMap<Integer, int[]> musicTop2 = new HashMap<>(); 
        for(int i = 0; i < index; i ++) {
            musicTop2.put(i, new int[]{-1, -1}); 
        }
        
      
        for(int i = N - 1; i >= 0; i--) {
            int[] playInfo = playIdx[i]; 
            int genre = genreMap.get(genres[playInfo[0]]); 
            
            if (musicTop2.get(genre)[0] == -1) {
                musicTop2.get(genre)[0] = playInfo[0]; 
            }
            else if (plays[musicTop2.get(genre)[0]] <= playInfo[1]) {
                musicTop2.get(genre)[1] = musicTop2.get(genre)[0]; 
                musicTop2.get(genre)[0] = playInfo[0]; 
            }
//            System.out.println(Arrays.toString(musicTop2.get(genre))); 
        }
        
        ArrayList<Integer> answerArray = new ArrayList<>(); 
        for(int i = 0 ; i < index; i ++) {
            int genre = genreCount[i][0]; 
            int[] music = musicTop2.get(genre); 
            answerArray.add(music[0]); 
            if (music[1] != -1) {
                answerArray.add(music[1]); 
            }
        }
        
        answer = new int[answerArray.size()]; 
        for(int i = 0; i < answerArray.size(); i++) {
            answer[i] = answerArray.get(i); 
        }
//        System.out.println(Arrays.toString(answer)); 
        return answer; 
    }
    
}

// class Genre implements Comparable<Genre>{
//     String name; 
//     int count; 
//     Genre (String inName, int inCount) {
//         this.name = inName; 
//         this.count = inCount; 
//     }
    
//     @Override
//     public int compareTo(Genre g) {
//         return g.count - this.count; 
//     }
// }
