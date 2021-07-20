// 백준 알고리즘 큐 - 카드

package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
            queue.add(i);

        while(queue.size() != 1){
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }

        System.out.println(queue.poll());
    }
}
