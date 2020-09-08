package sep07_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Tree_트리의지름_1167번_메모리안초과 {
    static int n, max = 0;
    static Point maxP;
    static boolean visit[];
    static List<Point>[] arrList;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arrList = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arrList[i] = new ArrayList<>();
            String[] nodes = in.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            
           for (int j = 1; j < nodes.length-1; j+=2) {
                int node2 = Integer.parseInt(nodes[i]); 
                arrList[node1].add(new Point(node2, Integer.parseInt(nodes[i+1]))); 
            }
        }

        Point tmp = dfs(arrList[1].get(0), 0);
        visit = new boolean[n + 1];
        maxP = null;
        max = 0;
        dfs(tmp, 0);
        System.out.println(max);

    }

    private static Point dfs(Point p, int val) {

        visit[p.x] = true;
        for (Point t : arrList[p.x]) {
            if (!visit[t.x]) {
                dfs(t, val + t.y);
            }
        }
        if (max < val) {
            max = val;
            maxP = p;
        }
        return maxP;
    }

}
