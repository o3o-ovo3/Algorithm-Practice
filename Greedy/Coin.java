// 백준 알고리즘 그리디 - 동전 0

package baekjoon.greedy;

import java.util.*;

public class Coin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전 종류
        int K = sc.nextInt(); // K원

        List<Integer> list = new ArrayList<>(); // 동전을 담을 리스트
        for(int i = 0; i < N; i++){
            int coin = sc.nextInt();
            if(coin < K) // K의 값보다 동전이 크면 그 동전을 쓸 일이 없으니까 담지 않음
                list.add(coin);
        }

        Collections.sort(list, Collections.reverseOrder()); // 내림차순으로 나열

        int idx = 0;
        int cnt = 0;;
        while(K != 0){
            // 가장 큰 동전부터 사용
            if(list.get(idx) <= K){ // 동전이 K보다 작거나 같은 값이면 그 동전을 쓰고
                cnt ++;
                K -= list.get(idx); // 그 가격만큼 K의 값을 빼줌
            }
            else idx ++;
        }

        System.out.println(cnt);
    }
}
