// 프로그래머스 레벨 2
// 괄호 회전하기 - 통과
// 괄호 검사에 스택 사용

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        
        for(int i = 0; i < size; i++){
            if(i != 0){
                s = s.substring(1) + s.substring(0,1);
            }
            
            // 괄호 검사
            boolean isTrue = check(s, size);
            if(isTrue){
                answer ++;
            }
        }
        return answer;
    }
    
    public static boolean check(String s, int size){
        Stack<Character> stack = new Stack<>();
        boolean isTrue = true;
        
        // 괄호 검사
        for(int k = 0; k < size; k++){
            char temp = s.charAt(k);
            
            // 시작
            if(temp == '(' || temp == '{' || temp == '['){
                stack.push(temp);
            }
            else{
                if(stack.isEmpty()){
                    isTrue = false;
                    break;
                }

                char temp2 = stack.pop();

                if((temp == ')' && temp2 != '(' ) ||
                        (temp == '}' && temp2 != '{' ) ||
                        (temp == ']' && temp2 != '[')){
                    isTrue = false;
                    break;
                }
            }if(k == size -1 && !stack.isEmpty()){
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}
