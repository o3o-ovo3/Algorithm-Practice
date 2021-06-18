// 프로그래머스 레벨2 프린터
// 스택 & 큐에서 이미 했었음 --> 개선

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Doc> waiting = new LinkedList<>();
        Queue<Doc> task = new LinkedList<>();

        int max = 0;
        int cnt = 0;
        int answer = 0;

        for(int i = 0; i < priorities.length; i++)
            waiting.add(new Doc(priorities[i], i, 0));


        while(!waiting.isEmpty()) {
            int size = waiting.size();
            // max값 찾기
            for(int j = 0; j < size; j++){
                Doc doc = waiting.poll();
                if(max == 0 || max < doc.priority)
                    max = doc.priority;
                waiting.add(doc);
            }

            // 가장 큰건 뽑아서 task에 넣기
            for(int k = 0; k < size; k++){
                Doc doc = waiting.poll();
                if(max == doc.priority){
                    doc.outOrder = ++cnt; // 출력 순서 저장
                    task.add(doc); // 출력 큐에 저장
                    max = 0; // max값 초기화
                    break; // 더 이상 뽑지 않음 --> 뽑은거 다음부터 탐색
                }
                else waiting.add(doc); // 큰 값이 아닌 건 다시 waiting에 넣기
            }
        }

        // location의 문서가 몇번째로 출력되는지 구하기
        while(!task.isEmpty()){
            Doc doc = task.poll();
            if(doc.inOrder == location) {// 현재 위치랑 doc의 입력 순서랑 같으면 걔의 출력 순서를 return
                answer = doc.outOrder;
                break;
            }
        }
        return answer;
    }
    
    class Doc{
        int priority;
        int inOrder;
        int outOrder;

        public Doc(int priority, int inOrder, int outOrder){
            this.priority = priority;
            this.inOrder = inOrder;
            this.outOrder = outOrder;
        }
    }
}
