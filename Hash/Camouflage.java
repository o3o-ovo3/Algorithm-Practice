// 프로그래머스 - 해시 <위장> 문제

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList> hm = new HashMap<>();

        // 종류와 이름을 분류해서 map에 저장
        for (int i = 0; i < clothes.length; i++) {
            if (hm.get(clothes[i][1]) == null) { // 종류에 해당하는 key가 없으면
                ArrayList<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                hm.put(clothes[i][1], list);
            } else {
                ArrayList<String> list = hm.get(clothes[i][1]);
                list.add(clothes[i][0]);
                hm.put(clothes[i][1], list);
            }
        }

        for(String key : hm.keySet()){
            answer *= hm.get(key).size() + 1; // 종류별로 들어있는 의상과, 그 분류 중 안입는 경우도 세기 위해 +1을 해줌
            // 한 종류에서 한 가지를 뽑는 경우니까 --> 한 종류에 3개의 의상이 있는 경우 하나를 뽑을 확률은 3, 아무것도 안 뽑는 경우 1 을 더한다.
            // 각 종류안에서의 경우의 수는 +, 종류별로의 조합은 * 연산이다. (경우의 수 공식)
            // 그러니까, 1번 종류에서 하나, 2번 종류에서 하나, 3번 종류에서 하나씩 뽑는 경우는 서로 곱한다.
            // 1번 종류에서 하나를 뽑는 경우의 수는 1 + 1 + 1 ... + 1
        }
        answer -= 1; // 1을 빼주는 이유는 각 종류에서 모두 안입는 경우를 뽑는 경우를 제외하는 것이다.
        return answer;
    }
}
