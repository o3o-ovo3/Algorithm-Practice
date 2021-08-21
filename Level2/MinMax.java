// 프로그래머스 Level2 - 최소값과 최대값

// 1. Math를 이용하여 min, max 구하기
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s, " ");
        
        int min, max;
        min = max = Integer.parseInt(st.nextToken());

        while(st.hasMoreTokens()){
            int newVal = Integer.parseInt(st.nextToken());
            min = Math.min(min, newVal);
            max = Math.max(max, newVal);
        }

        answer = min + " " + max;
        return answer;
    }
}


/*
2. Collections 이용하여 min, max 구하기 --> 더 오래걸림
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        String[] sp = s.split(" ");
        for(String val: sp)
            list.add(Integer.parseInt(val));
        
        answer = Collections.min(list) + " " + Collections.max(list);
        return answer;
    }
}
*/
