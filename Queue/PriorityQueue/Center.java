// 백준 알고리즘 우선순위 큐 - 가운데를 말해요
// 시간 초과

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        while(N > 0){
            list.add(sc.nextInt());
            Collections.sort(list);
            int size = list.size();
            if(size % 2 == 0)
                sb.append(list.get(size / 2 - 1) + "\n");

            else
                sb.append(list.get(size / 2) + "\n");
            N--;
        }
        System.out.println(sb);
    }
}
