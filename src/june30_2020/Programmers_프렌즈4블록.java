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

class Programmers_프렌즈4블록 {
//    public static void main(String[] args) {
//        String[] board = {
//            "CCBDE", "AAADE", "AAABF", "CCBBF"
//        }; 
//        
//        solution(4, 5, board);
//    }

    static char[][] map;
    static boolean[][] visited;
    static ArrayList<Character>[] vertical;

    public static int solution(int m, int n, String[] board) {

        int answer = 0;
        map = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            char[] ch = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = ch[j];
            }
        }

        while (true) {
            visited = new boolean[m][n];
            vertical = new ArrayList[n];
            boolean flag = false;
            
            // 나중에 지우기 위해 저장. 
            for (int i = 0; i < n; i++) {
                vertical[i] = new ArrayList<Character>();
            }

            // 지워지는 4블록들 표시하기.
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == 0) {
                        continue;
                    }
                    isSquare(i, j);
                }
            }

            // 점검. 아무것도 안지워지나, 아니면 지워진것이 있는가
            Outter:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == true) {
                        flag = true;
                        break Outter;
                    }
                }
            }

            if (!flag) {
                break;
            }

            // 지워지는 4블록들 지우고, 지워진거 빼고 밑에서 부터 위에까지 행 단위로 line에 저장.
            for (int i = 0; i < n; i++) {
                // 뒤에서 부터. 
                for (int j = m - 1; j >= 0; j--) {
                    // 안지워진것은 추가! 
                    if (visited[j][i] == false) {
                        vertical[i].add(map[j][i]);
                    } // 블록 지워진거 합계 
                    else {
                        answer++;
                    }
                }
            }

            map = new char[m][n];

            // 지워진 배열빼고 다시 char 배열에 저장.
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if (vertical[i].size() <= m - 1 - j) {
                        break;
                    }
                    map[j][i] = vertical[i].get((m - 1) - j);
                }
            }
        }

        return answer;
    }

    public static void isSquare(int x, int y) {

        if (map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1]) {
            visited[x][y] = true;
            visited[x + 1][y] = true;
            visited[x][y + 1] = true;
            visited[x + 1][y + 1] = true;
        }

    }

}
