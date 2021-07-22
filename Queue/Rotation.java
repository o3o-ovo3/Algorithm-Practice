// 백준 알고리즘 큐 - 회전하는 큐

package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rotation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 큐에 담긴 개수
        int M = sc.nextInt(); // 뽑을 개수

        LinkedList<Integer> deque = new LinkedList<>(); // 회전하는 큐
        Queue<Integer> target = new LinkedList<>(); // 뽑아야하는 애들

        for(int i = 1; i <= N; i++)
            deque.add(i);

        for(int i = 0; i < M; i++)
            target.add(sc.nextInt());

        int cnt = 0;
        while(!target.isEmpty()){
            // 비교
            if(target.peek() == deque.get(0)) {
                // 같으면 queue2, queue 뽑기
                target.poll();
                deque.remove(0);
            }
            // 다르면 queue 뽑아서 다시 넣기 cnt ++
            else{
                int idx = deque.indexOf(target.peek()); // 뽑아야하는 애의 인덱스 (위치)

                if(deque.size()/2 < idx){ // 뽑아야하는 애의 위치가 끝과 더 가까우면
                    while(deque.get(0) != target.peek()) { // 0번에 올 때 까지 뒤에서 뽑아 앞으로 넣는 것을 반복
                        deque.addFirst(deque.removeLast());
                        cnt++;
                    }
                }
                else{
                    while(deque.get(0) != target.peek()) {
                        deque.addLast(deque.removeFirst());
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
