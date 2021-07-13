// 백준 알고리즘 스택 - 괄호

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(')
                    stack.push(str.charAt(j));
                else if (str.charAt(j) == ')') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (stack.pop() != '(') {
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) flag = false;
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
