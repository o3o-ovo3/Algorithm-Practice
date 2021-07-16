// 백준 알고리즘 - 스택 오큰수
// 시간 초과

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++)
            stack.push(Integer.parseInt(st.nextToken()));

        int[] arr = new int[N];
        int max = stack.pop();
        int peek = 0;
        int idx = N - 1;
        arr[idx] = -1;

        while(!stack.isEmpty()){
            int now = stack.pop();
            if(peek != 0){
                if(now < peek){
                    arr[--idx] = peek;
                    max = peek;
                }

                else if(now < max) {
                    arr[--idx] = max;
                    peek = now;
                }

                else{
                    arr[--idx] = -1;
                    max = now;
                }
            }
            else{
                if(now > max) {
                    arr[--idx] = -1;
                    max = now;
                    peek = now;
                }
                else{
                    arr[--idx] = max;
                    peek = now;
                }
            }
        }
        for (int i = 0; i < N; i++){
            System.out.print(arr[i]);
            if(i != N-1)
                System.out.print(" ");
        }
    }
}
