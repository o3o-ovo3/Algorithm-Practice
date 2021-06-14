// 프로그래머스 레벨2 가장 큰 정사각형
// 동적 프로그래밍 

class Solution
{
    public int solution(int [][]board)
    {
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];

        int answer = 0;
        // 2X2 정사각형의 우측하단에서 시작
        // 1이면 좌, 좌측 대각선, 상 방향으로 1이 있는지 확인
        for(int r = 1; r < newBoard.length; r++)
            for(int c = 1; c < newBoard[0].length; c++)
                newBoard[r][c] = board[r - 1][c - 1];

        int max = 0; // 가장 큰 정사각형 한 변의 길이
        for(int i = 1; i < newBoard.length; i++){
            for(int j = 1; j < newBoard[0].length; j++){
                if(newBoard[i][j] == 1){
                    int left = newBoard[i][j-1];
                    int leftUp = newBoard[i-1][j-1];
                    int up = newBoard[i-1][j];
                    int min = Math.min(left, Math.min(leftUp, up));
                    newBoard[i][j] = min + 1;
                    max = Math.max(max, min+1);
                }
            }
        }

        answer = max * max;
        return answer;
    }
}
