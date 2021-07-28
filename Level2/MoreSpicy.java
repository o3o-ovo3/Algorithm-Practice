// 프로그래머스 Level2 - 더 맵게

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville)
            pq.add(i);

        int first = 0;
        int second = 0;
        int newSco = 0;

        while(pq.peek() < K){
            if(pq.size() <= 1){
            // 모든 음식을 K 이상으로 만들 수 없으면 -1 --> 요소가 1이 되면 더이상 더할 수 없음 --> -1
                answer = -1;
                break;
            }
            first = pq.poll();
            second = pq.poll();
            newSco = first + (second * 2);
            pq.add(newSco);
            answer ++;
            if(pq.peek() >= K)
                break;
        }
        
        return answer;
    }
} 
