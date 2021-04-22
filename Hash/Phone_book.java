// 프로그래머스 - 해시 <전화번호 목록> 문제
// startsWith로 문자열 비교

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                // 앞에서 정렬을 했기 때문에 양 옆만 비교
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}
