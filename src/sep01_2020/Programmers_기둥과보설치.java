/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep01_2020;

import java.util.Arrays;

/**
 *
 * @author 주세인1
 */
public class Programmers_기둥과보설치 {

    static int[][] column; // 기둥
    static int[][] beam;   // 대들보

    public static void main(String[] args) {
        int n1 = 5;
        int[][] build_frame1 = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        int[][] result = solution(n1, build_frame1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        column = new int[n + 1 + 2][n + 1 + 2 + 2];
        beam = new int[n + 1 + 2][n + 1 + 2 + 2];
        int col_cnt = 0;
        int beam_cnt = 0;

        for (int[] frame : build_frame) {
            int col = frame[0] + 2;
            int row = frame[1] + 1;
            int type = frame[2];
            int action = frame[3];
            // type 0: 기둥, 1: 보
            // action 0: 삭제, 1: 설치
            if (type == 0) {
                if (action == 0) {
                    column[row][col] = 0;
                    if (!checkDeleteColumn(row, col)) {
                        column[row][col] = 1;
                    } else {
                        col_cnt--;
                    }
                } // action == 1
                else {
                    if (checkColumn(row, col)) {
                        column[row][col] = 1;
                        col_cnt++;
                    }
                }
            } // type ==1 
            else {
                if (action == 0) {
                    beam[row][col] = 0;
                    if (!checkDeleteBeam(row, col)) {
                        beam[row][col] = 1;
                    } else {
                        beam_cnt--;
                    }
                } // action == 1
                else {
                    if (checkBeam(row, col)) {
                        beam[row][col] = 1;
                        beam_cnt++;
                    }
                }
            }
        }

        answer = new int[col_cnt + beam_cnt][3];
        int index = 0;
        for (int i = 1; i < beam.length; i++) {
            for (int j = 2; j < beam[0].length; j++) {
                if (beam[i][j] == 1) {
                    answer[index++] = new int[]{j - 2, i - 1, 1};
                }
            }
        }
        for (int i = 1; i < column.length; i++) {
            for (int j = 2; j < column[0].length; j++) {
                if (column[i][j] == 1) {
                    answer[index++] = new int[]{j - 2, i - 1, 0};
                }
            }
        }

        Arrays.sort(answer, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        return a[2] - b[2]; 
                    }
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        return answer;
    }

    public static boolean checkBeam(int row, int col) {
        
        // 1. 밑에 기둥이 있나
        if (column[row - 1][col] == 1 || column[row - 1][col + 1] == 1) {
            return true;
        }

        // 2. 양 옆에 대들보가 있나
        if (beam[row][col - 1] == 1 && beam[row][col + 1] == 1) {
            return true;
        }
        
        
        return false;
    }

    public static boolean checkColumn(int row, int col) {
        // 1. row = 1 인가
        if (row == 1) {
            return true;
        }
        // 2. 밑에 대들보가 있나
        if (beam[row][col] == 1 || beam[row][col - 1] == 1) {
            return true;
        }
        // 3. 밑에 기둥이 있나
        if (column[row - 1][col] == 1) {
            return true;
        }

        return false;
    }

    public static boolean checkDeleteBeam(int row, int col) {
        // 1. 양쪽 대들보 밑에 기둥이 있나
        // 1-1. 오른쪽 대들보
        if (beam[row][col + 1] == 1) {
            if (column[row - 1][col + 1] == 0 && column[row - 1][col + 2] == 0) {
                return false;
            }
        }
        // 1-2. 왼쪽 대들보
        if (beam[row][col - 1] == 1) {
            if (column[row - 1][col - 1] == 0 && column[row - 1][col] == 0) {
                return false;
            }
        }

        // 2. 위에 기둥이 있다면 기둥을 이 대들보 말고 다른것이 바치고 있나
        // 2-1. 오른쪽 기둥
        if (column[row][col + 1] == 1) {
            if (column[row - 1][col + 1] == 0 && beam[row][col + 1] == 0) {
                return false;
            }
        }
        // 2-2. 왼쪽 기둥
        if (column[row][col] == 1) {
            if (column[row - 1][col] == 0 && beam[row][col - 1] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDeleteColumn(int row, int col) {
        // 1. 현재 기둥을 의지하는 양옆 두개의 대들보 검사
        // 1-1. 오른쪽 대들보 검사
        if (beam[row + 1][col] == 1) {
            if (!checkBeam(row + 1, col)) {
                return false;
            }
        }
        // 1-2. 왼쪽 대들보 검사
        if (beam[row + 1][col - 1] == 1) {
            if (!checkBeam(row + 1, col - 1)) {
                return false;
            }
        }

        // 2. 현재 기둥을 의지하는 위에 기둥을 검사
        if (column[row + 1][col] == 1) {
            if (!checkColumn(row + 1, col)) {
                return false;
            }
        }

        return true;
    }
}
