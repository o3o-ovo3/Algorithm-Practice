// 백준 알고리즘 우선순위 큐 - 가운데를 말해요
// 최대 힙과 최소 힙을 이용하여 가운데 값 찾기

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Center {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 수들 모음을 큰 순서대로 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 수들 모음을 작은 순서대로 저장

        while(N > 0){
            if(maxHeap.size() == minHeap.size())
                maxHeap.add(Integer.parseInt(br.readLine()));

            else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(Integer.parseInt(br.readLine()));
            }

            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) { // maxHeap(작은 수들) 중 가장 큰 수가 minHeap(큰 수들) 중 가장 작은 수 보다 크면 swap
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
            sb.append(maxHeap.peek() + "\n");
            N--;
        }

        System.out.println(sb);
    }
}

