// 백준 알고리즘 트리 - 트리의 부모 찾기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node{
        int idx;
        int root;
        ArrayList<Node> adj;

        public Node(int idx){
            this.idx = idx;
            this.root = 0;
            this.adj = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N + 1];
        for(int i = 1; i <= N; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < N - 1; i++){ // 관계 생성
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        Queue<Node> q = new LinkedList<>();
        nodes[1].root = -1;
        q.add(nodes[1]);

        boolean[] visited = new boolean[N + 1];
        while(!q.isEmpty()){
            Node now = q.poll();
            for(Node n : now.adj){
                if(!visited[n.idx]){
                    visited[n.idx] = true;
                    n.root = now.idx; // 현재 노드가 부모 노드가 됨
                    q.add(n);
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(nodes[i].root);
        }
    }
}
