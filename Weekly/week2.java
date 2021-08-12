// 프로그래머스 위클리 챌린지 - 1주차
// 내 코드

class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        int stuNum = scores.length; // 학생 수

        for(int i = 0; i < stuNum; i++){
            int max = 0;
            int maxCnt = 1;

            int min = 101;
            int minCnt = 1;

            int score = 0;
            for(int j = 0; j < stuNum; j++){
                if(scores[j][i] > max){
                    max = scores[j][i];
                } else if(scores[j][i] == max){
                    maxCnt ++;
                }

                if(scores[j][i] < min){
                    min = scores[j][i];
                } else if(scores[j][i] == min){
                    minCnt ++;
                }
                score += scores[j][i];
            }

            if(maxCnt == 1 && scores[i][i] == max){
                score -= max;
                answer += grade(score / (stuNum - 1));
            }

            else if(minCnt == 1 && scores[i][i] == min){
                score -= min;
                answer += grade(score / (stuNum - 1));
            }

            else{
                answer += grade(score / stuNum);
            }
        }
        return answer;
    }
    
    public String grade(int score){
        String grade;
        if(score >= 90)
            grade = "A";

        else if(score >= 80)
            grade = "B";

        else if(score >= 70)
            grade = "C";

        else if(score >= 50)
            grade = "D";

        else
            grade = "F";

        return grade;
    }
}
