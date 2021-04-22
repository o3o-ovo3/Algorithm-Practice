// 프로그래머스 - 해시 <위장> 문제
// 테스트 성공, 제출 실패

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int all_kind = 1;
        int size = 0;

        HashMap<String, ArrayList> hm = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            if(hm.get(clothes[i][1]) == null){
                ArrayList<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                hm.put(clothes[i][1], list);
            }
            else{
                ArrayList<String> list = hm.get(clothes[i][1]);
                list.add(clothes[i][0]);
                hm.put(clothes[i][1], list);
            }
        }

        for(String key: hm.keySet()){
            size = hm.get(key).size();
            answer += size; // 그 중 한개 (하나의 종류에서만 하나 선택하는 경우)
            all_kind *= size; // 한 개씩 선택해서 입는 경우 (모든 종류를 하나씩 선택하는 경우)
        }
        if(hm.size() > 1) // 종류가 둘 이상일 때만 모든 종류에서 하나씩 선택한 경우를 더한다.
            answer += all_kind;
        return answer;
    }
}
