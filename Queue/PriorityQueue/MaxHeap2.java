// 백준 알고리즘 우선순위 큐 - 최대 힙
// 최대 힙으로 구현한 것

package baekjoon.queue;

import java.util.Scanner;

public class MaxHeap2 {
    public static int[] heap = new int[100001]; // 배열로 최대 힙 구현
    public static int size = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void swap(int x, int y){ // 교환할 값의 인덱스
        int temp = heap[y];
        heap[y] = heap[x];
        heap[x] = temp;
    }

    public static void push(int x){ // 삽입 연산
        heap[++size] = x; // 마지막 노드에 일단 삽입
        // 삽입한 것 부터 힙인지 확인, 힙이 아니면 계속 부모 노드로 올라가고
        for(int i = size; i > 1; i/=2){
            if(heap[i/2] < heap[i]){
                swap(i/2, i);
            } else
                break;
        }
        // 힙이면 break;
    }

    public static void pop(){
        sb.append(heap[1] + "\n"); // 가장 큰 수를 출력 (삭제)
        heap[1] = heap[size]; // 가장 마지막 노드를 루트로 올림
        heap[size--] = 0;
        for(int i = 1; i * 2 <= size;){ // 삭제후 1에서 부터 힙으로 만드는 과정
            if(heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]){
                break; // 힙이면 break;
            }
            else if (heap[i * 2] > heap[i * 2 + 1]){
                swap(i, i*2); // 힙이 아니고 왼쪽이 더 클 때
                i = i * 2;
            }
            else{
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N > 0){
            int input = sc.nextInt();

            if(input == 0){
                if(size == 0){
                    sb.append("0\n");
                }
                else
                    pop();
            }
            else
                push(input);
        }
        System.out.println(sb);
    }
}
