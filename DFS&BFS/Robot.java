// 백준 알고리즘 1726 로봇

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    // 행, 열, 방향, 카운트
    int r;
    int c;
    int dir;
    int cnt;

    Pair(int r, int c, int dir, int cnt){
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cnt = cnt;
    }
}

class Main{
    public static void main(String[] args){
        // 일단 입력을 받아
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int ANS = 0; // 명령 횟수

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        //             동 서 남  북  1 2 3 4
        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        // 방문 표시는 3차원 배열
        boolean[][][] visited = new boolean[N][M][5];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), 0));
        Pair end = new Pair(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), 0);

        while(!q.isEmpty()){
            Pair p = q.poll();

            // 종료 조건 생각하기
            if(p.r == end.r && p.c == end.c && p.dir == end.dir){
                System.out.println(p.cnt);
                ANS = p.cnt;
                break;
            }

            // 한 사이클 안에서 진행
            // 이동하기
            for(int k = 1; k <= 3; k++){
                // 이동은 현재 방향과 같은 방향으로 하니까 !!!!!
                int nr = p.r + dr[p.dir] * k;
                int nc = p.c + dc[p.dir] * k;

                // 이동 못하는 경우 !
                // 1. 범위를 초과한 경우
                if(nr >= N || nc >= M || nr < 0 || nc < 0)
                    break;

                // 2. 이미 방문한 경우
                if(visited[nr][nc][p.dir])
                    continue; // 1번 갔다고 끝나면 안되고 2번, 3번까지 탐색해야함 --> 그래서 continue

                // 3. 벽이 있는 경우
                if(map[nr][nc] == 1)
                    break;

                // 위의 경우들이 아니면 방문 표시하고 큐에 추가
                visited[nr][nc][p.dir] = true;
                q.add(new Pair(nr, nc, p.dir, p.cnt + 1));
            }
            // 방향 전환하기 (동서남북)
            for(int c = 1; c <= 4; c++){
                // 방향 전환이 안되는 경우
                // 이 경우에는 네 방향 다 검색해야 하기 때문에 for문을 빠져나가지 않도록 continue 해야함
                // 1. 현재 내 방향일 경우
                if(p.dir == c)
                    continue;

                // 2. 반대 방향일 경우
                if(isImpossible(p.dir) == c)
                    continue;

                // 3. 이미 방문한 경우
                if(visited[p.r][p.c][c])
                    continue;

                // 위 모든 경우에 해당하지 않으면 방문
                visited[p.r][p.c][c] = true;
                q.add(new Pair(p.r, p.c, c, p.cnt + 1));
            }
        }
    }
    // 갈 수 없는 방향을 반환하는 메소드
    private static int isImpossible(int d){
        switch(d){
            case 1: // 동쪽은
                return 2; // 서쪽
            case 2: // 서쪽은
                return 1; // 동쪽
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 0;
    }
}
