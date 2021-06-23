// 프로그래머스 Greedy - 체육복

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashSet<Integer> hs = new HashSet<>();
        List<Integer> noReserve = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        // reserve와 lost에 동시에 있으면
        // 빌려줄 수 없음 --> noReserve에 저장
        for(int i = 0; i < reserve.length; i++){
            boolean possible = true;
            for(int j = 0; j < lost.length; j++){
                if(lost[j] == reserve[i]){
                    possible = false;
                    break;
                }
            }
            if(possible) {// 빌려줄 수 있는 경우
                reserveList.add(reserve[i]);
                hs.add(reserve[i]);
            }
            else
                noReserve.add(reserve[i]);
        }

        // 빌려줄 수 없는 reserve 학생은 lost에 있기 때문 --> noReserve
        // noReserve에 들어있지 않은 학생은 hs에 저장
        for(int k = 0; k < lost.length; k++){
            if(!noReserve.contains(lost[k]))
                hs.add(lost[k]);
        }

        answer = n - hs.size(); // 전체 학생에서 빌려줄 수 있거나, 빌려야되는 애들을 빼면 온전히 자기것이 있는 애들

        while(!reserveList.isEmpty()){
            int reserveStu = reserveList.remove(0);
            boolean checked = false; // 빌려줄 수 있는지 없는지 확인하는 플래그 변수
            // 빌려줄 수 있는지 확인
            for(int lostStu : lost){
                if(!noReserve.contains(lostStu)){
                    if(reserveStu - 1 == lostStu) {
                        answer += 2;
                        noReserve.add(lostStu); // 이미 빌려준 애한테 또 빌려주지 않도록
                        checked = true;
                        break;
                    }

                    else if(reserveStu + 1 == lostStu) {
                        noReserve.add(lostStu);
                        checked = true;
                        answer += 2;
                        break;
                    }
                }
            }
            if(!checked) answer ++; // 빌려줄 수 없는 애들은 각자 체육복이 있으니까 입을 수 있는 애들에 포함
        }
        return answer;
    }
}
