// 프로그래머스 Level2 - 최소값과 최대값

import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min = 10000;
        int max = -10000;

        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            int newVal = Integer.parseInt(st.nextToken());
            min = Math.min(min, newVal);
            max = Math.max(max, newVal);
        }

        answer = min + " " + max;
        return answer;
    }
}
