// 백준 알고리즘 큐 - 요세푸스 문제 0

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            queue.add(i);

        int cnt = 0;
        System.out.print("<");

        while(!queue.isEmpty()){
            cnt ++;
            if(queue.size() > 1){
                if(cnt == K) { // K번째 수 출력
                    System.out.print(queue.poll() + ", ");
                    cnt = 0;
                }
                else queue.add(queue.poll()); // K번째 수가 아니면 뽑아서 뒤로 다시 넣음
            }
            else
                System.out.print(queue.poll() + ">");
        }
    }
}
