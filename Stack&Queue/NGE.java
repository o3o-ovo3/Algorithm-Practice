// 백준 알고리즘 - 스택 오큰수

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int idx = N - 1;
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        while(idx >= 0){
            if(temp.isEmpty()){
                answer.push(-1);
                temp.push(Integer.parseInt(input[idx]));
            }

            else{
                while(true){
                    if(temp.isEmpty()){
                        temp.push(Integer.parseInt(input[idx]));
                        answer.push(-1);
                        break;
                    }
                    if(Integer.parseInt(input[idx]) >= temp.peek())
                        temp.pop();
                    else{
                        answer.push(temp.peek());
                        temp.push(Integer.parseInt(input[idx]));
                        break;
                    }
                }
            }
            idx --;
        }

        while(!answer.isEmpty()){
            sb.append(answer.pop());
            if(!answer.isEmpty())
                sb.append(" ");
        }
        System.out.println(sb);
    }
}
