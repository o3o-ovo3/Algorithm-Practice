// 백준 알고리즘 큐 - AC 
// 큐 완성

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Deque;

public class AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        while (T > 0) { // 테스트 케이스 수 만큼 반복
            boolean isReverse = false;
            boolean isError = false;

            String func = br.readLine();
            int n = Integer.parseInt(br.readLine()); // 배열의 개수

            String array = br.readLine();
            array = array.substring(1, array.length() - 1);

            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(array, ",");
            while (st.hasMoreTokens())
                deque.add(Integer.parseInt(st.nextToken()));

            if(n == 0){
                if(func.contains("D"))
                    sb.append("error\n");
                else
                    sb.append("[\n]"); // 개행문자 추가 안해서 틀림

                T--;
                continue;
            }
            int size = func.length();
            for (int i = 0; i < size; i++) {
                if(isError) break;
                switch (func.charAt(i)) {
                    case 'D':
                        if (deque.isEmpty()) {
                            sb.append("error\n");
                            isError = true;
                            break;
                        }

                        else if (!isReverse)
                            deque.pollFirst(); // 앞에서 뽑기

                        else
                            deque.pollLast(); // 뒤집어진 상태면 뒤에서 뽑기
                        break;

                    case 'R':
                        if (isReverse)
                            isReverse = false;
                        else
                            isReverse = true;
                        break;
                }
            }
            if(!isError) {
                sb.append("[");
                if (isReverse) { // 뒤에서부터 출력
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty())
                            sb.append(",");
                    }
                } else { // 앞에서부터 출력
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty())
                            sb.append(",");
                    }
                }
                sb.append("]\n");
            }
            T--;
        }
        System.out.println(sb);
    }
}
