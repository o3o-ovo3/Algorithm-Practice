// 백준 알고리즘 브루트포스 - 덩치

package baekjoon.brute;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bulk {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] str;
        int i;
        int j;
        int[][] arr = new int[N][2]; // 2차원 배열
        for(i = 0; i < N; i++){ // 배열에 키, 몸무게 저장
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for(i = 0; i < N; i++){ // 한명씩 모두와 비교
            int rank = 1;
            for(j = 0; j < N; j++){
                if(i == j) // 같은 사람 끼리는 비교하지 않음
                    continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){ // 본인보다 키와 몸무게가 클 때에만 등수를 낮춘다
                    rank++;
                }
                // 본인보다 키와 몸무게가 큰 사람이 없을 경우 그대로 리턴하니까 순위는 1
            }
            sb.append(rank + " ");
        }

        System.out.println(sb);
    }
}

