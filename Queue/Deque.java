// 백준 알고리즘 큐 - 덱

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Deque {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        java.util.Deque<Integer> deque = new LinkedList<>();

        while (N-- > 0) {
            String str = br.readLine();
            // 삽입의 경우
            if (str.contains("push")) {
                int intStr = Integer.parseInt(str.replaceAll("[^0-9]", "")); // 숫자만 뽑기

                if (str.contains("front"))
                    deque.push(intStr);

                else
                    deque.offer(intStr); // deque 이기 때문에 뒤에서부터 넣어야됨

                continue;
            }

            switch (str) {
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.poll() + "\n");
                    } else
                        sb.append("-1\n");
                    break;

                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast() + "\n");
                    } else
                        sb.append("-1\n");
                    break;

                case "front":
                    if (!deque.isEmpty())
                        sb.append(deque.peek() + "\n");
                    else
                        sb.append("-1\n");
                    break;

                case "back":
                    if (!deque.isEmpty())
                        sb.append(deque.peekLast() + "\n");
                    else
                        sb.append("-1\n");
                    break;

                case "size":
                    sb.append(deque.size() + "\n");
                    break;

                case "empty":
                    if (!deque.isEmpty())
                        sb.append("0\n");
                    else
                        sb.append("1\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
