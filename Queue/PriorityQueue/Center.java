// 백준 알고리즘 우선순위 큐 - 가운데를 말해요
// 시간 초과 2

package baekjoon.queue;

import java.util.*;

public class Center {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
     
        while(N > 0){
            pq.add(sc.nextInt());
            PriorityQueue<Integer> copy = new PriorityQueue<>();
            copy.addAll(pq);
            int size = pq.size();
            int t;
            if(size == 1)
                t = pq.peek();

            else if(size % 2 == 0)
                t = poll(copy, size / 2, 0);

            else
                t = poll(copy, size / 2 + 1, 0);

            sb.append(t + "\n");
            N--;
        }
        System.out.println(sb);
    }

    public static int poll(PriorityQueue<Integer> pq, int cnt, int result){
        if(cnt != 0){
            int temp = pq.poll();
            result = poll(pq, --cnt, temp);
        }
        return result;
    }
}

