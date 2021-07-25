// 백준 알고리즘 우선순위 큐 - 최대 힙

package baekjoon.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 연산의 개수
        Queue<Integer> priorityQueue = new PriorityQueue<>(); // 우선순위 큐로 구현

        while(N > 0){
            int input = sc.nextInt();
            if(input == 0){
                if(priorityQueue.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(priorityQueue.poll() * -1 + "\n"); // 2. 출력할 때 --> 입력 시 곱했던 -1을 다시 곱하여 출력
            }

            else{
                priorityQueue.add(input * -1); // 1. 그냥 넣으면 작은 수가 우선순위가 높게 측정됨 --> -1을 곱해서 넣어줌
            }
            N--;
        }
        System.out.println(sb);
    }
}
