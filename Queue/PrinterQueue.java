// 백준 알고리즘 큐 - 프린터 큐

package baekjoon.queue;

import java.util.*;

class Doc{
    int prior;
    boolean check; // 원하는 문서인지 아닌지 확인

    public Doc(int prior, boolean check){
        this.prior = prior;
        this.check = check;
    }
}

public class PrinterQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 테스트 케이스의 수

        while(N > 0){
            Queue<Doc> queue = new LinkedList<>();
            List<Integer> priority = new ArrayList<>(); // 우선순위

            int docs = sc.nextInt(); // 문서의 수
            int loc = sc.nextInt(); // 원하는 문서의 위치
            for(int i = 0; i < docs; i++){ // 큐에 넣기
                int prior = sc.nextInt();
                priority.add(prior);
                Doc doc = null;
                if(i == loc) {
                    doc = new Doc(prior, true);
                    queue.add(doc);
                }
                else{
                    doc = new Doc(prior, false);
                    queue.add(doc);
                }
            }
            Collections.sort(priority, Comparator.reverseOrder()); // 우선순위를 내림차순으로 정렬
            // 큐에서 빼기
            int cnt = 1; // 몇번째로 출력된건지 알아보는 카운터
            while(!queue.isEmpty()){
                int pri = priority.get(0);
                Doc doc = queue.poll();

                if(pri == doc.prior){
                    if(doc.check) {
                        System.out.println(cnt);
                        break; // 출력하고 끝내기
                    }
                    else { // 출력하기
                        cnt++;
                        priority.remove(0); // 출력됐으니까 우선순위 배열에서도 빼기
                    }
                }

                else
                    queue.add(doc);
            }
            N--;
        }
    }
}
