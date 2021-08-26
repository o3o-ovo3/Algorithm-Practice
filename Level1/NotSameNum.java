// 프로그래머스 Level 1 - 같은 숫자는 싫어
// 개발 도구 없이 코드 짜기 연습

import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                answer.add(arr[i]);
                continue;
            }
            if(arr[i] == arr[i -1]) continue;
            else answer.add(arr[i]);
        }

        return answer;
    }
}
