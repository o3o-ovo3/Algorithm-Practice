import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Queue<Integer> solution(int[] answers) {
        Queue<Integer> answer = new LinkedList<>();
        
        // 정답지 배열
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞춘 문제 수
        int[] score = {0, 0, 0};
        int cnt = 1;

        // 채점
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == stu1[i % 5])
                score[0]++;
            if(answers[i] == stu2[i % 8])
                score[1] ++;
            if(answers[i] == stu3[i % 10])
                score[2] ++;
        }

        // 맞춘 개수 비교,,
        int max = 0;
        int size = 0;
        if(score[0] > score[1]) {
            answer.add(1);
            max = score[0];
        }
        else if(score[0] < score[1]) {
            answer.add(2);
            max = score[1];
        }
        else if(score[0] == score[1]) {
            answer.add(1);
            answer.add(2);
            max = score[0];
            size = 2;
        }

        if(score[2] > max && size == 2){
            answer.poll();
            answer.poll();
            answer.add(3);
        }
        else if(score[2] > max && size != 1){
            answer.poll();
            answer.add(3);
        }
        else if(score[2] == max){
            answer.add(3);
        }

        return answer;
    }
}
