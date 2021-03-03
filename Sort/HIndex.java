import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int result; // 기준 값과 같거나 큰 경우
        int i = 0;
        
        Arrays.sort(citations);
        
        int com_val = citations[citations.length - 1]; // 기준 값을 가장 큰 값으로
        
        // 기준 값과 인용 횟수 비교
        while (com_val > 0) {
            result = 0;
            for (i = 0; i < citations.length; i++) {
                if (com_val <= citations[i])
                    result++;
            }
            
            if (com_val <= result)
                break;
            else
                com_val--;
        }
        answer = com_val;
        return answer;
    }
}
