// 프로그래머스 Level2 - N개의 최소공배수

import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }

      // 배열의 값 중 가장 큰 값의 배수 중에서 최소공배수를 찾기
        int cnt = 1;
        while(cnt < 1000000){
            int val = max * cnt;
            for(int i = 0; i < arr.length; i++){
                if(val % arr[i] != 0)
                    break;

                if(i == arr.length - 1)
                    answer = val;
            }
            if(answer != 0)
                break;

            else cnt ++;
        }
        return answer;
    }
}
