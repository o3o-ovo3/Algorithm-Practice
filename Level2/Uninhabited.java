// 프로그래머스 Level2 - 무인도
// 실패

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int weight = 0;

        for(int i = 0; i < people.length; i++){
            if(people[i] == 0)
                continue;
            else {
                weight += people[i];
                people[i] = 0;
            }
            for(int j = i + 1; j < people.length; j++){
                if(weight == limit){
                    answer ++;
                    weight = 0;
                    break;
                }
                if(people[j] + weight <= limit){
                    weight += people[j];
                    people[j] = 0;
                }
            }
            answer ++;
            weight = 0;
        }
        return answer;
    }
}
