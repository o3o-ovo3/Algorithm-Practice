// 백준 알고리즘 스택 - 제로

package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++){
            int in = sc.nextInt();
            if(in == 0)
                stack.pop();
            else
                stack.push(in);
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
