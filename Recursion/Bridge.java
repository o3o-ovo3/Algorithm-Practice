// 구름LEVEL - 다리 건너기

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int cnt = 0;
        int slowestIdx = N - 1;
        cnt = escape(array, slowestIdx, cnt);

        System.out.println(cnt);
    }

    // 가장 작은 애들을 보냄
    // 한명이 돌아옴
    // 가장 큰 애들을 보냄
    // 한명이 돌아옴
    // 가장 큰 애들을 보냄

    public static int escape(int[] array, int slowestIdx, int cnt) {
//        // 종료 조건 --> 아무도 남지 않았을 때
//        if(slowestIdx == 0) return cnt;

        // 3명 이하로 남았을 때
        if(slowestIdx == 2) {
            cnt += backPair(array) + array[slowestIdx];
            return cnt;
        } else if(slowestIdx == 1){
            cnt += array[1];
            return cnt;
        } else {
            int case1 = backPair(array) + array[slowestIdx] + array[1];
            int case2 = array[slowestIdx] + array[slowestIdx - 1] + array[0] + array[0];

            cnt += Math.min(case1, case2);
            return escape(array, slowestIdx - 2, cnt);
        }
    }

    public static int backPair(int[] array){
        return array[0] + array[1];
    }
}
