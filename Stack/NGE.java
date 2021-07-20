// 백준 알고리즘 - 스택 오큰수

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" "); // 한 줄을 한번에 배열에 저장하기
        StringBuilder sb = new StringBuilder();

        int idx = N - 1;
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        while(idx >= 0){
            // 현재값과 비교했을 때 스택 안의 수가 더 크면 answer에 넣고, 현재 값을 스택 안에 넣음
            // 현재값보다 작으면 작지 않을 때 까지 pop
            // 현재값을 스택에 저장
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
