// 프로그래머스 레벨2 순위 검색
// 테스트 케이스 통과, 채점 실패 (런타임 에러) --> 어떻게 해야될지 모르겠다..

package programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        List<Integer> answer = new LinkedList<>();


        String[][] applicant = new String[info.length][5];
        String[][] condition = new String[query.length][5];

        for(int r = 0; r < info.length; r++){
            query[r] = query[r].replaceAll(" and ", " "); // and를 빼주기
            StringTokenizer st = new StringTokenizer(info[r], " "); // 1. info를 2차원 배열로 담기 (지원자 조건)
            StringTokenizer st2 = new StringTokenizer(query[r], " "); // 2. query를 2차원 배열로 담기 (합격자 조건)
            for(int c = 0; c < 5; c++){
                applicant[r][c] = st.nextToken();
                condition[r][c] = st2.nextToken();
            }
        }

        for(int i = 0; i < query.length; i++){ // 합격 조건
            int cnt = 0;
            for(int j = 0; j < info.length; j++){ // 지원자
                for(int c = 0; c < 5; c++){
                    if(condition[i][c].equals("-"))
                        continue;

                    if(c == 4){
                        if(Integer.parseInt(condition[i][c]) > Integer.parseInt(applicant[j][c]))
                            break;
                        else cnt ++;
                    } else {
                        if (!condition[i][c].equals(applicant[j][c]))
                            break; // 지원자가 합격 조건에 하나라도 부합하지 않으면 탈락
                    }
                }
            }
            answer.add(cnt);
        }

        System.out.println(answer);
    }
}
