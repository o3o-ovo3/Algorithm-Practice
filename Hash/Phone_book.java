// 프로그래머스 - 해시 <전화번호 목록> 문제
// 정확성 통과, 효율성 실패 (시간 초과)

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                String str = phone_book[j];
                if (s.length() <= str.length() && s.equals(str.substring(0, s.length()))) {
                    answer = false;
                    break;
                }
            }
            if (!answer)
                break;
        }
        return answer;
    }
}
