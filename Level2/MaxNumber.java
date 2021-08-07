// 프로그래머스 Level2 - 큰 수 만들기 (그리디 문제)
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(); // 시간 절약을 위해 StringBuilder 사용
        int cnt = number.length() - k; // 남겨야하는 숫자의 개수

        int max = -1;
        int idx = 0;

        int left = 0;
        int right = number.length() - cnt;

        while(cnt > 0){
            max = -1;
            for(int j = left; j <= right; ++j){
                int num = number.charAt(j) - '0'; // 아스키코드 숫자는 48부터 시작하므로 숫자값을 얻고 싶으면 48을 빼주면 된다. ('0'가 48)
                if(num > max){
                    idx = j;
                    max = num;
                }
            }
            sb.append(number.charAt(idx));
            left = idx + 1;
            right = number.length() - --cnt;
        }
        
        return sb.toString();
    }
}
