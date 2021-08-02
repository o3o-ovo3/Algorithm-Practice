// 프로그래머스 DFS & BFS - 네트워크
// 테스트케이스 통과, 제출 실패
import java.util.*;
class Node{
    int r;
    int c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        // 0을 만날 때 까지 상하좌우로 이동
        int[] dr = {-1, +1, 0, 0};
        int[] dc = {0, 0, -1, +1};
        // 방문한 모든 곳을 방문 표시
        // 한번 탐색할 때 마다 count --> count의 수 = network 수
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && computers[i][j] == 1){
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    answer ++;
                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int x = 0; x< 4; x++){
                            int nr = node.r + dr[x];
                            int nc = node.c + dc[x];

                            if (nr >= n || nc >=n || nr < 0 || nc < 0) // 벽에 닿으면
                                continue;

                            if(!visited[nr][nc] && computers[nr][nc] == 1){
                                visited[nr][nc] = true;
                                queue.add(new Node(nr, nc));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
