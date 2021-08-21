// 프로그래머스 Level2 - 최솟값 만들기

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 가장 작은 값 * 가장 큰 값을 순서대로 뽑아 계산한 것의 합이 최소
        // 우선순위 큐를 이용
        // A는 그냥 저장, 최솟값을 뽑기 위함
        // B는 -1을 곱하여 저장, 최댓값을 뽑기 위함 ( 뽑을 때 다시 -1을 곱함 )
        PriorityQueue<Integer> qA = new PriorityQueue<>();
        PriorityQueue<Integer> qB = new PriorityQueue<>();

        for(int i = 0; i < A.length; i++){ // 큐에 값 저장
            qA.add(A[i]);
            qB.add(B[i] * -1);
        }

        while(!qA.isEmpty()){
            answer += qA.poll() * qB.poll() * -1;
        }

        return answer;
    }
}
