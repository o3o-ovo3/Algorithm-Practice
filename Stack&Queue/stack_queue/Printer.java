package stack_queue;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Document> waiting = new LinkedList<Document>();
		Queue<Document> task = new LinkedList<Document>();

		int max = 0;
		int order = 1;
		int size = 0;
        
        // 문서들을 waiting에 넣음
        for (int i = 0; i < priorities.length; i++) {
			waiting.add(new Document(priorities[i], i, 0));
		}
        
        while(true){
            size = waiting.size();
            if (size == 0) { // 종료 조건 : waiting에 아무것도 없을 때
				break;
			}
            
            for (int i = 0; i < size; i++) { // 우선순위가 가장 높은 문서 찾기
				Document doc = waiting.poll();

				if (max == 0)
					max = doc.priority;
				else if (max < doc.priority)
					max = doc.priority;
				waiting.add(doc);
			}
            
            for (int i = 0; i < size; i++) { // 가장 높은 우선순위인 문서를 waiting 큐에서 빼서 task에 저장
				Document doc = waiting.poll();
				if (doc.priority == max) {
					doc.out_order = order;
					task.add(doc);
					order++;
					max = 0;
					break;
				} else {
					waiting.add(doc);
				}
			}
        }
        
        for(Document doc : task){ // location으로 주어진 자리에 있는 문서가 몇번째로 출력되는지 꺼내오기
            if(doc.in_order == location){
                answer = doc.out_order;
            }
        }
        return answer;
    }
    
    class Document {
        int priority;
        int in_order;
        int out_order;
        
        public Document(int priority, int in_order, int out_order){
            this.priority = priority;
			this.in_order = in_order;
			this.out_order = out_order;         
        }
    }
}
