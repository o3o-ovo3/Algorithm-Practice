// 프로그래머스 Level1 - 나누어 떨어지는 숫자 배열
// 개발도구 없이 코드 작성 연습

import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        if(answer.size() != 0)
            Collections.sort(answer);
        else answer.add(-1);
        return answer;
    }
}
