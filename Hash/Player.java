// 완주하지 못한 선수
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 참가자 set에 참가자들 저장 , <이름, 명 수>
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            int cnt = 0; // 동명이인의 수 세기
            Integer value = map.get(participant[i]); // 이전에 이 이름을 가진 사람이 map에 들어갔으면 수가 1 또는 그 이상, 아니면 null --> null을 표현하기 위해 Integer 사용
            if (value != null)
                cnt = value; // 1 또는 그 이상이면 cnt에 0이 아닌 그 수를 저장 (나중에 cnt의 값을 올려서 map에 저장하기 위해)
            map.put(participant[i], ++cnt); // cnt가 0이면 (즉, 그 이름이 저장된 적이 없으면 새로 저장하면서 값은 1이 됨, cnt가 1이상이었으면 하나 올려서 다시 저장)
        }

        for(int j=0; j < completion.length; j++) {
            int cnt = map.get(completion[j]);

            if(cnt != 1)
                map.put(completion[j], --cnt); // 동명이인이 존재하면 한 사람만 빼야하기 때문에 cnt에서 1을 빼고 다시 저장

            else map.remove(completion[j]); // 1이면 (즉, 한사람 뿐이면) 아예 제거
        }

        answer = map.keySet().iterator().next();
        
        return answer;
    }
}
