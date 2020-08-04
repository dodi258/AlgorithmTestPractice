/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jul20_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;
import java.io.*;

class 다익스트라 {
    static final int INF = 987654321;
    static int v, e;
    static int[] dist;
    static List<List<Node>> list;
 
    static class Node implements Comparable<Node> {
        int index, distance;
 
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
 
        public int compareTo(Node n) {
            //오름차순 
            //앞에 것이 크면 양수,  --> 더 뒤로간다. 
            return this.distance - n.distance;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        // Input
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v+1];
        list = new ArrayList<List<Node>>();
 
        int start = Integer.parseInt(br.readLine());
 
        list.add(new ArrayList<Node>());
        // init array
        Arrays.fill(dist, INF);
        for(int i=1; i<=v; i++) {
            list.add(new ArrayList<Node>());
        }
        
        // input
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
 
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            list.get(v1).add(new Node(v2, cost));
        }
 
        // algorithm
        dijkstra(list, dist, start);
 
        // output
        for(int i=1; i<=v; i++) {
            if(dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
 
    static void dijkstra(List<List<Node>> list, int[] distance, int start) {
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
 
        distance[start] = 0;
        pq.add(new Node(start, 0));
 
        while(!pq.isEmpty()) {
            int now = pq.poll().index;
 
            if(visited[now]) continue;
            visited[now] = true;
 
            for(Node node : list.get(now)) {
                if(distance[node.index] > distance[now] + node.distance) {
                    distance[node.index] = distance[now] + node.distance;
                    pq.add(new Node(node.index, distance[node.index]));
                }
            }
        }
    }
 
}
