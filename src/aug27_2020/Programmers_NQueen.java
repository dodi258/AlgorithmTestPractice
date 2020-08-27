/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aug27_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_NQueen {

    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 5;
        int n3 = 6;
        int n4 = 7;
        int n5 = 8;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
        System.out.println(solution(n4));
        System.out.println(solution(n5));
    }

    public static int[] queensPosition;
    public static int N;

    public static int solution(int n) {
        queensPosition = new int[n];
        N = n;
        return placeQueens(0);
    }

    public static int placeQueens(int row) {
        if (row == N) {
            return 1;
        }
        int ret = 0;

        for (int col = 0; col < N; col++) {
            boolean isAvailable = true;
            for (int preRow = 0; preRow < row; preRow++) {
                int preCol = queensPosition[preRow];
                // 같은 열 
                if (preCol == col) {
                    isAvailable = false;
                    break;
                }
                //대각선
                if (Math.abs(preCol - col) == Math.abs(preRow - row)) {
                    isAvailable = false;
                    break;
                }
            }
            
            // 이자리가 가능하면 ! 
            if (isAvailable) {
                queensPosition[row] = col;
                // 계속 리턴값을 더해라. 
                ret += placeQueens(row + 1);
            }

        }
        return ret;
    }
}
