// 백준 알고리즘 기본 수학 1 - 부녀회장이 될테야

package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class APT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while(T > 0){
            int k = Integer.parseInt(br.readLine()); // k층
            int n = Integer.parseInt(br.readLine()); // n호
            int[][] apt = new int[k + 1][n + 1]; // k층, n층까지 다 담아야 하니까 1씩 늘려줌
            for(int i = 0; i <= k; i++) { // 층 --> 0층 부터
                int sum = 0;
                for(int j = 1; j <= n; j++) { // 호 --> 1호 부터
                    if(i == 0) { // 0층이면
                        apt[i][j] = j; // j명이 살고있음
                        continue;
                    }
                    else{
                        sum += apt[i-1][j];
                        apt[i][j] = sum;
                    }
                }
            }
            System.out.println(apt[k][n]);
            T--;
        }
    }
}
