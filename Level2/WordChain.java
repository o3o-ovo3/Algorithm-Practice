// 프로그래머스 레벨2 영어 끝말잇기

import java.util.*;

class Solution {
    public List<Integer> solution(int n, String[] words) {
        List<String> round = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        int cnt = 1;
        int person = 0;

        String prev = "";

        for(String s: words){
            person++;
            if(person > n) {
                person = 1;
                cnt ++;
            }
            if(round.contains(s) || (!prev.equals("") && prev.charAt(prev.length() -1) != s.charAt(0))){
                answer.add(person);
                answer.add(cnt);
                break;
            }

            round.add(s);
            prev = s;
        }
        if(answer.isEmpty()){
            answer.add(0);
            answer.add(0);
        }

        return answer;
    }
}
