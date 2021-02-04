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
        
        // �������� waiting�� ����
        for (int i = 0; i < priorities.length; i++) {
			waiting.add(new Document(priorities[i], i, 0));
		}
        
        while(true){
            size = waiting.size();
            if (size == 0) { // ���� ���� : waiting�� �ƹ��͵� ���� ��
				break;
			}
            
            for (int i = 0; i < size; i++) { // �켱������ ���� ���� ���� ã��
				Document doc = waiting.poll();

				if (max == 0)
					max = doc.priority;
				else if (max < doc.priority)
					max = doc.priority;
				waiting.add(doc);
			}
            
            for (int i = 0; i < size; i++) { // ���� ���� �켱������ ������ waiting ť���� ���� task�� ����
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
        
        for(Document doc : task){ // location���� �־��� �ڸ��� �ִ� ������ ���°�� ��µǴ��� ��������
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
