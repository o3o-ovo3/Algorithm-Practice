// 백준 알고리즘 브르투포스 - 블랙잭

package baekjoon.brute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Blackjack {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int idx = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        Arrays.sort(arr); // N개의 숫자들을 배열에 넣고 정렬

        int size = arr.length;
        boolean flag = true;
        int max = 0;
        // 가장 큰 숫자 두개를 먼저 뽑아 M과 비교, M보다 작으면 나머지 중 가장 작은 수 부터 뽑아 M에 가까운 max값 찾기
        for(int i = size - 1; i >= 2; i--){
            int sum;
            for(int j = i - 1; j >= 1; j--){
                sum = arr[i] + arr[j];

                if(sum >= M)
                    continue;

                for(int k = 0; k < j; k++){
                    sum =  arr[i] + arr[j] + arr[k];
                    if(sum == M){ // M과 같으면 더이상 찾을 필요가 없으므로 모든 for문을 나올 수 있도록 한다.
                        max = M;
                        flag = false;
                        break;
                    }

                    if(sum > M)
                        break;

                    else if(max < sum){
                        max = sum;
                    }
                }

                if(!flag)
                    break;
            }
            if(!flag)
                break;
        }

        System.out.println(max);
    }
}
