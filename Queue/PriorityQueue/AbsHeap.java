// 백준 알고리즘 우선순위 큐 - 절댓값 힙

package baekjoon.queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AbsHeap {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> plus = new PriorityQueue<>(); // 양수 큐
        PriorityQueue<Integer> minus = new PriorityQueue<>(); // 음수 큐

        while(N > 0){
            int x = sc.nextInt();

            // 삽입 연산
            if(x < 0) // 음수일 때
                minus.add(x * -1);

            else if(x > 0)// 양수일 때
                plus.add(x);

            // 0일 때 --> 삭제 연산
            else{
                if(plus.isEmpty() && minus.isEmpty()) // 큐에 아무것도 없으면 0
                    sb.append("0\n");

                else if(!plus.isEmpty() && minus.isEmpty())
                    sb.append(plus.poll() + "\n"); // 양수 큐에만 있을 때 가장 작은 애를 뺌

                else if(plus.isEmpty() && !minus.isEmpty())
                    sb.append(minus.poll() * -1 + "\n"); // 음수 큐에만 있으면 절대값이 가장 작은 애를 빼서 -1을 곱함

                else{ // 둘 다 큐에 원소가 있고
                    if(plus.peek() >= minus.peek()) // 같아도 마이너스를 뽑는거니까
                        sb.append(minus.poll() * -1 + "\n");

                    else
                        sb.append(plus.poll() + "\n");
                }
            }
            N--;
        }
        System.out.println(sb);
    }
}
