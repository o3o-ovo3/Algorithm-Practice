// 백준 알고리즘 큐 - 큐2

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Queue2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // back을 구하기 위해 deque 사용
        Deque<Integer> queue = new LinkedList<>();

        while(N-- > 0){
            String str = br.readLine();
            if(str.contains("push")){
                queue.offer(Integer.parseInt(str.substring(5))); // deque 이기 때문에 뒤에서부터 넣어야됨
                continue;
            }
            switch (str){
                case "pop":
                    if(!queue.isEmpty()) {
                        sb.append(queue.poll() + "\n");
                    }
                    else
                        sb.append("-1\n");
                    break;

                case "front":
                    if(!queue.isEmpty())
                        sb.append(queue.peek() + "\n");
                    else
                        sb.append("-1\n");
                    break;

                case "back":
                    if(!queue.isEmpty())
                        sb.append(queue.peekLast() + "\n");
                    else
                        sb.append("-1\n");
                    break;

                case "size":
                    sb.append(queue.size()+"\n");
                    break;

                case "empty":
                    if(!queue.isEmpty())
                        sb.append("0\n");
                    else
                        sb.append("1\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
