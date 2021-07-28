// 프로그래머스 level2 - 스킬트리

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<Character> list = new ArrayList<>();
        for (char c : skill.toCharArray()) {
            list.add(c);
        }

        int idx = 0;
        while (idx < skill_trees.length) {
            boolean flag = true;
            int j = 0;
            String str = skill_trees[idx];
            for(int i = 0; i < str.length(); i++){
                if(j >= list.size()) break;
                if(!list.contains(str.charAt(i)))
                    continue;

                else if(list.get(j) == str.charAt(i)){
                    j++;
                    continue;
                }

                else {
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer ++;
            idx++;
        }
        return answer;
    }
}
