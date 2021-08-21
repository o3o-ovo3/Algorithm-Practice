// 프로그래머스 Level2 - 올바른 괄호

import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        int idx = 0;
        if(s.charAt(0) == ')') answer = false;

        while(answer){
            if(idx >= s.length()) {
                if(!stack.isEmpty()) answer = false;
                break;
            }
            char c = s.charAt(idx);
            if(c == '(') {
                stack.push(c);
                idx++;
            } else{
                if(stack.isEmpty())
                    answer = false;
                else
                    stack.pop();
                idx++;
            }

        }

        return answer;
    }
}
