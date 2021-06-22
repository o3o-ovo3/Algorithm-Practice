// 프로그래머스 Greedy - 체육복
// 테스트 실패

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> stuSet = new HashSet<>();
        List<Integer> lostStudents = new ArrayList<>();
        List<Integer> reserveStudents = new ArrayList<>();
        
        for(int i = 0; i < lost.length; i++){
            lostStudents.add(lost[i]);
            stuSet.add(lost[i]);
        }
        
        
        for(int j = 0; j < reserve.length; j++){
            if(stuSet.contains(reserve[j]))
                lostStudents.remove(reserve[j]);
            else {
                stuSet.add(reserve[j]);
                reserveStudents.add(reserve[j]);
            }
        }
        
        answer = n - stuSet.size();
        int size = lostStudents.size();
        for(int k = 0; k < size; k++){
            int stu = lostStudents.get(k);
            for(int x = 0; x < reserveStudents.size(); x++){
                if(stu + 1 == reserveStudents.get(x)){
                    reserveStudents.remove(x);
                    answer += 2;
                    break;
                }
                
                if(stu - 1 == reserveStudents.get(x)){
                    reserveStudents.remove(x);
                    answer += 2;
                    break;
                }
            }
        }
        if(!reserveStudents.isEmpty())
            answer += reserveStudents.size();
        return answer;
    }
}
