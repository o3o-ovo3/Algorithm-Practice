// 프로그래머스 Level2 - 짝지어 제거하기

import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        // substring 이용했다가 실패 --> 시간초과
        // stack 이용
        int idx = 0;
        int size = s.length();
        Stack<Character> stack = new Stack<>();
        while(stack.size() != size){ // 비교할 대상이 있을 때
            if(idx > size - 1){
                if(stack.isEmpty()) {
                    answer = 1;
                }
                break;
            }

            if(!stack.isEmpty() && stack.peek() == s.charAt(idx))
                stack.pop();

            else
                stack.push(s.charAt(idx));

            idx++;
        }
        return answer;
    }
}
