// 프로그래머스 Level2 - 124 나라의 숫자
class Solution {
    public String solution(int n) {
        String answer = "";
        // n을 3으로 나눈 몫과 나머지를 구한다.
        // 몫이 0이 될 때까지 위를 반복
        // 나머지가 0이면 -> 4로, 나머지가 1, 2면 그대로 뒤에서부터 붙인다.
        // 나머지가 0이면 몫을 -1 해준다.

        int share = n; // 몫
        String remain = ""; // 나머지
        while(share > 0){
            remain = Integer.toString(share % 3);
            share /= 3;

            if(remain.equals("0")){
                remain = "4";
                share -= 1;
            }

            answer = remain + answer;
        }
        return answer;
    }
}
