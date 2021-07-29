// 백준 알고리즘 우선순위 큐 - 절댓값 힙
// 시간초과

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<String> list = new ArrayList<>();

        while(N > 0){
            int x = sc.nextInt();
            if(x == 0){
                if(pq.isEmpty())
                    sb.append("0\n");
                else{
                    int value = pq.peek();
                    String strVal = "";
                    if(list.contains(Integer.toString(value * -1))) {
                        sb.append(pq.poll() * -1 + "\n");
                        strVal = Integer.toString(value *= -1);
                        list.remove(strVal);
                    }
                    else{
                        sb.append(pq.poll() + "\n");
                        strVal = Integer.toString(value);
                        list.remove(strVal);
                    }
                }
            }

            else{
                list.add(Integer.toString(x));
                pq.add(Math.abs(x));
            }

            N--;
        }
        System.out.println(sb);
    }
}
