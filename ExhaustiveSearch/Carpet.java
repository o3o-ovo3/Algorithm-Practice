// 프로그래머스 - 완전탐색 <카펫> 문제
// 테스트 성공, 제출 성공 
// 한번에 푼 문제 >_< 기분 좋아

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;
        // 1. yellow가 나오는 곱의 쌍 (x, y) 구하기 -> x > y 인 걸로
        for(int i = yellow; i > 0; i--){
            if(yellow % i == 0){
                x = i;
                y = yellow / i;
            }
            // 2. (x + y) * 2 + 4 가 brown 인지 판별
            if((x + y) * 2 + 4 == brown)
                break;
        }

        // 3. 2가 맞으면 (x+2), (y+2) return
        answer[0] = x + 2;
        answer[1] = y + 2;
        
        return answer;
    }
}
