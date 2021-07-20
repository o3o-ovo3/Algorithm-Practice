// 백준 알고리즘 스택 - 스택 수열

package baekjoon.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int num = 1;
        List<String> test = new ArrayList<>();
        while(flag){
            if(num > N) break;
            stack.push(num);
            test.add("+");
            while(idx < N){
                if(stack.isEmpty()) break;
                if(arr[idx] == stack.peek()) {
                    stack.pop();
                    test.add("-");
                    idx++;
                }
                else if(arr[idx] != stack.peek() && num == N){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                else break;
            }
            num++;
        }
        if(flag) {
            for (String s : test)
                System.out.println(s);
        }
    }
}
