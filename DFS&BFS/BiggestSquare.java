// 프로그래머스 레벨2 가장 큰 정사각형
// 테스트케이스 통과, 채점 실패

import java.util.LinkedList;
import java.util.Queue;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        Queue<Pair> q = new LinkedList<>();
        int cMax = 0;
        int max = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
       
        // 전체 노드 탐색
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (visited[r][c])
                    continue;
                if (board[r][c] == 1) {
                    q.add(new Pair(r, c));
                }
                while (!q.isEmpty()) {
                    int cntC = 0; // 오른쪽 카운트
                    int cntR = 0; // 아랫쪽 카운트
                    Pair current = q.poll();

                    // 오른쪽으로 쭉 탐색하고 아래로 한칸 내려가서 오른쪽으로 또 쭉 탐색
                    for (int i = current.r; i < board.length; i++) {
                        for (int j = current.c; j < board[0].length; j++) {
                            if(visited[i][j])
                                break;

                            if (board[i][j] != 1)
                                break;

                            visited[i][j] = true;
                            cntC++;
                        }
                        if(cMax == 0)
                            cMax = cntC;
                        else if(cntC!=0) cMax = Math.min(cntC, cMax);
                        cntR++;
                        cntC = 0;
                    }
                    int sub = Math.min(cntR, cMax);
                    max = Math.max(max, sub);
                }
            }
        }
        answer = max * max;
        return answer;
    }
}
class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
