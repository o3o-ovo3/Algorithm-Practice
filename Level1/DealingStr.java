// 프로그래머스 Level1 - 문자열 다루기
// 개발 도구 없이 코딩하기 연습

import java.util.*;
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6)
                answer = false;
        
        int idx = 0;
        while(answer){
            if(idx >= s.length()) break;
            
            if(!Character.isDigit(s.charAt(idx))){
                answer = false;
                break;
            }
            
            idx++;
        }
        return answer;
    }
}
