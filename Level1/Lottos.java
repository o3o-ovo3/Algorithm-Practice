// 프로그래머스 Level1 - 로또의 최고 순위와 최저 순위
// 개발 도구 없이 풀기

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int correct = 0;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                cnt ++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    correct ++;
                    break;
                }
            }
        }
        
        int max = correct + cnt;
        
        answer[0] = check(max);
        answer[1] = check(correct);
        
        return answer;
    }
    
    public int check(int value){
        switch(value){
            case 6:
                return 1;
                
            case 5:
                return 2;
                
            case 4:
                return 3;
                
            case 3:
                return 4;
                
            case 2:
                return 5;
                
            default:
                return 6;
        }
    }
}
