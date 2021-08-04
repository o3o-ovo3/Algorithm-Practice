// 프로그래머스 위클리 챌린지 - 1주차
// 내 코드
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += i * price;
        }
        answer = money - sum;
        if (answer > 0) answer = 0;
        else answer = answer * -1;
        return answer;
    }
}


// 좋아요 많은 코드
/* 등차수열의 합과 max 메소드 사용
class Solution {
    public long solution(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
*/
