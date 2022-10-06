import java.util.Arrays;

class Solution {
    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] check;
    static int cnt;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        cnt = 0;
        check = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
            {
                if(!check[i][j] && picture[i][j] != 0){
                    // 탐색 시작, 영역 개수 +1
                    numberOfArea++;
                    dfs(i, j, picture);
                }

                if(cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;
                cnt = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(int r, int c, int[][] picture)
    {
        check[r][c] = true;
        cnt ++;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 영역 밖인 경우는 패스
            if(nr < 0 || nc < 0 || nr >= picture.length || nc >= picture[0].length)
                continue;
            // 방문하지 않았고, 색이 picture[r][c]과 같은 경우
            if(!check[nr][nc] && picture[nr][nc] == picture[r][c])
                dfs(nr, nc, picture);
        }
    }
}
