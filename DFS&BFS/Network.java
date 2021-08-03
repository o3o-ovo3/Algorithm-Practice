// 프로그래머스 DFS & BFS - 네트워크

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // dfs로 노드 탐색
// 탐색 종료 후 방문하지 않은 노드가 있는지 탐색 -> 있으면 count ++ (연결되어있지 않으니까 네트워크 수가 많아짐)

        boolean[] visited = new boolean[computers.length];

        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                answer ++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;

        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }
}
