import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Queue<Integer> solution(int[] answers) {
        Queue<Integer> answer = new LinkedList<>();

        // 정답지 배열
        int[] stu1 = new int[answers.length];
        int[] stu2 = new int[answers.length];
        int[] stu3 = new int[answers.length];

        // 맞춘 문제 수
        int[] score = {0, 0, 0};
        int cnt = 1;

        // 마킹
        for (int i = 1; i <= answers.length; i++) {
            // 첫번째 학생 마킹
            if (i % 5 != 0)
                stu1[i - 1] = i % 5;
            else
                stu1[i - 1] = 5;

            // 두번째 학생 마킹
            if (i % 2 == 1)
                stu2[i - 1] = 2;
            else {
                stu2[i - 1] = cnt;
                // cnt가 1, 3, 4, 5가 반복되도록
                if (cnt == 5)
                    cnt = 1;
                else
                    cnt++;

                if (cnt == 2)
                    cnt++;
            }

            // 세번째 학생 마킹
            // i값의 일의 자리 숫자가 1, 2 이면 3
            // 3, 4이면 1
            // 5, 6면 2
            // 7, 8이면 4
            // 9, 0이면 5
            if (i % 10 == 1 || i % 10 == 2)
                stu3[i - 1] = 3;
            else if (i % 10 == 3 || i % 10 == 4)
                stu3[i - 1] = 1;
            else if (i % 10 == 5 || i % 10 == 6)
                stu3[i - 1] = 2;
            else if (i % 10 == 7 || i % 10 == 8)
                stu3[i - 1] = 4;
            else
                stu3[i - 1] = 5;
        }

        // 채점
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == stu1[i])
                score[0]++;
            if (answers[i] == stu2[i])
                score[1]++;
            if (answers[i] == stu3[i])
                score[2]++;
        }

        // 맞춘 개수 비교,,
        int max = 0;
        int size = 0;
        if (score[0] > score[1]) {
            answer.add(1);
            max = score[0];
        } else if (score[0] < score[1]) {
            answer.add(2);
            max = score[1];
        } else if (score[0] == score[1]) {
            answer.add(1);
            answer.add(2);
            max = score[0];
            size = 2;
        }

        if (score[2] > max && size == 2) {
            answer.poll();
            answer.poll();
            answer.add(3);
        } else if (score[2] > max && size != 1) {
            answer.poll();
            answer.add(3);
        } else if (score[2] == max) {
            answer.add(3);
        }

        return answer;
    }
}
